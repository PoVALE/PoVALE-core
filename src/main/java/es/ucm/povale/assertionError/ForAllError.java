/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ucm.povale.assertionError;

/**
 *
 * @author laurahernandoserrano
 */
public class ForAllError extends AssertionError{
    
    private String errorInfo;

    public ForAllError(String errorString) {
        this.errorInfo = errorString;
    }

    @Override
    public String getLocalizedMessage() {
        return errorInfo;
    }
    
    
    
}
