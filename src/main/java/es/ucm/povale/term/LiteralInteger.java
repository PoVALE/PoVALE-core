package es.ucm.povale.term;

import es.ucm.povale.entity.Entity;
import es.ucm.povale.entity.IntegerEntity;
import es.ucm.povale.environment.Environment;



public class LiteralInteger implements Term {
    
    private IntegerEntity integer;

    public LiteralInteger(IntegerEntity integer) {
        this.integer = integer;
    }
    
    public Entity evaluate(Environment env){
        return integer;
    }
}
