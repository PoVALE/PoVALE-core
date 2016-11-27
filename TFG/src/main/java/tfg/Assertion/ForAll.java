/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tfg.assertion;

import java.util.Optional;
import tfg.assertionError.ForAllError;
import tfg.entity.Entity;
import tfg.entity.ListEntity;
import tfg.environment.Environment;
import tfg.term.Term;

public class ForAll implements Assertion {

    private String variable;
    private Term termino;
    private Assertion aserto;

    public ForAll(String variable, Term termino, Assertion aserto) {
        this.variable = variable;
        this.termino = termino;
        this.aserto = aserto;
    }

    @Override
    public Optional<AssertionError> check(Environment env) {

        ListEntity list = (ListEntity) termino.evaluate(env);
        boolean result = true;
        Optional<ForAllError> error = Optional.empty();
        String errorString = "";

        for (Entity e : list.getList()) {

            env.getValues().replace(variable, e);

            if (aserto.check(env).isPresent()) {
                result = false;
                errorString = errorString.concat(aserto.check(env).get().getLocalizedMessage());
            }
        }

        if (!result) {
            ForAllError forAllError = new ForAllError(errorString);
            error = Optional.of(forAllError);
        }

        return (Optional) error;
    }
}
