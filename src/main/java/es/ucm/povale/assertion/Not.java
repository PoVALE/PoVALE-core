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

import es.ucm.povale.assertionError.NotError;
import es.ucm.povale.environment.Environment;

/**
 * This class represents the negation operation.
 *
 * @author PoVALE Team
 */
public class Not implements Assertion {

    private final Assertion assertion;
    private String message;
    
    /**
     * Class constructor specifying assertion.
     */
    public Not(Assertion assertion) {
        super();
        this.assertion = assertion;
    }
    
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
     /**
     * The method evaluates to true when the assert evaluates to false. Else it
     * evaluates to true.
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

        Optional<NotError> error = Optional.empty();

        if (assertion.check(env).isPresent()) {
            return (Optional) error;
        } else {
            NotError notError = new NotError();
            error = Optional.of(notError);
            return (Optional) error;
        }
    }

}
