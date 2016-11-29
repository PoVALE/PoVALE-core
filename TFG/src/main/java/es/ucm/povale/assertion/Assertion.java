package es.ucm.povale.assertion;

import java.util.Optional;

import es.ucm.povale.environment.Environment;

public interface Assertion {

    public Optional<AssertionError> check(Environment env);
}
