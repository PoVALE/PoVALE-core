package es.ucm.povale.term;

import es.ucm.povale.entity.Entity;
import es.ucm.povale.environment.Environment;
import es.ucm.povale.term.Term;

public class Variable implements Term {
	
    private String name;

    public Variable(String name) {
        this.name = name;
    }
    
    
    public Entity evaluate(Environment env){
    	return env.getValues().get(name);
    }
}
