
import java.util.ArrayList;

/**
 * Class containing multiple number sequences.
 */
public class SetOfNumberSequences {
    
    private ArrayList<NumberSequence> theSequences;
    
    /**
     * Constructor to create an empty SONS.
     */
    public SetOfNumberSequences() {
        theSequences = new ArrayList<NumberSequence>();
    }
    
    /**
     * Add a new sequence
     */
    public void add(NumberSequence seq) {
        theSequences.add(seq);
    }
    
    /**
     * Get the ith sequence
     */
    public NumberSequence get(int i) {
        return theSequences.get(i);
    }
    
    /**
     * The number of sequences currently in the set
     */
    public int numSequences() {
        return theSequences.size();
    }
    
    /**
     * Show what all the sequences are
     */
    public String toString() {
        String result = "Number Sequences\n";
        for (int i=0; i<numSequences(); i++)
            result += this.get(i) + "\n";
        return result;
    }
    
    /**
     * Return an array of all the sequences
     */
    public NumberSequence[] getAll( ) {
        NumberSequence[] result = new NumberSequence[numSequences()];
        for (int i=0; i<numSequences(); i++) {
            result[i] = this.get(i);
        }
        return result;
    }
    
    /**
     * Throw away the sequences
     */
    public void clear() {
        theSequences.clear();
    }
    
    /**
     * Delete the last sequence added, if any.
     */
    public void deleteLast() {
        if (numSequences() > 0) {
            theSequences.remove(numSequences()-1);
        }
    }
    
    /**
     * Test program
     */
    public static void main( String[] args) {
        SetOfNumberSequences s = new SetOfNumberSequences();
        s.add(new ArithmeticProgression(1000,1000));
        s.add(new GeometricProgression(10, 2.0));
        System.out.println(s);
    }
    
} // SetOfNumberSequences
