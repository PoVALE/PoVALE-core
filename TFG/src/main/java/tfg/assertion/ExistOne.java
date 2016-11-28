/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tfg.assertion;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import tfg.assertionError.ExistOneError;
import tfg.entity.Entity;
import tfg.entity.ListEntity;
import tfg.environment.Environment;
import tfg.term.Term;

public class ExistOne implements Assertion {

    private final String variable;
    private final Term termino;
    private final Assertion aserto;

    public ExistOne(String variable, Term termino, Assertion aserto) {
        this.variable = variable;
        this.termino = termino;
        this.aserto = aserto;
    }

    @Override
    public Optional<AssertionError> check(Environment env) {

        ListEntity list = (ListEntity) termino.evaluate(env);
        boolean result = false;
        Optional<ExistOneError> error = Optional.empty();
        List<Entity> cumple = new LinkedList();
        String errorString = "";

        for (Entity e : list.getList()) {

            env.getValues().replace(variable, e);

            if (!aserto.check(env).isPresent()) {
                
                cumple.add(e);

                if (result) {
                    
                    result = false;
                    ExistOneError existOneError = new ExistOneError(variable, cumple, aserto);
                    error = Optional.of(existOneError); 
                    break;
                    
                } else {
                    result = true;
                }
                
                
            }
            else{
                errorString = errorString.concat(aserto.check(env).get().getLocalizedMessage());
            }

        }
        
        if(!result){
             ExistOneError existOneError = new ExistOneError(variable, termino, aserto,errorString);
             error = Optional.of(existOneError); 
        }
        return (Optional) error;
    }
}
