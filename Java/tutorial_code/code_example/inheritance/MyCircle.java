import java.awt.*;

/**
 * A circle shape
 */
public class MyCircle extends Shape
{
    private double radius;
    
    /**
     * Initialize a circle with radius
     */
    public MyCircle(double radius)
    {
        super();
        this.radius=radius;
    }

    /**
     * Calculate the perimeter
     */
    public double perimeter()
    {
        return radius*2*Math.PI;
    }

    /**
     * Calculate the area
     */
    public double area()
    {
        return radius*radius*Math.PI;
    }

    public String toString()
    {
        return "My circle: "+ radius + this.toString();
    }

    /**
     * Test the class
     */
    public static void main(String[] args)
    {
        MyCircle circle=new MyCircle(3.0);
        System.out.println(circle);
        System.out.println(circle.area());
        System.out.println(circle.perimeter());
    }
}

