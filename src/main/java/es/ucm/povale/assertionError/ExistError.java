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
package es.ucm.povale.assertionError;

import es.ucm.povale.assertion.Assertion;
import es.ucm.povale.term.Term;

/**
 * The class contains information regarding why an Exist has evaluated to false.
 * 
 * @see Exist
 * 
 * @author PoVALE Team
 */
public class ExistError extends AssertionError{
    
    private String variable;
    private Term termino;
    private Assertion aserto;
    private String info;

    /**
     * Class constructor specifying the the variable, the term or the list of
     * terms, the assertion of the Exist, and the string which contains the
     * reason of the assert evaluates to false.
     *
     */
    public ExistError(String variable, Term termino, Assertion aserto) {
        this.variable = variable;
        this.termino = termino;
        this.aserto = aserto;
        this.info = "there is no " + variable + " in " + termino +  " such that "
                + aserto;
    }

    @Override
    public String getLocalizedMessage() {
        return info;
    }
    
}
