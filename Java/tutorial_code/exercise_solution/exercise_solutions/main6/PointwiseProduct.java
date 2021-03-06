/**
 * Number sequence created from two existing sequences by
 * multiplying the corresponging values
 *
 */
public class PointwiseProduct extends NumberSequence {
    private NumberSequence s1, s2;
    
    /**
     * Constructor simply takes the two dequences to be combined
     * as parameters.
     */
    public PointwiseProduct(NumberSequence s1, NumberSequence s2) {
        super();
        this.s1 = s1;
        this.s2 = s2;
    }
    /**
     * ith value is simply the product of that of the individual
     * sequences.
     */
    protected long definingSum(int i) throws SequenceRangeException {
        return s1.valueAt(i) * s2.valueAt(i);
    }
    
    /** Return a terse description of the PointwiseProduct.
     */
    public String toString() {
        return "Product of " + s1 + " and " + s2;
    }
} // PointwiseProduct
