package tfg.Assertion;

import tfg.Environment.Environment;
import java.util.List;

public class Or implements Assertion {

    private List<Assertion> assertions;

    public Or(List<Assertion> assertions) {
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
        boolean orResult = false;

        for (int i = 0; i < assertions.size() && !orResult; i++) {
            if (assertions.get(i).check(env)) {
                orResult = true;
            }
        }

        return orResult;
    }
}
