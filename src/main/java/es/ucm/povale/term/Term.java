package es.ucm.povale.term;

import es.ucm.povale.entity.Entity;
import es.ucm.povale.environment.Environment;

public interface Term {

    public Entity evaluate(Environment env);
}
