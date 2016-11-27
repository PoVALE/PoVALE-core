
package tfg.assertionError;

import tfg.assertion.Assertion;
import tfg.term.Term;

/**
 *
 * @author Laura Hernando y Daniel Rossetto
 */
public class ExistError extends AssertionError{
    
    private String variable;
    private Term termino;
    private Assertion aserto;
    private String info;

    public ExistError(String variable, Term termino, Assertion aserto) {
        this.variable = variable;
        this.termino = termino;
        this.aserto = aserto;
        this.info = "there is no " + variable + " in " + termino +  " such that "
                + aserto;
    }

    @Override
    public String getLocalizedMessage() {
        return info;
    }
    
}
