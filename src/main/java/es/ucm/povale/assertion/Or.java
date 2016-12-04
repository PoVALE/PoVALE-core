package es.ucm.povale.assertion;

import java.util.List;
import java.util.Optional;

import es.ucm.povale.assertionError.OrError;
import es.ucm.povale.environment.Environment;

public class Or implements Assertion {

    private final List<Assertion> assertions;

    public Or(List<Assertion> assertions) {
        super();
        this.assertions = assertions;
    }

    public List<Assertion> getAssertions() {
        return assertions;
    }

    @Override
    public Optional<AssertionError> check(Environment env) {
        
        boolean orResult = false;
        Optional<OrError> error = Optional.empty();
        String errorString = "";

        for (int i = 0; i < assertions.size() && !orResult; i++) {

            if (assertions.get(i).check(env).isPresent()) {
                orResult = true;
                break;
            } else {
                errorString = errorString.concat(assertions.get(i).check(env).get().getLocalizedMessage());
            }
        }

        if (!orResult) {
            OrError orError = new OrError(errorString);
            error = Optional.of(orError);

        }

        return (Optional) error;
    }
}
