
package es.ucm.povale.assertionError;

import es.ucm.povale.term.Term;

/**
 *
 * @author Laura Hernando y Daniel Rossetto
 */
public abstract class AssertionError   {
    
   private Term noSatisfecho;
   private String ErrorInfo;

   public abstract String getLocalizedMessage();
    
}
