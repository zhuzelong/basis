package gensim;

/** Interface which should be implemented by any class
 * which provides TBS-specific extensions to customise
 * the simulation for a particular TBS.
 */

public interface TBSExtensions {

  /** Do any application-specific actions. This is called by
  * the SimulationEventHandler when it gets an action it doesn't
  * know about
  */
  public abstract void doApplicationSpecificActions(String action, SimulationFrame f);      
 
 /** Do any initialisation specific to the particular TBS
 */
  public abstract void doApplicationSpecificInitialisation(SimulationFrame f);      
        
} // TBSExtensions