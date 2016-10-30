package tfg.Assertion;

import tfg.Entity.Entity;
import tfg.Environment.Environment;
import tfg.Term.Term;

public class Equals implements Assertion {

    private Term lhs;
    private Term rhs;

    public Equals(Term lhs, Term rhs) {
        this.lhs = lhs;
        this.rhs = rhs;
    }

    public boolean check(Environment env) {
        Entity e = lhs.evaluate(env);
        Entity f = rhs.evaluate(env);
        return e.equals(f);
    }
}
