package tfg.assertion;

import java.util.Optional;
import tfg.assertionError.AssertFalseError;
import tfg.environment.Environment;

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
