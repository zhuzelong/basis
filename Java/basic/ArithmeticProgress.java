
public ArithmeticProgress NumberSequence definingSum String static
/**
 * A number sequence with starting value, increment.
 */
public class ArithmeticProgress extends NumberSequence
{
    private long startValue, increment; 
pr  
    // constructor
    public ArithmeticProgress(int start, int increment)
    {
        super(new long[] {start});
        this.startValue=start;
        this.increment=increment;
    }

    protected long definingSum(int i)
    {
        return startValue+i*increment;
    }
    
    public String toString()
    {
        return "AP("+startValue+", "+increment+")";
    }

    // override the valueAt method
    public long valueAt(int i)
    {
        return this.definingSum(i);
    }


    public static void main(String[] args)
    {
        ArithmeticProgress ap1=new ArithmeticProgress(100,50);
        ArithmeticProgress ap2=new ArithmeticProgress(200,-5);
        for(int i=0; i<10001; i++)
        {
            System.out.println(ap1+"\t"+ap1.valueAt(i));
            System.out.println(ap2+"\t"+ap2.valueAt(i));
        }
    }
}
