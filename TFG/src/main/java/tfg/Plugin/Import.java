
package tfg.plugin;

import java.util.logging.Level;
import java.util.logging.Logger;
import tfg.environment.Environment;

public class Import {
 
    private final String plugin;

    public Import(String plugin) {
        this.plugin = plugin;
        addPlugin();
    }
    
    public void addPlugin(){
        
        Environment e = new Environment();
           
        try {
            Class<?> cl = Class.forName(plugin);
            PluginInfo pi = (PluginInfo) cl.newInstance();
                
            e.addPlugin(plugin, pi);
            e.addFunctions(pi.getFunctions());
            e.addPredicates(pi.getPredicates());
            e.addEntities(pi.getEntities());
          
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Import.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Import.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Import.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
}
