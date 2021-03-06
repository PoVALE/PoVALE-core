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
package es.ucm.povale.term;

import java.util.LinkedList;
import java.util.List;

import es.ucm.povale.entity.Entity;
import es.ucm.povale.environment.Environment;
import es.ucm.povale.function.Function;
import java.lang.String;


public class FunctionApplication implements Term {

    private String function;
    private List<Term> args;
    private String message;

    public FunctionApplication(String function, List<Term> args) {
        this.function = function;
        this.args = args;
    }
    
    public String getFunction(){
        return function;
    }
    

    @Override
    public Entity evaluate(Environment env) {
        
        List<Entity> list = new LinkedList<>();
        
        Function f = env.getFunction(function);
        args.stream().forEach((t) -> {
            list.add(t.evaluate(env));
        });
        Entity e = f.call(list.toArray(new Entity[list.size()]));

        message = f.getMessage();

        return e;
        
        
    }

    @Override
    public String toString(){
        return message;
    }
}
