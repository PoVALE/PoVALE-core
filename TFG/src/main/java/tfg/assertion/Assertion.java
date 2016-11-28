package tfg.assertion;

import java.util.Optional;
import tfg.environment.Environment;

public interface Assertion {

    public Optional<AssertionError> check(Environment env);
}
