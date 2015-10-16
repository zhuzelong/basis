/** 
 * Ordinary car 
 */
public class Car extends Vehicle
{
    private String model;

    // constructor
    public Car(String color, String model)
    {
        super(color);
        this.model=model;
    }

    public String getModel()
    {
        return model;
    }

    public void setModel(String model)
    {
        this.model=model;
    }
}//Class Car
