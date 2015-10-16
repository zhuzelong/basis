/**
 * Test the function of Rectangle class and display class, to find out the details of the reference and object.
 */
public class TestRectangle
{
    public static void main(String[] args)
    {
        /**
         * Create a rectangle and verify the reference.
         */
        int width=10, height=8;
        Rectangle r1=new Rectangle(width, height);
        Rectangle r2=r1;
        System.out.println(r1.toString()+"\n"+r2.toString());
        System.out.println(r1==r2);
        r1.setHeight(12);
        r2.setWidth(20);
        System.out.println(r1.toString()+"\n"+r2.toString());
        System.out.println(r1==r2);

        /**
         * Verify the display class with rectangle above.
         */
        Display graph=new Display(width, height);
        graph.addRectangle(r1);
        graph.repaint();
        //graph.removeRectangle();
        //graph.repaint();
    }
}
