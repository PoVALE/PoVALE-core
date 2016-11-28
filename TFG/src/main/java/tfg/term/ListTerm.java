package tfg.term;

import java.util.LinkedList;
import java.util.List;
import tfg.entity.Entity;
import tfg.entity.ListEntity;
import tfg.environment.Environment;
import tfg.term.Term;


public class ListTerm implements Term {

    private List<Term> terms;

    public ListTerm(List<Term> terms) {
        this.terms = terms;
    }

    public Entity evaluate(Environment env) {

        List<Entity> list = new LinkedList<>();

        for (Term t : terms) {
            list.add(t.evaluate(env));
        }

        ListEntity entities = new ListEntity(list);

        return entities;
    }
}
