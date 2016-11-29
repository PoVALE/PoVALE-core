package es.ucm.povale.term;

import java.util.LinkedList;
import java.util.List;

import es.ucm.povale.entity.Entity;
import es.ucm.povale.environment.Environment;
import es.ucm.povale.function.Function;


public class FunctionApplication implements Term {

    private String function;
    private List<Term> args;

    public FunctionApplication(String function, List<Term> args) {
        this.function = function;
        this.args = args;
    }
    

    @Override
    public Entity evaluate(Environment env) {
        
        List<Entity> list = new LinkedList<>();
        
        Function f = env.getFunction(function);

        args.stream().forEach((t) -> {
            list.add(t.evaluate(env));
        });
        
        return f.call(list.toArray(new Entity[list.size()]));
        
        
    }

}
