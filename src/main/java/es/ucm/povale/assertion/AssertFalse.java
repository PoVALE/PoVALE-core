package es.ucm.povale.assertion;

import java.util.Optional;

import es.ucm.povale.assertionError.AssertFalseError;
import es.ucm.povale.environment.Environment;

public class AssertFalse implements Assertion {

    public AssertFalse() {
        super();
    }

    @Override
    public Optional<AssertionError> check(Environment env) {
        AssertFalseError afe = new AssertFalseError();
        Optional<AssertFalseError> error = Optional.of(afe);
        return (Optional) error;
    }

}
