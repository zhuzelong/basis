(*----------------------------------------------------------------------(C)-*)
(* Copyright (C) 2009-2010 K. Korovin and The University of Manchester. 
   This file is part of iProver - a theorem prover for first-order logic.

   iProver is free software: you can redistribute it and/or modify
   it under the terms of the GNU General Public License as published by
   the Free Software Foundation, either version 3 of the License, or
   (at your option) any later version.
   iProver is distributed in the hope that it will be useful,
   but WITHOUT ANY WARRANTY; without even the implied warranty of
   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  
   See the GNU General Public License for more details.
   You should have received a copy of the GNU General Public License
   along with iProver.  If not, see <http://www.gnu.org/licenses/>.         *)
(*----------------------------------------------------------------------[C]-*)

open Lib

type solver_params = 
    {
     mutable solver                      : string;
     mutable solver_sat_str              : string;
     mutable solver_unsat_str            : string;
     mutable solver_timeout              : float option;     
   }


type status = Sat | Unsat | Unknown


let status_to_string = function 
  |Sat     -> "sat" 
  |Unsat   -> "unsat" 
  |Unknown -> "unknown" 

let string_to_status = function 
  |"sat"     -> Sat
  |"unsat"   -> Unsat 
  |"unknown" -> Unknown 
  |s -> failwith ("string_to_status: "^s^"is not a valid status")
 
type time = Time of float | Timeout

let time_to_string t = 
  match t with
  |Time f -> string_of_float f
  |Timeout -> "timeout"

let string_to_time = function
  |"timeout" -> Timeout
  |s -> Time (float_of_string s)

let cmp_time t1 t2 = 
  match (t1, t2) with 
  |(Time(s1), Time(s2)) -> compare s1 s2
  |(Timeout,Time _)     -> 1
  |(Time _, Timeout)    -> -1
  |(Timeout,Timeout)    -> 0

type result = 
    {
     res_termination_status : termination_status;
     res_status             : status;
     res_time                   : time
   }
(*type result = (termination_status * status *time)*)

let result_to_string res = 
  ((termination_status_to_string res.res_termination_status)^" "
   ^(status_to_string res.res_status)
   ^" time "^(time_to_string res.res_time))

let string_to_result s = 
  let str_list = (Str.split (Str.regexp " ") s) in 
  match str_list with 
  |[term_stat_str;term_stat_val;status;"time";time] ->
      {
       res_termination_status = (parse_termination_status (term_stat_str^" "^term_stat_val));
       res_status             = (string_to_status status);
       res_time               = (string_to_time time)
     }

  |_-> failwith ("string_to_result: "^s^"is not a valid result string")

(* less time better result *)
let cmp_results res1 res2 = -(cmp_time res1.res_time res2.res_time)
 
let check_consistency res1 res2 =
  match (res1.res_status,res2.res_status) with 
  |(Unknown,_) |(_,Unknown) -> true
  | _ -> res1.res_status = res2.res_status


(*----Some statistics---------------*)
let get_all_sat result_list =
  List.filter (fun res -> match res.res_status with Sat -> true |_-> false)  result_list

let get_all_unsat result_list =
  List.filter (fun res -> match res.res_status with Unsat -> true |_-> false)  result_list

let get_all_unknown result_list =
  List.filter (fun res -> match res.res_status with Unknown -> true |_-> false)  result_list

let get_all_killed result_list =
  List.filter 
    (fun res -> 
      match res.res_termination_status with Ubnormally_Terminated _ -> true |_-> false)  result_list


let get_average_time result_list =
  let sum_time = 
    List.fold_left 
      (fun rest res -> 
	match res.res_time with 
	|Time t -> rest+.t
	|_-> rest) 
      0. result_list 
  in
  if result_list = [] 
  then 0.
  else
    truncate_n 4 (sum_time/.(float_of_int (List.length result_list)))


let out_stat result = 
  let sat     = get_all_sat result in
  let unsat   = get_all_unsat result in
  let unknown = get_all_unknown result in
  let killed  = get_all_killed result in 
  ("sat: "^(string_of_int (List.length sat))
   ^" avg. "
   ^(string_of_float (get_average_time sat))
   ^" unsat: "^(string_of_int (List.length unsat))
   ^" avg. "
   ^(string_of_float (get_average_time unsat))
   ^" unknown: "^(string_of_int (List.length unknown))
   ^" killed: "^(string_of_int (List.length killed))	   
  )	   

(*
let get_num_of_sat result_list = 
  List.fold_left 
    (fun rest (stat,time) -> 
      match time with 
      |Time _ -> 
*)

(*-------------------------------------------*)
(* solver string includes all solver options *)
let solver_base_cmd_args solver_params =
  let solver_cmd =  (Str.split (Str.regexp " ") solver_params.solver) in
  try
(*    if (Sys.file_exists (List.nth solver_cmd 0)) 
    then *)
(* we need this time command (not default bash time) the output is user_time number in seconds *)
(*      [time_cmd;"-f";"user_time %U"]@solver_cmd*)
      solver_cmd
(*    else 
      failwith 
	("cannot find solver: "^(solver_params.solver))*)
  with _->  
    failwith 
	("cannot find solver: "^(solver_params.solver))
    

(*--Parse time solver output---------*)
(*--outputs (status_line,user_time) --*) 
let parse_solver_output solver_params in_channel =
  let succ = ref false in
  let result = ref Unknown in
  try 
    while (not !succ) 
      do
      let next_line =  (input_line in_channel) in
(*      out_str ("next_line: "^next_line^"\n"); *)
      if (next_line = solver_params.solver_sat_str) 
	then
	(succ:=true; 
	 result:=Sat)
      else
	if (next_line = solver_params.solver_unsat_str) 
	  then
	  (succ:=true; 
	   result:=Unsat)
	else ()
    done;
    !result
  with 
    End_of_file -> 
      (
       Unknown
      ) 
	
 
(*---Can raise Timeout_real-------*)
let run_solver_channel solver_params fun_out =
  set_timer (get_some solver_params.solver_timeout);
  let solver_cmd_args =  Array.of_list (solver_base_cmd_args solver_params) in
  let solver_cmd = solver_cmd_args.(0) in
  let (in_descr,out_descr) = Unix.pipe () in   
  Unix.set_close_on_exec out_descr;
  let out_channel = Unix.out_channel_of_descr out_descr in
  let in_channel  = Unix.in_channel_of_descr in_descr in
  let (in_res_descr,out_res_descr) = Unix.pipe () in 
  Unix.set_close_on_exec out_res_descr;
  let in_res_channel = Unix.in_channel_of_descr in_res_descr in
  let out_res_channel = Unix.out_channel_of_descr out_res_descr in    
  try
    let start_time = (Unix.times ()).Unix.tms_cutime in
    (* out_str ("Solver Start Time: "^(string_of_float start_child_time)^"\n");*)
(*    out_str "Waiting for solver to terminate...\n";*)
  (*  let (in_channel,out_channel) = Unix.open_process solver_params.solver in      	
      open_in_chan_list:= in_channel::!open_in_chan_list;
    open_out_chan_list:= out_channel::!open_out_chan_list;*)
    let pid = 
      create_process_newgr 
 	(solver_cmd) 
 	(solver_cmd_args)
(*	("test_io.native")
	(Array.of_list ["test_io.native"])*)
 	(*Unix.stdin *)
 	in_descr
(*	Unix.stdout*)
	out_res_descr
 	Unix.stderr
    in
    add_child_process pid;   
    fun_out out_channel; 
    flush out_channel;
(*    close_in in_channel; *)
    close_out out_channel;
 
(*    out_str "Waiting.. "; *)
    let (_pid,unix_process_status) =  Unix.waitpid [] pid in 
(*    check_process_status "solver" process_status;*)
    let process_status = check_process_status unix_process_status in
(*    out_str "Finished.. ";*)
      close_in in_channel; 
(*    close_out out_res_channel;*)
      flush out_res_channel;
      close_out out_res_channel;
      let status = parse_solver_output solver_params in_res_channel in      


(*    close_in in_channel; *)
      close_in in_res_channel;
    
   (* let _process_status = Unix.close_process  (in_channel,out_channel) in*)
      let end_time = (Unix.times ()).Unix.tms_cutime in
      let run_time = end_time -. start_time in
(*      out_str ("Solver End Time: "^(string_of_float end_child_time)^"diff: "^(string_of_float (end_child_time -. start_child_time))^"\n");*)
      reset_timer (); 
  (*  out_str (" result "^(result_to_string (status,Time(run_time)))^"\n");*)
      
	{
	 res_termination_status = process_status;
	 res_status             = status; 
	 res_time               = Time(truncate_n 1 run_time)
       }
  with 
    Time_out_real ->
      (
(*       out_str "solver_run timeout\n";*)
       close_in in_channel;

(*    close_in in_channel; *)
       close_in in_res_channel;	 
(*       remove_top_child_process ();*)
       kill_all_child_processes ();
       close_out out_channel;
       close_out out_res_channel;
       {
	res_termination_status = Normally_Terminated (0);
	res_status             = Unknown;
	res_time               = Timeout
      }
      )


let in_to_out_channel in_ch out_ch = 
  try 
    while true do
      output_char out_ch (input_char in_ch) 
    done 
  with 
    End_of_file -> ()
	
let run_solver_file solver_params file_name = 
    let in_channel = open_in file_name in
    let result =  
      run_solver_channel solver_params (in_to_out_channel in_channel) in
    close_in in_channel;
    result
