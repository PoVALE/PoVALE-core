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
import es.ucm.povale.entity.ListEntity;
import es.ucm.povale.environment.Environment;
import es.ucm.povale.term.Term;


public class ListTerm implements Term {

    private List<Term> terms;

    public ListTerm(List<Term> terms) {
        this.terms = terms;
    }
    

    public Entity evaluate(Environment env) {

        //List<Entity> list = new LinkedList<>();
        ListEntity entities = new ListEntity();
        for (Term t : terms) {
            //list.add(t.evaluate(env));
            entities.addEntity(t.evaluate(env));
        }

        //ListEntity entities = new ListEntity(list);
        
        return entities;
    }

    @Override
    public String toString() {
        String result = "";
        for(int i=0; i< terms.size()-1; i++){
            result += terms.get(i)+ ", ";
        }
        result += terms.get(terms.size()-1);
        return result;
    }
    
    
}
