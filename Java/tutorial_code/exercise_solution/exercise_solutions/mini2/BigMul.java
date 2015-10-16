public class BigMul {

  public static void main (String[] oops) {
    // If we multiply ints such that the resulting number is
    // too big to be an int, the top bits get lost and we get
    // the wrong answer - note that there is no error message.
    System.out.println( 10000000 * 10000000 );
    // We can fix this by using longs - but if the number was so
    // big that even longs were too small, the same thing would happen
    System.out.println( 10000000L * 10000000L );
  }
}
