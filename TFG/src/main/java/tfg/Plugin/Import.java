
package tfg.Plugin;

import java.util.logging.Level;
import java.util.logging.Logger;
import tfg.Environment.Environment;

public class Import {
 
    private String plugin;

    public Import(String plugin) {
        this.plugin = plugin;
        addPlugin();
    }
    
    //boolean para en caso de error(?)
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
