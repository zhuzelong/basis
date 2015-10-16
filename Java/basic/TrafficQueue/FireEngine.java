/**
 * Fire engine is a special type of vehicle which can insert the queue from head.
 */
public class FireEngine extends Vehicle
{
    private String status;
    
    // constructor
    public FireEngine()
    {
        super("red");
        this.status="Fire engine";
    
    }

    // turn the fire engine's statuns into code blue
    public void goBlue()
    {
        this.status="Fire engine: CODE BLUE";
    }

    // turn the fire engine's status back to normal
    public void shutBlue()
    {
        this.status="Fire engine";
    }
    
    public String getStatus()
    {
         return status;
    }
}
