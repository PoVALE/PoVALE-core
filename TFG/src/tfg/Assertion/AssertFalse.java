package tfg.Assertion;

import tfg.Environment.Environment;

public class AssertFalse implements Assertion {

    public AssertFalse() {
        super();
    }

    public boolean check(Environment env) {
        return false;
    }

}
