
package es.ucm.povale.assertionError;

import java.util.List;

import es.ucm.povale.assertion.Assertion;
import es.ucm.povale.entity.Entity;
import es.ucm.povale.term.Term;

/**
 *
 * @author Laura Hernando y Daniel Rossetto
 */
public class ExistOneError extends AssertionError{
    
    private String variable;
    private Term termino;
    private Assertion aserto;
    private String info;

    public ExistOneError(String variable, Term termino, Assertion aserto, String errors) {
        this.variable = variable;
        this.termino = termino;
        this.aserto = aserto;
        this.info = "There is no " + variable + " in " + termino +  " such that "
                + aserto + ". Errors:" + errors;
    }


    public ExistOneError(String variable, List<Entity> cumple, Assertion aserto) {
        this.info = aserto + " is met for " + variable + " = " + cumple.get(0) + " and " + cumple.get(1);
    }

    @Override
    public String getLocalizedMessage() {
        return info;
    }
    
}
