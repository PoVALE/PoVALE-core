package tfg.assertion;

import java.util.LinkedList;
import tfg.environment.Environment;
import tfg.term.Term;
import java.util.List;
import java.util.Optional;
import tfg.assertionError.PredicateApplicationError;
import tfg.entity.Entity;
import tfg.entity.ListEntity;
import tfg.predicate.Predicate;
import tfg.term.ListTerm;

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
        
       if(!p.call(new ListEntity(list))){
           PredicateApplicationError predicateError = new PredicateApplicationError(p.getName(),new ListTerm(args));
           error = Optional.of(predicateError); 
       }

        return (Optional) error;
    }
}
