package tfg.Assertion;

import tfg.Environment.Environment;
import java.util.List;

public class And implements Assertion {

    private List<Assertion> assertions;

    public And(List<Assertion> assertions) {
        super();
        this.assertions = assertions;
    }

    public List<Assertion> getAssertions() {
        return assertions;
    }

    public void setAssertions(List<Assertion> assertions) {
        this.assertions = assertions;
    }

    public boolean check(Environment env) {
        boolean andResult = true;

        for (int i = 0; i < assertions.size() && andResult; i++) {
            if (!assertions.get(i).check(env)) {
                andResult = false;
            }
        }

        return andResult;
    }
}
