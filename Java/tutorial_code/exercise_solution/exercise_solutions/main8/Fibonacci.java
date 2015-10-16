
/**
 * The Fibonacci sequence.
 *
 */
public class Fibonacci extends NumberSequence {
    
    /**
     * Initial values are (1,1)
     */
    public Fibonacci() {
        super(new long[] {1,1});
    }
    /**
     * Each value is the sum of the previous two.
     */
    protected long definingSum(int i) throws SequenceRangeException {
        return valueAt(i-1) + valueAt(i-2);
    }
    
    /** Return a terse description of the Fibonacci.
     */
    public String toString() {
        return "Fibonacci";
    }
} // Fibonacci