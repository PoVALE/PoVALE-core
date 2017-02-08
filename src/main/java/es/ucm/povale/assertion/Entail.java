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
import es.ucm.povale.environment.Environment;

/**
 * This class represents the logical conditional operation.
 *
 * @author PoVALE Team
 */
public class Entail implements Assertion {

    private final Assertion lhs;
    private final Assertion rhs;
    private String message;
    private String defaultMessage;
    /**
     * Class constructor specifying left and right asserts.
     *
     * @see Assertion
     */
    public Entail(Assertion lhs, Assertion rhs, String message) {
        this.lhs = lhs;
        this.rhs = rhs;
        this.defaultMessage = "elem1 implica a elem2";
        this.message = message;
    }
    
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
     * The method evaluates to true when the left assert is false or the right
     * assert is true. Else, it evaluates to false.
     * 
     * @param env environment that contains the runtime entities, values for
     * variables, functions, predicates and plugins.
     * @return an Optional{@link Optional} object.If the assertion evaluates to
     * true the Optional will be empty. Otherwise, the Optional will contain a
     * value containing information regarding why the assertion has evaluated
     * to false. 
     */
    @Override
    public boolean check(Environment env) {

        boolean result = false;

        if (rhs.check(env)) {
            result = true;
        } else if (!lhs.check(env)) {
            result = true;
        }

        if (!result) {
            //EntailError entailError = new EntailError(rhs, lhs, lhs.check(env).get().getLocalizedMessage());
        }
        return result;
    }
}
