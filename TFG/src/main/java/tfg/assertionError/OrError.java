/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tfg.assertionError;

/**
 *
 * @author laurahernandoserrano
 */
public class OrError extends AssertionError{
    
    private String errorInfo;

    public OrError(String errorString) {
        
        this.errorInfo = "None of the OR assertions evaluate to true: " + errorString + " .";
        
    }

    @Override
    public String getLocalizedMessage() {
        return errorInfo;
    }
    
    
    
}
