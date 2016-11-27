
package tfg.plugin;

import java.util.List;
import tfg.entity.Entity;
import tfg.function.Function;
import tfg.predicate.Predicate;

public interface PluginInfo {
    
    public  String getIdPlugin();
    
    public List<Function> getFunctions();
    
    public  List<Predicate> getPredicates();
   
    public  List<Entity> getEntities();
    
    
}
