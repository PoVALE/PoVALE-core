package tfg.term;

import tfg.entity.Entity;
import tfg.environment.Environment;
import tfg.term.Term;

public class Variable implements Term {
	
    private String name;

    public Variable(String name) {
        this.name = name;
    }
    
    
    public Entity evaluate(Environment env){
    	return env.getValues().get(name);
    }
}
