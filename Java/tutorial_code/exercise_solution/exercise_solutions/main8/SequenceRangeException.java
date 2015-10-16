
/**
 * Exception indicating that the sequence number requested
 * was <= 0 or > maxNumbers.
 *
 */
public class SequenceRangeException extends Exception {
    
    /**
     *  Set up the string held by the exception to indicate
     * the problem.
     */
    public SequenceRangeException(int index) {
        super("Sequence index " + index + " out of range");
    }
    
} // SequenceRangeException