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
import es.ucm.povale.assertInformation.AssertInformation;

/**
 * This class represents the logical false
 * @author PoVALE Team
 */
public class AssertFalse implements Assertion {

    private String message;


    /**
     * Class constructor.
     * @param message
     */
    public AssertFalse(String message) {
        this.message = message;
    }

    /**
     * The method always evaluates to false.
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
        String defaultMessage = "Nunca se cumple esta condicion";
        String finalMessage;
        if(this.message == null){
            finalMessage = defaultMessage;
        }
        else{
            finalMessage = this.message;
        }        
        return new AssertInformation(finalMessage, false);
    }

}
