package tfg.function;

import java.util.List;
import tfg.annotation.CallableMethod;
import tfg.entity.Entity;
import tfg.entity.IntegerEntity;

public class Sum extends Function {

    public Sum() {
    }

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
