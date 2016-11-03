package tfg.Environment;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import tfg.Entity.Entity;
import java.util.Map;
import java.util.Set;
import tfg.Function.Function;
import tfg.Predicate.Predicate;
import tfg.Plugin.PluginInfo;

public class Environment {

    private Set<Entity> entities;
    private Map<String, Entity> values;
    private Map<String, Function> functions;
    private Map<String, Predicate> predicates;
    private Map<String, PluginInfo> plugins;

    public Environment() {

        entities = new HashSet<>(); //Tipo set: EnumSet, HashSet, LinkedHashSet, TreeSet
        values = new HashMap<>();
        functions = new HashMap<>();
        predicates = new HashMap<>();
        plugins = new HashMap<>();

    }

    public Map<String, Entity> getValues() {
        return values;
    }

    public Predicate getPredicate(String predicate) {
        return predicates.get(predicate);
    }

    public Function getFunction(String function) {
        return functions.get(function);
    }

    public void addPlugin(String initializerClass, PluginInfo plugin) {
        plugins.put(initializerClass, plugin);
    }

    public void setValues(Map<String, Entity> values) {
        this.values = values;
    }

    public void setEntities(Set<Entity> entities) {
        this.entities = entities;
    }

    public void setFunctions(Map<String, Function> functions) {
        this.functions = functions;
    }

    public void setPredicates(Map<String, Predicate> predicates) {
        this.predicates = predicates;
    }

    public void addFunctions(List<Function> functions) {

        for (Function f : functions) {
            this.functions.put(f.getName(), f);
        }

    }

    public void addPredicates(List<Predicate> predicates) {

        for (Predicate p : predicates) {
            this.predicates.put(p.getName(), p);
        }

    }

    public void addEntities(List<Entity> entities) {

        for (Entity e : entities) {
            this.entities.add(e);
        }
    }

}
