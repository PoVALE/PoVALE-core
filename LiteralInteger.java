package tfg.Term;

import tfg.Entity.Entity;
import tfg.Entity.IntegerEntity;
import tfg.Environment.Environment;


public class LiteralInteger implements Term {
    
    private IntegerEntity integer;

    public LiteralInteger(IntegerEntity integer) {
        this.integer = integer;
    }
    
    public Entity evaluate(Environment env){
        return integer;
    }
}
