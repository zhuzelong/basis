package mu.comp60711.wellmeadow;

import java.util.*;
import com.db4o.*;
/** 
 * The common staff working in the hospital
 */
public class Staff extends Person
{
    private String staffNum;
    private String position;
    private String insuranceNum;
    private Contract contract;
    private ArrayList<Qualification> qualis;
    private ArrayList<WorkExperience> workExp;

    // constructor
    public Staff(String firstName, String lastName, String address, String dateBirth, String telNum, Gender gender,
                String staffNum, String position, String insuranceNum)
    {
        super(firstName, lastName, address, dateBirth, telNum, gender); 
        this.position=position; 
        this.insuranceNum=insuranceNum; 
    }

    // getter
    public String getStaffNum() { return staffNum;}
    public String getPosition() { return position;}
    public String getInsuraceNum() { return insuranceNum;}

    // setter
    public void setPosition(String value) { position=value;}
    public void setInsuranceNum(String value) { insuranceNum=value;}
    public void setContract(Contract contract) { this.contract=contract;}

    // add a record of qualification
    public void addQuali(Qualification quali) { qualis.add(quali); }

    // add a working experience
    public void addWorkExperience(WorkExperience exp) { workExp.add(exp); }

    // implement ChargeNurse.allocate()
    public InWardList allocate(Patient patient, Ward ward)
    {
        ObjectContainer db=null;
        try
        {
            // check if there is a vacant bed
            db=Db4o.openFile("Ward.data");
            Ward wards=db.get(ward);
            if(wards.getNumVacantBed()==0)
            {
                System.out.println("There is no vacant bed for now.");
                return;
            }
            db.close();

            //check if the patient is on the waiting list
            db=Db4o.openFile("WaitingList.data");
            WaitingList record=db.get(// insert a predicate here!
            if(!record.getPatient().equals(patient))
            {
                System.out.println("The patient is not on the waiting list, could not put him/her in the ward!");
                return;
            }
            db.close();
        inDate=
        expectOutDate=
        outDate=
        bedNum=
        InWardList wardList=new InWardList(patient, ward, this, inDate, expectOutDate, outDate, bedNum);
        return wardList;
        }
        finally
            if(db!=null)
                db.close();
    }

    // implement ChargeNurse.makeWait()
    public WaitingList makeWait(Patient patient)
    {
        ObjectContainer db=null;
        try
        {
            db=Db4o.openFile("StaffAllocation.data");
            StaffAllocation result=db.get(//insert a predicate here!
            if(result==null)
            {
                System.out.println("You are not in charge of any ward.");
                return;
            }
            wardNum=// input
            waitDate=//input
            expectDuration=//input
            if(!result.getWard().equals(ward)
            WaitingList waitList=new WaitingList(patient, 

}
