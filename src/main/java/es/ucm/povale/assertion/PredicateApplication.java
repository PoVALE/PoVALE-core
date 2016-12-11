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

import es.ucm.povale.assertionError.PredicateApplicationError;
import es.ucm.povale.entity.Entity;
import es.ucm.povale.environment.Environment;
import es.ucm.povale.predicate.Predicate;
import es.ucm.povale.term.ListTerm;
import es.ucm.povale.term.Term;

/**
 * This class represents the predicate application operation.
 *
 * @author PoVALE Team
 */

public class PredicateApplication implements Assertion {

    private final String predicate;
    private final List<Term> terms;

    /**
     * Class constructor specifying predicate and list of terms.
     *
     * @see Term
     */
    public PredicateApplication(String predicate, List<Term> terms) {
        this.predicate = predicate;
        this.terms = terms;
    }

    /**
     * The method evaluates to true when predicate called is true
     * 
     * @see Predicate
     * 
     * @param env environment that contains the runtime entities, values for
     * variables, functions, predicates and plugins.
     * @return an Optional{@link Optional} object.If the assertion evaluates to
     * true the Optional will be empty. Otherwise, the Optional will contain a
     * value containing information regarding why the assertion has evaluated to
     * false.
     */
    @Override
    public Optional<AssertionError> check(Environment env) {

        List<Entity> list = new LinkedList();
        Optional<PredicateApplicationError> error = Optional.empty();

        terms.stream().forEach((t) -> {
            list.add(t.evaluate(env));
        });
        
        Predicate p = env.getPredicate(predicate);
        if (!p.call(list.toArray(new Entity[list.size()]))) {
            PredicateApplicationError predicateError = new PredicateApplicationError(p.getName(), new ListTerm(terms));
            error = Optional.of(predicateError);
        }
        return (Optional) error;
    }
}
