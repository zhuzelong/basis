/**
 * A class representing a simple notion of number sequence,
 * with a starting value and an increment which is added each
 * time, i.e an arithmetic progression.
 */
 public class NumberSequence {
	
  private long startingValue;
  private long increment;

  /**
   * Constructor takes the initial value and an increment
   * which define a particular number sequence.
   */
  public NumberSequence(long startingValue, long increment) {
	// set up the initial value and increment.
	this.startingValue = startingValue;
	this.increment = increment;
  }    
  
  /** Get the ith value in the sequence.  
   */
  public long valueAt(int i){
      return startingValue + i*increment;    
  }              

     /** 
      * Return a String representation of a sequence
      */
     public String toString() {
	 return "Sequence(" + startingValue + "," + increment + ")";
     }

     /**
      * Test program
      */
     public static void main(String[] args) {
	 NumberSequence seq1 = new NumberSequence(10, 20);
	 NumberSequence seq2 = new NumberSequence(2, 4);
	 for (int i=0; i<30; i++) {
	     System.out.println("seq1[" + i + "] = " + seq1.valueAt(i));
	     System.out.println("seq2[" + i + "] = " + seq2.valueAt(i));
	 }
     }      
} // NumberSequence
