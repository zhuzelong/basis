
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
    protected long definingSum(int i) {
        return valueAt(i-1) + valueAt(i-2);
    }
    
    /** Return a terse description of the Fibonacci
     */
    public String toString() {
        return "Fibonacci";
    }
    
    /**
     * Test program to check out exception handling.
     */
    public static void main(String[] args) {
        Fibonacci fib = new Fibonacci();
        for (int i=0; i<30; i++) {
            System.out.println("Fib[" + i + "] = " + fib.valueAt(i));
        }
    }
} // Fibonacci
