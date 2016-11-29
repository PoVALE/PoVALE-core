package es.ucm.povale.assertion;

import java.util.Optional;

import es.ucm.povale.assertionError.NotError;
import es.ucm.povale.environment.Environment;

public class Not implements Assertion {

    private final Assertion assertion;

    public Not(Assertion assertion) {
        super();
        this.assertion = assertion;
    }

    public Assertion getAssertion() {
        return assertion;
    }

    @Override
    public Optional<AssertionError> check(Environment env) {

        Optional<NotError> error = Optional.empty();

        if (assertion.check(env).isPresent()) {
            return (Optional) error;
        } else {
            NotError notError = new NotError();
            error = Optional.of(notError);
            return (Optional) error;
        }
    }

}