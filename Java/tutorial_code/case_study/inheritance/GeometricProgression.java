/**
 * A geometric progression, very similar to the AP but
 * with a different defining sum. 
 */

public class GeometricProgression extends NumberSequence {
  // We have a starting value and a factor this time
  private long startingValue;
  private double factor;
	
  /**
   * Constructor for geometric progressions takes an initial
   * value and an factor.
   */
  public GeometricProgression(long startingValue, double factor) {
	// Call the superclass constructor to do its stuff..
	super(new long[] {startingValue} );
	// and then set up the initial value and factor.
	this.startingValue = startingValue;
	this.factor = factor;
  }    
  /**
   * Calculate the ith value of an Geometric progression.
   */
  protected long definingSum(int i) {
	return (long)(startingValue * Math.pow(factor,(double)i));
  }     

 
  /** Return a terse description of the G.P.
  */
  public String toString() {
	return "GP(" + startingValue + "," + factor + ")";
  }    

  /**
  * Test program
  */
   public static void main(String[] args) {
	GeometricProgression s1 = new GeometricProgression(1,2.0);
	GeometricProgression s2 = new GeometricProgression(100, 1.1);
 	for (int i=0; i<30; i++) {
	System.out.println(s1 + "[" + i + "] = " + s1.valueAt(i));
 	System.out.println(s2 + "[" + i + "] = " + s2.valueAt(i));
	}
  }    



} // GeometricProgression
