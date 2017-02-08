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

import java.util.List;
import java.util.Optional;
import es.ucm.povale.environment.Environment;

/**
 * This class represents the logical conjuction operation.
 *
 * @author PoVALE Team
 */
public class And implements Assertion {

    private List<Assertion> assertions;
    private String message;
    private String defaultMessage;

    /**
     * Class constructor specifying list of asserts.
     *
     */
    public And(List<Assertion> assertions, String message) {
        super();
        this.assertions = assertions;
        this.defaultMessage = "";
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
     * The method evaluates to true when all asserts evaluate to true. Else it
     * evaluates to false.
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
        boolean andResult = true;

        for (int i = 0; i < assertions.size() && andResult; i++) {

            if (!assertions.get(i).check(env)) {
                //errorString = errorString.concat(assertions.get(i).check(env).get().getLocalizedMessage());
                andResult = false;
            }
        }
        if (!andResult) {
            //error
        }

        return andResult;
    }
}
