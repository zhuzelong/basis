
import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;
import gensim.*;

/**
 * Class containing multiple number sequences. Since this
 * implements ThingBeingSimulated, it needs to keep track of
 * the current step number, current value of each sequence etc.
 * as well as simply containing the sequences themselves.
 */
public class SetOfNumberSequences implements ThingBeingSimulated {
    
    private ArrayList<NumberSequence> theSequences;
    
    // Current step number
    private int n = 1;
    
    // Boundary within which we'll display the sequences.
    private int minX, minY, maxX, maxY;
    
    // Current value of each sequence
    private long[] sequenceValue;
    
    /**
     * Constructor to create an empty SONS.
     */
    public SetOfNumberSequences() {
        theSequences = new ArrayList<NumberSequence>();
        // This will work in practice, although really
        // sequenceValue should he an ArrayList too.
        sequenceValue = new long[100];
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
    public int numSequences() { return theSequences.size(); }
    
    /**
     * Show what all the sequences are
     */
    public String toString() {
        String result = "Number Sequences\n";
        for (int i=0; i<numSequences(); i++) {
            result += this.get(i) + "\n";
        }
        return result;
    }
    
    /**
     * Return an array of all the sequences
     */
    public NumberSequence[] getAll( ) {
        NumberSequence[] result = new NumberSequence[numSequences()];
        for (int i=0; i < numSequences(); i++) {
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
     * Display the current values of the sequences on the screen.
     */
    public void display(Graphics g) {
        g.setColor(Color.black);
        int textStart = minX + 10;
        g.drawString("Step " + (n-1),  textStart, minY );
        if (numSequences() > 0) {
            int spacePerSequence = (maxY - (minY+20)) / numSequences();
            int y = minY + 20;
            float scaleBy = this.scalingFactor();
            for (int i=0; i< numSequences(); i++) {
                g.drawString(get(i).toString(), textStart, y );
                g.drawString(sequenceValue[i] + "", textStart, y+15);
                g.setColor(Color.red);
                g.fillRect(minX, y+20, (int)(sequenceValue[i]*scaleBy), 20);
                g.setColor(Color.black);
                y += spacePerSequence;
            } // for
        } // if
    }
    
    /**
     * Return an empty - not null - SONS
     */
    public ThingBeingSimulated emptyThing() {
        return new SetOfNumberSequences();
    }
    
    /**
     * Reset the step counter.
     */
    public void resetCounter() {
        n = 1;
    }
    // Utility method to figure out the scale for drawing bars, so that
    // the largest bar takes between (width/2) and width.
    // Multiply each value by this to get the length of the
    // bar. Needs to be a float, because for large values it will
    // be < 1.
    protected float scalingFactor() {
        int width = (maxX - minX) - 10;
        long maxValue = 0;
        for (int i=0; i<numSequences(); i++) {
            if (sequenceValue[i] > maxValue) maxValue = sequenceValue[i];
        }
        float scale = (float)1.0;
        // At least one of the following loops will zero-trip.
        // otherwise something has gone badly wrong.
        while (maxValue > width)  {
            maxValue /=2;
            scale /= 2;
        }
        if (maxValue > 0) {
            while (maxValue < (width/2)) {
                maxValue *= 2;
                scale *= 2;
            }
        }
        return scale;
    }
    // The methods required by the ThingBeingSimulated interface.
    
    /**
     * Set the bounds within which the sequences will be displayed.
     */
    public void setBounds(int minX, int minY, int maxX, int maxY) {
        this.minX = minX;
        this.minY = minY;
        this.maxX = maxX;
        this.maxY = maxY;
    }
    
    /** Perform a single step of simulation. Throws a SimulationException
     * if a SequenceRangeException occurs so the user can be informed.
     */
    public void simstep() throws SimulationException {
        try {
            for (int i = 0; i < numSequences(); i++) {
                sequenceValue[i] = get(i).valueAt(n-1);
            }
            n++;
        }
        catch (SequenceRangeException e) {
            throw new SimulationException(e.getMessage() );
        }
    }
    
    /**
     * Return an example SONS, for demo purposes.
     */
    public ThingBeingSimulated typicalThing() {
        SetOfNumberSequences s = new SetOfNumberSequences();
        s.add(new ArithmeticProgression(1000,1000));
        s.add(new Fibonacci());
        return s;
    }
    
    /**
     * The application-specific actions are to add a new number
     * sequence or to delete the last one added.
     */
    public void doApplicationSpecificActions(String s, SimulationFrame frame) {
        if (s.equals("Add...")) {
            NumberSequence newSeq = this.getSequenceFromUser("Choose a sequence", frame);
            if (newSeq!= null) this.add(newSeq);
            frame.repaint();
        }
        else if (s.equals("Delete")) {
            this.deleteLast();
            frame.repaint();
        }
        else {
            frame.tellUser(s + " action not implemented");
        }
    }
    /**
     * Add items to the edit menu to add and delete sequences.
     */
    public void doApplicationSpecificInitialisation(SimulationFrame f) {
        SimulationMenuBar.addItems(
        f.getSimMenuBar().getEditMenu(),
        new String[] { "Add...", "Delete" },
        f.getHandler());
    }
    
    // Utility method to allow the user to specify a sequence to
    // be added. It's not ideal to have user interface code in
    // here - a tradeoff for having a relatively simple overall design
    protected NumberSequence getSequenceFromUser(String msg, SimulationFrame frame) {
        String[] options = new String[] {"arithmetic", "primes", "fibonacci", "pointwise"};
        
        // We're using JOptionPane.showInputDialog here, despite the
        // fac that the list variant doesn't work properly.
        // Presumably it will in future versions, and we don't want
        // to reinvent any wheels.
        String choice = (String)JOptionPane.showInputDialog(frame.getDisplayPanel(),
            msg, "Sequence selection", JOptionPane.QUESTION_MESSAGE,
            null, options, options[0]);
        
        NumberSequence result = null;
        if (choice == null) {
            return null;
        }
        else if (choice.equals("primes")) {
            result = new Primes();
        }
        else if (choice.equals("fibonacci")) {
            result = new Fibonacci();
        }
        else if (choice.equals("arithmetic")) {
            int initialValue = frame.getValueFromUser(
                "initial value for arithmetic progression", 0);
            int increment = frame.getValueFromUser(
                "increment for arithmetic progression", 10);
            result = new ArithmeticProgression(initialValue, increment);
        }
        else if (choice.equals("pointwise")) {
            NumberSequence left = this.getSequenceFromUser("left subsequence", frame);
            NumberSequence right = this.getSequenceFromUser("right subsequence", frame);
            result = new PointwiseProduct(left, right);
        }
        return result;
    }
    
    
    /**
     * Test program
     */
    public static void main( String[] args) {
        SetOfNumberSequences s = new SetOfNumberSequences();
        s.add(new ArithmeticProgression(1000,1000));
        s.add(new Fibonacci());
        s.add(new Primes());
        System.out.println(s);
    }
    
} // SetOfNumberSequences
