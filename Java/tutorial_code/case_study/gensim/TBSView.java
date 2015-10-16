package gensim;

import java.awt.Graphics;

/** Interface which should be implemented by any class
 * which implements a view of a TBS - i.e. a way of
 * displaying it to the user.
 */

public interface TBSView {

  /** 
   * Display the TBS on the screen
   */	
  public abstract void display(Graphics g);      
         
  /** 
   * Set the bounds within which the TBS is displayed
   */
  public abstract void setBounds(int minX, int minY, int maxX, int maxY);      
   
} // TBSView