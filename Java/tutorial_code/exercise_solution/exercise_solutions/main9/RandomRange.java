
import java.util.Random;
/**
 * Random numbers in a range defined as parameters to
 * the constructor.
 *
 */
public class RandomRange extends NumberSequence {
    
    private long minValue, maxValue;
    // A random number object
    private Random rand;
    
    /**
     * Define the range over which the random numbers will
     * be generated.
     * Precondition: 0 <= minValue < maxValue
     */
    public RandomRange(long minValue, long maxValue) {
        super();
        this.minValue = minValue;
        this.maxValue = maxValue;
        // Create a new Random object, with the default seed which
        // is the current time.
        rand = new Random();
    }
    
    /**
     * Generate a random number in the required range.
     */
    protected long definingSum(int i) {
        long range = maxValue - minValue + 1;
        // rand.nextLong() generates a new random number over the
        // whole range of longs.
        return minValue + Math.abs(rand.nextLong()) % range;
    }
    
    /** Return a terse description of the RandomRange.
     */
    public String toString() {
        return "Random, range " + minValue + " to " + maxValue ;
    }
    
} // RandomRange