/*
 * The MIT License
 *
 * Copyright 2016 PoVALE Team.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package es.ucm.povale.assertion;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import es.ucm.povale.assertionError.ExistOneError;
import es.ucm.povale.entity.Entity;
import es.ucm.povale.entity.ListEntity;
import es.ucm.povale.environment.Environment;
import es.ucm.povale.term.Term;


public class ExistOne implements Assertion {

    private final String variable;
    private final Term term;
    private final Assertion assertion;
    private String message;
    
    /**
     * Class constructor specifying variable, term and assertion.
     * @see Term
     */
    public ExistOne(String variable, Term term, Assertion assertion) {
        this.variable = variable;
        this.term = term;
        this.assertion = assertion;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    /**
     * The method evaluates to true when there exists only one evaluated term
     * for which the assert is true.
     * 
     * @param env environment that contains the runtime entities, values for
     * variables, functions, predicates and plugins.
     * @return an Optional{@link Optional} object.If the assertion evaluates to
     * true the Optional will be empty. Otherwise, the Optional will contain a
     * value containing information regarding why the assertion has evaluated
     * to false. 
     */
    @Override
    public Optional<AssertionError> check(Environment env) {

        ListEntity list = (ListEntity) term.evaluate(env);
        boolean result = false;
        Optional<ExistOneError> error = Optional.empty();
        List<Entity> cumple = new LinkedList();
        String errorString = "";

        for (Entity e : list.getList()) {
            env.getValues().replace(variable, e);
            if (!assertion.check(env).isPresent()) {
                cumple.add(e);
                if (result) {
                    
                    result = false;
                    ExistOneError existOneError = new ExistOneError(variable, cumple, assertion);
                    error = Optional.of(existOneError); 
                    break;
                } else {
                    result = true;
                }
            }
            else{
                errorString = errorString.concat(assertion.check(env).get().getLocalizedMessage());
            }
        }
        if(!result){
             ExistOneError existOneError = new ExistOneError(variable, term, assertion,errorString);
             error = Optional.of(existOneError); 
        }
        return (Optional) error;
    }
}
