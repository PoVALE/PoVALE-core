
package es.ucm.povale.plugin;

import java.util.List;

import es.ucm.povale.entity.Entity;
import es.ucm.povale.function.Function;
import es.ucm.povale.predicate.Predicate;

public abstract class PluginInfo {
    
    public abstract String getIdPlugin();
    
    public abstract List<Function> getFunctions();
    
    public  abstract List<Predicate> getPredicates();
   
    public abstract  List<Class<?>> getEntities();
    
    
}
