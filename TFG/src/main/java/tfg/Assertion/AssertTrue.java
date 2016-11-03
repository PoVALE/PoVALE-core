package tfg.Assertion;

import tfg.Environment.Environment;

public class AssertTrue implements Assertion {

    public AssertTrue() {
        super();
    }

    public boolean check(Environment env) {
        return true;
    }

}
