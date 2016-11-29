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

        List<Entity> list = new LinkedList<>();

        for (Term t : terms) {
            list.add(t.evaluate(env));
        }

        ListEntity entities = new ListEntity(list);

        return entities;
    }
}
