
package tfg.plugin;

import java.util.List;
import tfg.entity.Entity;
import tfg.function.Function;
import tfg.predicate.Predicate;

public abstract class PluginInfo {
    
    public abstract String getIdPlugin();
    
    public abstract List<Function> getFunctions();
    
    public  abstract List<Predicate> getPredicates();
   
    public abstract  List<Class<?>> getEntities();
    
    
}
