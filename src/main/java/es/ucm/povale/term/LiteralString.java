package es.ucm.povale.term;

import es.ucm.povale.entity.Entity;
import es.ucm.povale.entity.StringEntity;
import es.ucm.povale.environment.Environment;


public class LiteralString implements Term {
	
    private StringEntity string;

    public LiteralString(StringEntity string) {
        this.string = string;
    }
    
    
    public Entity evaluate(Environment env){
        return string;
    }
}
