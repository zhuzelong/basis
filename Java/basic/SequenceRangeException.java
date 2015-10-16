import java.lang.*;

/**
 * A exception dealing with index of sequence outbound, notify the user about the issue.
 */
public class SequenceRangeException extends Exception 
{
    /**
     * Constructor receive the outbound index and notify the user.
     */
    SequenceRangeException
    public SequenceRangeException(int index)
    {
        super(index+" is out of bound.");
    }
}
