package es.ucm.povale.function;

import java.util.List;

import es.ucm.povale.annotation.CallableMethod;
import es.ucm.povale.entity.Entity;
import es.ucm.povale.entity.IntegerEntity;
import tfg.function.Function;

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
