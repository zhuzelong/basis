/** 
 * traffic queue contains ordinary car and fire engine.
 */
public class TrafficQueue
{
    private Vehicle[] queue;
    private int head, rear;
    private int numVehicle;

    // constructor
    public TrafficQueue()
    {
        this(0);
    }

    // constructor 2
    public TrafficQueue(int length)
    {
        queue=new Vehicle[length];
        head=0;
        rear=0;
        numVehicle=0;
    }

    public Boolean isEmpty()
    {
        if(head==rear)
            return true;
        else
            return false;
    }

    public Boolean isFull()
    {
        if((rear+1)%this.queue.length==head)
            return true;
        else
            return false;
    }

    public void push(Car car)
    {
        if(this.isFull())
            return;
        rear=(rear+1)%this.queue.length;
        this.queue[rear]=car;
        numVehicle++;
    }

    public void push(FireEngine fireEngine)
    {
        if(this.isFull())
            return;
        if(fireEngine.getStatus()=="Fire engine: CODE BLUE")
        {
            head=(head-1)%this.queue.length;
            this.queue[head]=fireEngine;
            numVehicle++;
        }
        else
        {
            rear=(rear+1)%this.queue.length;
            this.queue[rear]=fireEngine;
            numVehicle++;
        }
    }

    public void pop()
    {
        if(this.isEmpty())
            return;
        head=(head+1)%this.queue.length;
        numVehicle--;
    }

    public void showQueue()
    {
        System.out.println("The queue has "+numVehicle+"vehicles");
        for(int i=head; i<numVehicle; i++)
            System.out.println(queue[i].getColor());
    }
}

