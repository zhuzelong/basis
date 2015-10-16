package gensim;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 * Dialog to select from a list of strings.
 * 
 */
public class ListDialog extends HandyDialog {
  private JComboBox theList;
  private String[] allItems;
  private String itemSelected = "";

public ListDialog( JFrame parent, String msg, String[] items ) {
	super(parent, "", true);
	this.allItems = items;
	messagePanel.add(new JLabel(msg));
	theList = new JComboBox(items);
	theList.setSelectedItem(items[0]);
	theList.addActionListener(this);
 	buttonPanel.add(theList);
	//JButton okButton = new JButton("OK");
	//buttonPanel.add(okButton);
	//okButton.addActionListener(this);
	//okButton.requestFocus();
	JButton cancelButton = new JButton("Cancel");
	buttonPanel.add(cancelButton);
	cancelButton.addActionListener(this);
	this.pack();
	this.centreInFrame();
}
/**
 * Return the selected option, or an empty string if
 * the user hit cancel.
 * @param e java.awt.event.ActionEvent
 */
public void actionPerformed(ActionEvent e) {
	String cmd = e.getActionCommand();
	if (cmd.equals("Cancel"))
	this.itemSelected = "";
	else this.itemSelected = (String)theList.getSelectedItem();	
	this.dispose();
}
/**
 * Return the item selected. Relies on the dialog blocking to ensure
 * that a sensible value is returned.
 */
public String getItemSelected() {
	return this.itemSelected;
}
}