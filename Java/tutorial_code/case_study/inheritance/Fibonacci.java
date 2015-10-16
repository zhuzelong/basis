/**
 * The Fibonacci sequence.
 * 
 */
public class Fibonacci extends NumberSequence {

  /**
   * Initial values are (1,1)
   */
  public Fibonacci() {
	super(new long[] {1,1});
  }    
  /**
   * Each value is the sum of the previous two.
   */
  protected long definingSum(int i) {
	return valueAt(i-1) + valueAt(i-2);
  }    
  public String toString() {
	return "Fibonacci";
  }    
} // Fibonacci
