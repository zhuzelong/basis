/**
 * Test polymorphism, using GeometricProgress and ArithmeticProgress class.
 */
public class TestPoly
{
    public static void main(String[] args)
    {
        try
        {
            NumberSequence nq1=new GeometricProgress(10,4);
            NumberSequence nq2=new ArithmeticProgress(40,21);
            System.out.println(nq1+"\t"+nq1.valueAt(10001));
            System.out.println(nq2+"\t"+nq2.valueAt(30));

        }
        catch(SequenceRangeException e)
        {
            System.out.println(e.getMessage());
        }
    }
}

