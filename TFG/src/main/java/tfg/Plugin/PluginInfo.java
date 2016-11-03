
package tfg.Plugin;

import java.util.List;
import tfg.Entity.Entity;
import tfg.Function.Function;
import tfg.Predicate.Predicate;

public class PluginInfo {
    
    private String idPlugin;
    private List<Function> functions;
    private List<Predicate> predicates;
    private List<Entity> entities;

    
    public PluginInfo(String idPlugin, List<Function> functions, List<Predicate> predicates, List<Entity> entities) {
        this.idPlugin = idPlugin;
        this.functions = functions;
        this.predicates = predicates;
        this.entities = entities;
    }
    
    public String getIdPlugin(){
        return idPlugin;
    }
    
    public List<Function> getFunctions(){
        return functions;
    }
    
    public List<Predicate> getPredicates(){
        return predicates;
    }
   
    public List<Entity> getEntities(){
        return entities;
    }
    
    
}
