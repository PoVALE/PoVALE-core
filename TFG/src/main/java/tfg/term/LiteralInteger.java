package tfg.term;

import tfg.entity.Entity;
import tfg.entity.IntegerEntity;
import tfg.environment.Environment;
import tfg.term.Term;



public class LiteralInteger implements Term {
    
    private IntegerEntity integer;

    public LiteralInteger(IntegerEntity integer) {
        this.integer = integer;
    }
    
    public Entity evaluate(Environment env){
        return integer;
    }
}
