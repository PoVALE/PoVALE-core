/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tfg.Assertion;

import tfg.Entity.Entity;
import tfg.Entity.ListEntity;
import tfg.Environment.Environment;
import tfg.Term.Term;

public class ExistOne implements Assertion {

    private String variable;
    private Term termino;
    private Assertion aserto;

    public ExistOne(String variable, Term termino, Assertion aserto) {
        this.variable = variable;
        this.termino = termino;
        this.aserto = aserto;
    }

    @Override
    public boolean check(Environment env) {

        ListEntity list = (ListEntity) termino.evaluate(env);

        boolean result = false;

        for (Entity e : list.getList()) {

            env.getValues().replace(variable, e);

            if (aserto.check(env)) {

                if (result == true) {
                    result = false;
                    break;
                } else {
                    result = true;
                }
            }

        }
        return result;
    }
}
