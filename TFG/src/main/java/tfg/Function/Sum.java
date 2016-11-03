
package tfg.Function;

import java.util.List;
import tfg.Entity.Entity;
import tfg.Entity.IntegerEntity;

public class Sum extends Function{

    public Sum(String name, List<Class<?>> argType, Class<?> resultType) {
        super(name, argType, resultType);
    }

    @Override
    public Entity call(List<Entity> args) {
       int n=0;
       for(Entity e:args){
        IntegerEntity ie = (IntegerEntity)e;
        n += ie.getValue();
       }
       return new IntegerEntity(n);         
    }
   
}
