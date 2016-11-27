
package tfg.assertionError;

import tfg.term.Term;

/**
 *
 * @author Laura Hernando y Daniel Rossetto
 */
public abstract class AssertionError   {
    
   private Term noSatisfecho;
   private String ErrorInfo;

   public abstract String getLocalizedMessage();
    
}
