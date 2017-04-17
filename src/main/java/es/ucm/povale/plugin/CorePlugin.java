/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ucm.povale.plugin;

import es.ucm.povale.entity.Entity;
import es.ucm.povale.entity.IntegerEntity;
import es.ucm.povale.entity.StringEntity;
import java.util.Arrays;
import java.util.List;
import es.ucm.povale.function.Function;
import es.ucm.povale.parameter.IntegerEditor;
import es.ucm.povale.parameter.ParameterEditor;
import es.ucm.povale.parameter.StringEditor;
import es.ucm.povale.plugin.PluginInfo;
import es.ucm.povale.predicate.Predicate;
import java.util.Collections;
import java.util.Map;

/**
 *
 * @author manuel
 */
public class CorePlugin extends PluginInfo {
    public static String CORE_ID_PLUGIN = "es.ucm.povale.plugin.CorePlugin";
    

    @Override
    public String getIdPlugin() {
        return CORE_ID_PLUGIN;
    }

    @Override
    public List<Function> getFunctions() {
        return Collections.emptyList();
    }

    @Override
    public List<Predicate> getPredicates() {
        return Collections.emptyList();
    }

    @Override
    public List<Class<?>> getEntities() {
        return Arrays.asList(
                StringEntity.class,
                IntegerEntity.class
        );
    }

    @Override
    public List<String> getEditorTypes() {
        return Arrays.asList("StringEntity","IntegerEntity");
    }
    
     @Override
    public ParameterEditor<? extends Entity> getEditor(String name, Map<String,String> parameters){
        if("StringEntity".equals(name)){
            return new StringEditor(parameters);
        }
            
        else if("IntegerEntity".equals(name)){
            return new IntegerEditor(parameters);
        }
        
        return null;
    }
    

    
}
