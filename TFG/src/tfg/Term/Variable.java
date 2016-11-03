package tfg.Term;

import tfg.Entity.Entity;
import tfg.Environment.Environment;

public class Variable implements Term {
	
    private String name;

    public Variable(String name) {
        this.name = name;
    }
    
    
    public Entity evaluate(Environment env){
    	return env.getValues().get(name);
    }
}
