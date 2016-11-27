package tfg.assertion;

import tfg.assertionError.EqualsError;
import java.util.Optional;
import tfg.entity.Entity;
import tfg.environment.Environment;
import tfg.term.Term;

public class Equals implements Assertion {

    private final Term lhs;
    private final Term rhs;

    public Equals(Term lhs, Term rhs) {
        this.lhs = lhs;
        this.rhs = rhs;
    }

    @Override
    public Optional<AssertionError> check(Environment env) {

        boolean result;
        Optional<EqualsError> error = Optional.empty();

        Entity l = lhs.evaluate(env);
        Entity r = rhs.evaluate(env);

        result = l.equals(r);

        if (!result) {
            EqualsError equalsError = new EqualsError(lhs, rhs);
            error = Optional.of(equalsError);
        }

        return (Optional) error;
    }
}
