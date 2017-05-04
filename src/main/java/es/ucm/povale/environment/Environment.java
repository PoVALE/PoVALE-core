/*
 * The MIT License
 *
 * Copyright 2016 PoVALE Team.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package es.ucm.povale.environment;

import es.ucm.povale.variable.Var;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import es.ucm.povale.entity.Entity;
import es.ucm.povale.function.Function;
import es.ucm.povale.plugin.PluginInfo;
import es.ucm.povale.predicate.Predicate;


public class Environment {

    private Set<Entity> entities;
    private Map<String, Entity> values;
    private Map<String, Function> functions;
    private Map<String, Predicate> predicates;
    private Map<String, PluginInfo> plugins;
    private Map<String, PluginInfo> paramEditors;
    private Map<Var, Entity> variables;

    public Environment() {

        entities = new HashSet<>(); //Tipo set: EnumSet, HashSet, LinkedHashSet, TreeSet
        values = new HashMap<>();
        functions = new HashMap<>();
        predicates = new HashMap<>();
        plugins = new HashMap<>();
        paramEditors = new HashMap<>();
        variables = new HashMap<>();

    }
    
    public void setEntities(Set<Entity> entities) {
        this.entities = entities;
    }
    
    public void addEntities(List<Entity> entities) {

        entities.stream().forEach((e) -> {
            this.entities.add(e);
        });
    }
      
    public Map<String, Entity> getValues() {
        return values;
    }
      
    public void setValues(Map<String, Entity> values) {
        this.values = values;
    }
    
    public Function getFunction(String function) {
        return functions.get(function);
    }
    
     public void addFunctions(List<Function> functions) {

        functions.stream().forEach((f) -> {
            this.functions.put(f.getName(), f);
        });

    }
    
    public void setFunctions(Map<String, Function> functions) {
        this.functions = functions;
    }

    public Predicate getPredicate(String predicate) {
        return predicates.get(predicate);
    }

    public void setPredicates(Map<String, Predicate> predicates) {
        this.predicates = predicates;
    }
    
    public void addPredicates(List<Predicate> predicates) {

        predicates.stream().forEach((p) -> {
            this.predicates.put(p.getName(), p);
        });
    }

    public void addPlugin(String initializerClass, PluginInfo plugin) {
        plugins.put(initializerClass, plugin);
    }

    public void addParamEditors() {

        plugins.values().stream().forEach((p) -> {
            p.getEditorTypes().stream().forEach((s) -> {
                this.paramEditors.put(s, p);
            });
        });
    }
    
    public PluginInfo getParamEditor(String param) {
        return paramEditors.get(param);
    }

    public Set<Var> getVariables() {
        return variables.keySet();
    }
    
    public void addValue(Var variable, Entity value){
        
        this.values.put(variable.getName(), value);
    }
    
    public Entity getValue(String varName){
        return this.values.get(varName);
    }
    
    public void addVariables(List<Var> variables){
        
        for(int i=0; i<variables.size(); i++){
            this.variables.put(variables.get(i), null);
        }
    }
    
    public void setVariableValue(Var variable, Entity value){
        this.variables.replace(variable, value);
    }
}
