package tfg.Predicate;

import java.util.List;
import tfg.Entity.Entity;

public abstract class Predicate {

    private String name;
    private List<Class<?>> argType;
    private Class<?> resultType;

    public boolean call(List<Entity> list) {
        return true;
    }

    public String getName() {
        return name;
    }

    public List<Class<?>> getInputTypes(){
        return argType;
    }
    
    public Class<?> getResultType(){
        return resultType;
    }

    
}
