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

public class PredicateApplication implements Assertion {

    private final String predicate;
    private final List<Term> args;

    public PredicateApplication(String predicate, List<Term> args) {
        this.predicate = predicate;
        this.args = args;
    }

    @Override
    public Optional<AssertionError> check(Environment env) {

        List<Entity> list = new LinkedList();
         Optional<PredicateApplicationError> error = Optional.empty();

        for (Term t : args) {
            list.add(t.evaluate(env));
        }

        Predicate p = env.getPredicate(predicate);
        
       if(!p.call(list.toArray(new Entity[list.size()]))){
           PredicateApplicationError predicateError = new PredicateApplicationError(p.getName(),new ListTerm(args));
           error = Optional.of(predicateError); 
       }
        return (Optional) error;
    }
}
