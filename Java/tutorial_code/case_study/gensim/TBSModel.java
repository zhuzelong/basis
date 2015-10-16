package gensim;

/**  
* Interface which must be implemented by any class which
* provides the underlying functionality (model) of a
* ThingBeingSimulated.
*/

public interface TBSModel  {

  /** 
  * Perform a step of simulation. If this fails for some reason,
  * a SimulationException is thrown. Sending getMessage() to
  * the exception object should return a description of the problem
  */
  public void simstep() throws SimulationException;

  /** 
   * Reset the step counter
  */
  public abstract void resetCounter();      

   /** 
   * Return an empty (not null) TBS, which should implement the
   * other actions sensibly.
   */
  public abstract ThingBeingSimulated emptyThing();      

  /** 
   * Return a typical TBS, for demonstration purposes
   */
  public abstract ThingBeingSimulated typicalThing();  
    
} // TBSModel