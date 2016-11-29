/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ucm.povale.assertionError;

import es.ucm.povale.term.ListTerm;

/**
 *
 * @author laurahernandoserrano
 */
public class PredicateApplicationError extends AssertionError{

    public PredicateApplicationError(String name, ListTerm listTerm) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getLocalizedMessage() {
        return null;
    }
    
}
