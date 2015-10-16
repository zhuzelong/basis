import java.awt.*;
import javax.swing.*;

/**
 * Display "Hello World" in a rectangle.
 */
public class TestGUIHello extends JFrame
{
    // constructor
    public TestGUIHello(String title)
    {
        super(title);
    }

    // display the words in a rectangle
    public void paint(Graphics g)
    {
        g.drawRect(40, 30, 150, 100);
        g.drawString("hello", 70, 60);
        g.drawString("world", 100, 80);
    }

    public static void main(String[] args)
    {
        JFrame f=new TestGUIHello("Hello world window");
        f.setSize(200, 200);
        f.setVisible(true);
    }
}
