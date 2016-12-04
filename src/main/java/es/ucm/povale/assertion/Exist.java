/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ucm.povale.assertion;

import java.util.Optional;

import es.ucm.povale.assertionError.ExistError;
import es.ucm.povale.entity.Entity;
import es.ucm.povale.entity.ListEntity;
import es.ucm.povale.environment.Environment;
import es.ucm.povale.term.Term;

public class Exist implements Assertion {

    private final String variable;
    private final Term termino;
    private final Assertion aserto;

    public Exist(String variable, Term termino, Assertion aserto) {
        this.variable = variable;
        this.termino = termino;
        this.aserto = aserto;
    }

    @Override
    public Optional<AssertionError> check(Environment env) {

        ListEntity list = (ListEntity) termino.evaluate(env);
        boolean result = false;
        Optional<ExistError> error = Optional.empty();

        for (Entity e : list.getList()) {

            env.getValues().replace(variable, e);

            if (!aserto.check(env).isPresent()) {
                result = true;
                break;
            }
        }
        if (!result) {
            ExistError existError = new ExistError(variable, termino, aserto);
            error = Optional.of(existError);
        }

        return (Optional) error;
    }
}
