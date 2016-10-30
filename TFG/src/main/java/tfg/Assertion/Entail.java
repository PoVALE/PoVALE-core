package tfg.Assertion;

import tfg.Environment.Environment;

public class Entail implements Assertion {

    private Assertion lhs;
    private Assertion rhs;

    public Entail(Assertion lhs, Assertion rhs) {
        this.lhs = lhs;
        this.rhs = rhs;
    }

    public boolean check(Environment env) {

        boolean result = false;

        if (rhs.check(env)) {
            result = true;
        } else if (!lhs.check(env)) {
            result = true;
        }

        return result;
    }
}
