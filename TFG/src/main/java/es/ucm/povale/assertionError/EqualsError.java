/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ucm.povale.assertionError;

import es.ucm.povale.term.Term;

/**
 *
 * @author Laura Hernando y Daniel Rossetto
 */
public class EqualsError extends AssertionError {
    
    private Term lhs;
    private Term rhs;
    private String info;

    public EqualsError(Term lhs, Term rhs) {
        this.lhs = lhs;
        this.rhs = rhs;
        this.info = lhs +" is not equal to " + rhs +" .";
    }

    @Override
    public String getLocalizedMessage() {
        return info;
    }
    
}
