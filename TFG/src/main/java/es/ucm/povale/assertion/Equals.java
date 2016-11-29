package es.ucm.povale.assertion;

import java.util.Optional;

import es.ucm.povale.assertionError.EqualsError;
import es.ucm.povale.entity.Entity;
import es.ucm.povale.environment.Environment;
import es.ucm.povale.term.Term;

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
