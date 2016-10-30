package tfg.Term;

import tfg.Entity.Entity;
import tfg.Entity.StringEntity;
import tfg.Environment.Environment;

public class LiteralString implements Term {
	
    private StringEntity string;

    public LiteralString(StringEntity string) {
        this.string = string;
    }
    
    
    public Entity evaluate(Environment env){
        return string;
    }
}
