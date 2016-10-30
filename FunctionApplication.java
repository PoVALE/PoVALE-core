package tfg.Term;

import tfg.Entity.Entity;
import tfg.Environment.Environment;
import tfg.Function.Function;

import java.util.LinkedList;
import java.util.List;

public class FunctionApplication implements Term {

    private String function;
    private List<Term> args;

    public FunctionApplication(String function, List<Term> args) {
        this.function = function;
        this.args = args;
    }
    

    public Entity evaluate(Environment env) {

        List<Entity> list = new LinkedList<>();
        
        Function f = env.getFunction(function);

        for (Term t : args) {
            list.add(t.evaluate(env));
        }

        return f.call(list);
    }

}
