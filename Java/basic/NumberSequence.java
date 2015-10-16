/**
 * Number sequence with equal increment
   v2: turn the class into a abstract class
 */
public abstract class NumberSequence
{
    //private long startingValue, increment;
    private static int maxIndex=10000;
    private long[] array;
    private int numArray;
    private static final int SIZE=200;
    
    // This constructor is v1
    //public NumberSequence(long start, long incr)
    //{
    //    this.startingValue=start;
    //    this.increment=incr;
    //    this.array=new long[SIZE];
    //    this.array[0]=start;
    //    this.numArray=1;
    //}

    // v2 constructor, with no initial value.
    public NumberSequence()
    {
        this(new long[0]);
    }

    // v2 constructor, receive arbitary number of initial value.
    public NumberSequence(long[] iniValue)
    {
        if(iniValue.length>SIZE)
            array=new long[iniValue.length];
        else
            array=new long[SIZE];
        for(int i=0; i<iniValue.length; i++)
            array[i]=iniValue[i];
    }

    /** 
     * return the value of given index
     * pre-condition: index>=0 AND index<maxIndex
     */ 
    public long valueAt(int i) throws SequenceRangeException
    {
        // Test whether index is outbound
        if(i<0 || i>=maxIndex)
            throw(new SequenceRangeException(i));
        calUpTo(i);
        return array[i-1];
    }

    // calculate and store the value in the array at the boundary of the given index
    public void calUpTo(int max) throws SequenceRangeException<F2>
    {
        for(int i=1;i<max;i++)
        {
            array[i]=definingSum(i);
            numArray++;
        }
    }

    // show the synopsis of the sequence
    //public String toString()
    //{
    //    String synopsis="Sequence("+startingValue+", "+increment+")";
    //    return synopsis;
    //}

    // define the i-th value of certain sequence
    protected abstract long definingSum(int i) throws SequenceRangeException;

    // main body
    //public static void main(String[] args)
    //{
    //    NumberSequence sequence1=new NumberSequence(5,3);
    //    NumberSequence sequence2=new NumberSequence(200,-1);
    //    long result1=sequence1.valueAt(10);
    //    long result2=sequence2.valueAt(20);
    //    System.out.println(result1+"\t"+result2);
    //}
}

