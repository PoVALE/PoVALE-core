package tfg.assertion;

import tfg.assertionError.EntailError;
import java.util.Optional;
import tfg.environment.Environment;

public class Entail implements Assertion {

    private final Assertion lhs;
    private final Assertion rhs;

    public Entail(Assertion lhs, Assertion rhs) {
        this.lhs = lhs;
        this.rhs = rhs;
    }

    @Override
    public Optional<AssertionError> check(Environment env) {

        boolean result = false;
        Optional<EntailError> error = Optional.empty();

        if (!rhs.check(env).isPresent()) {
            result = true;
        } else if (lhs.check(env).isPresent()) {
            result = true;
        }

        if (!result) {
            EntailError entailError = new EntailError(rhs, lhs, lhs.check(env).get().getLocalizedMessage());
            error = Optional.of(entailError);
        }
        return (Optional) error;
    }
}
