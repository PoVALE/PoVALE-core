package tfg.assertion;

import java.util.Optional;
import tfg.environment.Environment;

public class AssertTrue implements Assertion {

    public AssertTrue() {
        super();
    }

    @Override
    public Optional<AssertionError> check(Environment env) {
        Optional<AssertionError> error = Optional.empty();
        return (Optional) error;
    }

}
