package tfg.Term;

import java.util.LinkedList;
import java.util.List;
import tfg.Entity.Entity;
import tfg.Entity.ListEntity;
import tfg.Environment.Environment;

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
