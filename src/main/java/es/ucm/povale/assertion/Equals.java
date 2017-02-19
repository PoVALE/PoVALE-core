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
import es.ucm.povale.environment.Environment;
import es.ucm.povale.term.Term;
import es.ucm.povale.assertInformation.AssertInformation;

/**
 * This class represents the equals operation.
 *
 * @author PoVALE Team
 */
public class Equals implements Assertion {

    private final Term lhs;
    private final Term rhs;
    private String message;
    private String defaultMessage;
    private AssertInformation node;
    
    
    /**
     * Class constructor specifying left and right terms.
     *
     * @see Term
     */
    public Equals(Term lhs, Term rhs, String message) {
        this.lhs = lhs;
        this.rhs = rhs;
        this.defaultMessage = " no es igual a ";
        this.message = message;
        this.node = new AssertInformation(this.message, null);
 
    }
    
    @Override
    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    
    public String getDefaultMessage() {
        return defaultMessage;
    }

    public void setDefaultMessage(String defaultMessage) {
        this.defaultMessage = defaultMessage;
    }

    /**
     * The method evaluates to true when the evaluated left term is equal to 
     * the evaluated right term. Else, it evaluates to false.
     * 
     * @param env environment that contains the runtime entities, values for
     * variables, functions, predicates and plugins.
     * @return an Optional{@link Optional} object.If the assertion evaluates to
     * true the Optional will be empty. Otherwise, the Optional will contain a
     * value containing information regarding why the assertion has evaluated
     * to false. 
     * 
     * @see Term
     */
    @Override
    public AssertInformation check(Environment env) {

        boolean result;

        Entity l = lhs.evaluate(env);
        Entity r = rhs.evaluate(env);

        result = l.equals(r);
        if(message == null){
            this.node.setMessage(l + defaultMessage + r);
        }
        else{ 
            this.node.setMessage(l + message + r);
        }
        
        this.node.setResult(result);//actualizamos el valor del aserto evaluado

        return this.node;
    }
    
}
