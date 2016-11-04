package tfg.Assertion;

import java.util.LinkedList;
import tfg.Environment.Environment;
import tfg.Term.Term;
import java.util.List;
import tfg.Entity.Entity;
import tfg.Entity.ListEntity;
import tfg.Predicate.Predicate;

public class PredicateApplication implements Assertion {

    private String predicate;
    private List<Term> args;

    public PredicateApplication(String predicate, List<Term> args) {
        this.predicate = predicate;
        this.args = args;
    }

    public boolean check(Environment env) {

        List<Entity> list = new LinkedList();

        for (Term t : args) {
            list.add(t.evaluate(env));
        }

        Predicate p = env.getPredicate(predicate);

        return p.call(list.toArray(new Entity[list.size()]));
    }
}
