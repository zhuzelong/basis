import java.io.*;
/**
 * A class representing a general notion of number sequence.
 * Subclasses representing particular sequences need only to
 * implement definingSum() to specify how the ith value
 * is calculated, and call one of the constructors via super()
 * to provide initial values, if any.
 */
public abstract class NumberSequence implements Serializable {
    
    // Array holding the values computed so far. This will
    // need to expand as required. The constant INITIAL_STORE_SIZE
    // is the initial size allocated to the array.
    // The array and everything associated with it is private,
    // so that the the user of the class is unaware of its existence.
    private long[] storedValues;
    private int numValuesStored;
    private static final int INITIAL_STORE_SIZE = 10;
    // Maximum permitted index
    private static final int MAX_NUMBERS = 1000000;
    
    /**
     * This constuctor is used when no initial values are required
     */
    public NumberSequence() {
        this(new long[0]);
    }
    
    /** This constructor allows an arbitrary number of initial
     *  values to be provided.
     */
    public NumberSequence(long[] initialValues) {
        if (initialValues.length > INITIAL_STORE_SIZE) {
            storedValues = new long[initialValues.length];
        }
        else {
            storedValues = new long[INITIAL_STORE_SIZE];
        }
        System.arraycopy(initialValues, 0, storedValues, 0, initialValues.length);
        numValuesStored = initialValues.length;
    }
    
    // Utitlity method to calculate and store values of the
    // sequence from those already stored up to index value max.
    protected void calculateUpTo(int max) throws SequenceRangeException {
        // Resize the store until it's big enough. Doubling the size each
        // time gives overall linear-time behaviour.
        while (max >= storedValues.length) {
            this.resizeStore(storedValues.length*2);
        }
        for (int i=numValuesStored; i <= max; i++) {
            // Store each value as we calculate it.
            storedValues[i] = this.definingSum(i);
        }
        if (max >= numValuesStored) {
            numValuesStored = max + 1;
        }
    }
    
    /**
     * The sum which defines the ith element of a sequence.
     * This will be different for each sequence
     */
    protected abstract long definingSum(int i) throws SequenceRangeException;
    
    /** Get a range of values from min to max
     * Precondition: 0 < i <= j
     */
    public long[] getRange(int min, int max) throws SequenceRangeException {
        long[] result = new long[1+max-min];
        for (int i = 0; i < result.length; i++) {
            result[i] = this.valueAt(min+i);
        }
        return result;
    }
    
    /** Get the ith value in the sequence.
     *  Precondition: i >= 0 && i < MAX_NUMBERS
     */
    public long valueAt(int i) throws SequenceRangeException {
        // Calculate more values if necessary.
        if (i < 0 || i >= MAX_NUMBERS) {
            throw new SequenceRangeException(i);
        }
        this.calculateUpTo(i);
        return storedValues[i];
    }
    
    // Resize the store array to the given new size.
    // Pre: newSize >= storedValues.length
    protected void resizeStore(int newSize) {
        long[] newArray = new long[newSize];
        System.arraycopy(storedValues,0,newArray,0,storedValues.length);
        storedValues = newArray;
    }
    
} // NumberSequence
