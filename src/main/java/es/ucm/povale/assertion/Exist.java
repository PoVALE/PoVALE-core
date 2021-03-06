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

import java.util.Optional;

import es.ucm.povale.entity.Entity;
import es.ucm.povale.entity.ListEntity;
import es.ucm.povale.environment.Environment;
import es.ucm.povale.term.Term;
import es.ucm.povale.assertInformation.AssertInformation;

/**
 * This class represents the existential quantification operation.
 *
 * @author PoVALE Team
 */
public class Exist implements Assertion {

    private final String variable;
    private final Term term;
    private final Assertion assertion;
    private String message;

    /**
     * Class constructor specifying variable, term and assertion.
     *
     * @see Term
     */
    public Exist(String variable, Term term, Assertion assertion, String message) {
        this.variable = variable;
        this.term = term;
        this.assertion = assertion;
        this.message = message;
    }
    

    /**
     * The method evaluates to true when there exists at least one evaluated 
     * term for which the assert is true.
     * 
     * @param env environment that contains the runtime entities, values for
     * variables, functions, predicates and plugins.
     * @return an Optional{@link Optional} object.If the assertion evaluates to
     * true the Optional will be empty. Otherwise, the Optional will contain a
     * value containing information regarding why the assertion has evaluated
     * to false. 
     */
    @Override
    public AssertInformation check(Environment env) {

        ListEntity list = (ListEntity) term.evaluate(env);
        boolean result = false;
        String finalMessage;
        
        AssertInformation exist = new AssertInformation("", null);
        
        Entity oldValue = env.getValues().get(variable);
                
        for (Entity e : list.getList()) {
            env.getValues().put(variable, e);
            AssertInformation child;
            child = assertion.check(env);
            if (child.getResult()) {
                result = true;
            }
            exist.addChild(child);
        }
        exist.setResult(result);
        
        if(oldValue != null){
             env.getValues().put(variable, oldValue);
        }
        else{
            env.getValues().remove(variable);
        }
       
  
        if(message == null){
            finalMessage = "Existe un elemento " + '"' + variable + '"' + " en " + term.toString() +
        " tal que cumple: ";
        }
        else {
            finalMessage = message;
        }
        exist.setMessage(finalMessage);

        return exist;
    }

}
