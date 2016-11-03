package tfg.Function;

import tfg.Entity.Entity;
import java.util.List;

public abstract class Function {
	
    String name;
    private List<Class<?>> argType;
    private Class<?> resultType;

    public Function(String name, List<Class<?>> argType, Class<?> resultType) {
        this.name = name;
        this.argType = argType;
        this.resultType = resultType;
    }
    
    public abstract Entity call(List<Entity> args);
    
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