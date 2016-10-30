package tfg.Function;

import tfg.Entity.Entity;
import java.util.List;

public abstract class Function {
	
    String name;
    int numArgs;
    
    public abstract Entity call(List<Entity> args);
    
    public String getName() {
        return name;
    }
}
