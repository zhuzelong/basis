import java.util.*;
import java.io.*;

public class trafficqueue
{
    public static Car[] queue;
    public static int head;
    public static int rear;
    public static final short SIZE=100;

    // initiate the queue
    public trafficqueue()
    {
        rear=head;
    }

    public Boolean isFull()
    {
        if((rear+1)%SIZE==head)
            return true;
        else
            return false;
    }

    public Boolean isEmpty()
    {
        if(rear==head)
            return true;
        else
            return false;
    }

    public Boolean push(Car vehicle)
    {
        if(!isFull())
        {
            rear++;
            queue[(rear+1)%SIZE]=vehicle;
            return true;
        }
        else
            {
                System.out.println("The queue is full. Cannot push car.\n");
                return false;
            }
    }
    
    public Boolean pop()
    {
        if(!isEmpty())
        {
            head=(head+1)%SIZE;
            return true;
        }
        else 
            {
                System.out.println("The queue is empty. Cannot pop car.\n");
                return false;
            }
    }


         
    public static void main(String[] args)
    {
        String color;
        trafficqueue queue=new trafficqueue();
        //System.out.println("please enter the command: ");
        //Scanner input=new Scanner(System.in);
        //String cmd=input.nextLine();
        //System.out.println(cmd);
        
        Scanner input=new Scanner(System.in);
        while(true)
        {
            System.out.println("Please enter the command: ");
            String cmd=input.nextLine();
            System.out.println(cmd);
            if(cmd=="push")
            {
                System.out.println("Please enter the color.\n");
                color=input.nextLine();
                Car testCar=new Car(color);
                queue.push(testCar);
            }
            if(cmd=="quit")
                break;
        }
    }
}

class Vehicle
{
    public String color;
}

class Car 
{
    public String color;
    
    public Car(String color)
    {
        this.color=color;
    }

    public String getColor()
    {
        return this.color;
    }
}
        
