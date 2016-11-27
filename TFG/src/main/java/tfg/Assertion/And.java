package tfg.assertion;

import tfg.assertionError.AndError;
import tfg.environment.Environment;
import java.util.List;
import java.util.Optional;

public class And implements Assertion {

    private List<Assertion> assertions;

    public And(List<Assertion> assertions) {
        super();
        this.assertions = assertions;
    }

    public List<Assertion> getAssertions() {
        return assertions;
    }

    public void setAssertions(List<Assertion> assertions) {
        this.assertions = assertions;
    }

    @Override
    public Optional<AssertionError> check(Environment env) {
        boolean andResult = true;
        String errorString = "";

        Optional<AndError> error = Optional.empty();

        for (int i = 0; i < assertions.size() && andResult; i++) {

            AndError x = new AndError(errorString);

            if (assertions.get(i).check(env).isPresent()) {
                errorString = errorString.concat(assertions.get(i).check(env).get().getLocalizedMessage());
                andResult = false;
            }
        }
        if (!andResult) {
            AndError andError = new AndError(errorString);
            error = Optional.of(andError);
        }

        return (Optional) error;
    }
}
