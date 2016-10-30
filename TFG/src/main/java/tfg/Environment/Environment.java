package tfg.Environment;

import java.util.HashMap;
import tfg.Entity.Entity;
import java.util.Map;
import tfg.Function.Function;
import tfg.Predicate.Predicate;

public class Environment {

    private Map<String, Entity> values;
    private Map<String, Function> functions;

    public Environment() {
        values = new HashMap<String, Entity>();
        functions = new HashMap<String, Function>();

    }

    public Environment(Map<String, Entity> values) {
        this.values = values;
    }

    public Map<String, Entity> getValues() {
        return values;
    }

    public void setValues(Map<String, Entity> values) {
        this.values = values;
        
        
    }

    public Predicate getPredicate(String predicate) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Function getFunction(String function) {
        return functions.get(function);
    }
    
   
 
}
