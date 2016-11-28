package tfg.term;

import tfg.entity.Entity;
import tfg.entity.StringEntity;
import tfg.environment.Environment;
import tfg.term.Term;


public class LiteralString implements Term {
	
    private StringEntity string;

    public LiteralString(StringEntity string) {
        this.string = string;
    }
    
    
    public Entity evaluate(Environment env){
        return string;
    }
}
