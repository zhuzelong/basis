package gensim;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * A framework for simple Dialog boxes. Divided into two panels
 * one for messages and one to hold buttons etc.
 */
public class HandyDialog extends JDialog implements ActionListener {
	protected Frame parent;
	
	protected JPanel messagePanel, buttonPanel;
	

	public HandyDialog( JFrame parent, String title, boolean modal ) {
		super( parent, title, modal );
		this.parent = parent;
		this.getContentPane().setLayout( new BorderLayout(15,15));
		this.messagePanel = new JPanel();
		messagePanel.setLayout( new FlowLayout(FlowLayout.CENTER, 15, 15));
		this.getContentPane().add(BorderLayout.CENTER, messagePanel);
		this.buttonPanel = new JPanel();
		buttonPanel.setLayout( new FlowLayout(FlowLayout.CENTER, 15, 15));
		this.getContentPane().add(BorderLayout.SOUTH, buttonPanel );
	}
/** Default action does nothing - will be redefined in subclasses
*/
	public void actionPerformed(ActionEvent e) {}
/** Centre the dialog box in the frame. This must be called
*  after the size has been established, i.e. after the buttons
*  etc. are arranged and pack() is called
*/
	public void centreInFrame() {
	Dimension frame_size = parent.getSize();
	Point frame_location = parent.getLocation();
	int centre_x = frame_location.x + frame_size.width / 2;
	int centre_y = frame_location.y + frame_size.height / 2;;	
  	int xloc = centre_x - this.getSize().width / 2;
	int yloc = centre_y - this.getSize().height / 2;
	this.setLocation(new Point(xloc, yloc));
	this.requestFocus();
	}
	public void display() {
		this.centreInFrame();
		this.setVisible(true);
		this.requestFocus();
	}
}