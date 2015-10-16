
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
    
    /** Return a terse description of Fibonacci.
     */
    public String toString() {
        return "Fibonacci";
    }
    
    /**
     * Test program to check out exception handling.
     */
    public static void main(String[] args) {
        try {
            Fibonacci fib = new Fibonacci();
            for (int i=0; i<30; i++) {
                System.out.println("Fib[" + i + "] = " + fib.valueAt(i));
            }
            long bang = fib.valueAt(-1);
        }
        catch (SequenceRangeException e) {
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println("That's all, folks");
        }
    }
} // Fibonacci
