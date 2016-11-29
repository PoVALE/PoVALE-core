
package es.ucm.povale.assertionError;

import es.ucm.povale.assertion.Assertion;
import es.ucm.povale.term.Term;

/**
 *
 * @author Laura Hernando y Daniel Rossetto
 */
public class EntailError extends AssertionError {
    
    private Assertion lhs;
    private Assertion rhs;
    private String info;

    public EntailError(Assertion lhs, Assertion rhs, String errorInfo) {
        this.lhs = lhs;
        this.rhs = rhs;
        this.info = lhs +" is true but " + rhs +" is not. " + errorInfo;
    }
    
    public EntailError(Assertion lhs, Assertion rhs) {
        this.lhs = lhs;
        this.rhs = rhs;
        this.info = lhs +" is true but " + rhs +" is not. ";
    }

    @Override
    public String getLocalizedMessage() {
        return info;
    }
    
}