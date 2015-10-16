/**
 * Number sequence with exponential increment.
 */
public class GeometricProgress extends NumberSequence
{
    private long startValue;
    private int factor;

    // constructor
    public GeometricProgress(long start, int factor)
    {
        super(new long[] {start});
        this.startValue=start;
        this.factor=factor;
    }

    protected long definingSum(int i)
    {
        return (long)(startValue+Math.pow((double)i, factor));
    }

    public long valueAt(int i) throws SequenceRangeException
    {
        return definingSum(i);
    }

    public String toString()
    {
        return "GP("+startValue+", "+factor+")";
    }

    public static void main(String[] args) throws SequenceRangeException
    {
        GeometricProgress gp1=new GeometricProgress(10,2);
        GeometricProgress gp2=new GeometricProgress(4,4);
        System.out.println(gp1+"\t"+gp1.valueAt(100002));
        System.out.println(gp2+"\t"+gp2.valueAt(10));
    }
}

