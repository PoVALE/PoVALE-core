package tfg.term;

import tfg.entity.Entity;
import tfg.environment.Environment;

public interface Term {

    public Entity evaluate(Environment env);
}
