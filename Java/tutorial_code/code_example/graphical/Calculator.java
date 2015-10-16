import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
* The class where the actual sums are performed. It handles the events
* generated by the function panel.
*/
public class Calculator implements ActionListener {

// We need references to
// - the parent frame, so we can pop up dialog boxes
// - the entry panel so we can get the numbers and set the result.
private CalcFrame theFrame;
private EntryPanel entries;

/** Create the calculator object, 
* providing the references to the frame, and the entry panel.
*/
public Calculator(CalcFrame theFrame, EntryPanel entries) {
  this.theFrame = theFrame;
  this.entries = entries;
}

/**
* Handlle the events from the function buttons, i.e. do the sums
*/
public void actionPerformed(ActionEvent event) {
  try {
    // Get the numbers
    int x = entries.getNumber1();
    int y = entries.getNumber2();

    // getActionCommand() returns a string which provides a simple way of identifying
    // the button which was pressed. 
    String cmd = event.getActionCommand();

    // Remember that comparisons of Strings must be done with .equals(), not ==
    if (cmd.equals("Add")) entries.setResult(x + y);
    else if (cmd.equals("Subtract")) entries.setResult(x - y);
    else if (cmd.equals("Multiply")) entries.setResult( x * y);
    else if (cmd.equals("Divide")) {
       // Trap divide-by-zero. tellUser() is a method, inherited by CalcFrame from
       // quitableJFrame, which pops up a dialog box giving a message to the user.
       if (y == 0) theFrame.tellUser("Can't divide by zero");
       else entries.setResult(x / y);
       }
  }
  // Catch the exception which occurs if either of the text fields contains a non-integer.
  // This is a very nice example of exception handling, as we can do it in exactly
  // one place, and also the most convenient place.
  catch (NumberFormatException e) {
    theFrame.tellUser("Non-integer entered: " + e.getMessage());
  }
} // actionPerformed()

} // Calculator