
/**
 * Class representing the sequence of prime numbers.
 *
 */
public class Primes extends NumberSequence {
    
    /**
     * Start off with as many initial primes as we feel like.
     */
    public Primes() {
        super(new long[] { 2, 3, 5, 7, 11, 13, 17 });
    }
    /**
     * Since we have all the previous values stored anyway, we can
     * calculate the ith number by checking whether any of the
     * previous ones divide it, i.e. that well-known algorithm
     * Thingy's Sieve.
     */
    protected long definingSum(int i) throws SequenceRangeException {
        // Check odd numbers only.
        long candidate = this.valueAt(i-1) + 2;
        boolean primeFound = false;
        while (!primeFound) {
            primeFound = true;
            // Stop when we get so sqrt(candidate);
            int root = (int)(Math.sqrt((double)candidate)) + 1;
            for (int j=2; j< root; j++) {
                long factor = this.valueAt(j-1);
                if (candidate % factor == 0) { // Not prime.
                    primeFound = false;
                    break;
                } // if
            } // for
            if (!primeFound) {
                candidate += 2;
            }
        } // while
        // Eventually...
        return candidate;
    }
    
    /** Return a terse description of the Primes.
     */
    public String toString() {
        return "Primes";
    }
    
} // Primes