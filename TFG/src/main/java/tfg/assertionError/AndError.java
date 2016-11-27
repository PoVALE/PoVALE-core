/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tfg.assertionError;

/**
 *
 * @author Laura Hernando y Daniel Rossetto
 */
public class AndError extends AssertionError {
    
    private String errorInfo;
    
    public AndError(String errorString) {
        this.errorInfo = "None of the AND assertions evaluate to true: " + errorString + " .";
    }

    @Override
    public String getLocalizedMessage() {
        return errorInfo;
    }
    
}
