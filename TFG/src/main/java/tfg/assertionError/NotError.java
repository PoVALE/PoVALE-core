/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tfg.assertionError;

import java.util.logging.Logger;

/**
 *
 * @author laurahernandoserrano
 */
public class NotError extends AssertionError{

    public NotError() {
    }

    @Override
    public String getLocalizedMessage() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
