/**
 * A class representing a simple notion of number sequence,
 * with a starting value and an increment which is added each
 * time, i.e an arithmetic progression.
 */
 public class NumberSequence {
	
  // Array holding the values computed so far. This will
  // need to expand as required. The constant INITIAL_STORE_SIZE
  // is the initial size allocated to the array.
  // The array and everything associated with it is private,
  // so that the the user of the class is unaware of its existence.
  private long[] storedValues;
  private int numValuesStored;
  private static final int INITIAL_STORE_SIZE = 10;
  
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
	storedValues = new long[INITIAL_STORE_SIZE];
	storedValues[0] = startingValue;
	numValuesStored = 1;
  }    
  
  // Utility method to calculate and store values of the 
  // sequence from those already stored up to index value max.
  private void calculateUpTo(int max) {
	// Resize the store until it's big enough. Doubling the size each
	// time gives overall linear-time behaviour.
	while (max >= storedValues.length) this.resizeStore(storedValues.length*2);
	for (int i=numValuesStored; i <= max; i++)
	  // Store each value as we calculate it.
	  storedValues[i] = startingValue + i*increment;;
	if (max >= numValuesStored) numValuesStored = max + 1;	
  }           

   /** Get a range of values from min to max
   * Precondition: 0 < i <= j
   */
  public long[] getRange(int min, int max) {
	long[] result = new long[1+max-min];
	for (int i = 0; i < result.length; i++)
	  result[i] = this.valueAt(min+i);
	return result;
  }          
  /** Get the ith value in the sequence.  
   *  Precondition: i >= 0
   */
  public long valueAt(int i){    
	// Calculate more values if necessary.
 	this.calculateUpTo(i);
	return storedValues[i];
  }              
  // Resize the store array to the given new size.
  // Pre: newSize >= storedValues.length
  private void resizeStore(int newSize) {
	long[] newArray = new long[newSize];
	System.arraycopy(storedValues,0,newArray,0,storedValues.length);
	storedValues = newArray;
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
