
/**
 * A class representing a simple notion of number sequence.
 * Which has a starting value and adds an increment each time.
 */
public class NumberSequence {
    
    private long startingValue, increment;
    
    /**
     * Constuctor takes a starting value and increment for the sequence.
     */
    public NumberSequence(long startingValue, long increment) {
        this.startingValue = startingValue;
        this.increment = increment;
    }
    
    /** Get the ith value in the sequence.
     */
    public long valueAt(int i) {
        return startingValue + i*increment;
    }
    
    public static void main(String[] args) {
        NumberSequence s1 = new NumberSequence(2,5);
        NumberSequence s2 = new NumberSequence(10,10);
        for (int i=0; i<30; i++) {
            System.out.println("s1[" + i + "] = " + s1.valueAt(i));
            System.out.println("s2[" + i + "] = " + s2.valueAt(i));
        }
    }
} // NumberSequence
