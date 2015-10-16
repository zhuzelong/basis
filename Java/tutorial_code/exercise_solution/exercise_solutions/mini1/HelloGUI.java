import java.awt.* ;
import javax.swing.*;
 
public class HelloGUI extends JFrame {

public HelloGUI(String title) { 
  super(title);
  }

public void paint(Graphics g) { 
  super.paint(g);
  g.drawRect(40,30,150,100);
  g.drawString("Hello",70,60);
  g.drawString("World!",100,80);
  }

public static void main(String [] args) {
  JFrame f = new HelloGUI("Hello world example");
  f.setSize(200,200);
  f.setVisible(true);
  }
}
