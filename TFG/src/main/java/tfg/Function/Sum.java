package tfg.Function;

import tfg.Entity.IntegerEntity;
import tfg.annotation.CallableMethod;

public class Sum extends Function {

    @CallableMethod
    public IntegerEntity apply(IntegerEntity... args) {
        int n = 0;
        for (IntegerEntity e : args) {
            n += e.getValue();
        }
        return new IntegerEntity(n);
    }

    @Override
    public String getName() {
        return "sum";
    }
}
