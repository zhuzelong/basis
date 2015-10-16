


/**
 * Class containing the test program.
 */
public class Test {
 
  public static void main(String[] args) {
	try {
	  NumberSequence s1 = new ArithmeticProgression(1000,1000);
	  NumberSequence s2 = new Fibonacci(); 
	  System.out.println(s1 + "[20] = " + s1.valueAt(20));
	System.out.println(s2 + "[-1] = " + s2.valueAt(-1));
	}
	catch (SequenceRangeException e) {
	  System.out.println(e.getMessage());
	}
  }    
} // Test
