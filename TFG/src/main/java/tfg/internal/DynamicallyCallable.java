/*
 * Copyright (c) 2016. Grupo de Programación Declarativa - Universidad Complutense de Madrid
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package tfg.internal;

import com.google.common.reflect.Invokable;
import com.google.common.reflect.Parameter;
import com.google.common.reflect.TypeToken;
import tfg.annotation.CallableMethod;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Base DynamicallyCallable class which gets a callable method using Java
 * reflection semantics.
 * <p>
 * The method is located at {@link #getCallableMethod()}, it is callable
 * with the approriate arguments to {@link #call(Object[])} and its arity
 * can be checked with {@link #getArity()}.
 * <p>
 * Classes implementing this base class are supposed to include one (and
 * only one) method annotated with the {@link CallableMethod} annotation so
 * that it can be introspected by this class when calling
 * {@link #call(Object[])}.
 * <p>
 * A convenience {@link #call(List)} method exists in order to use a List
 * instead of the Java varargs call mechanism.
 *
 * @author Santiago Saavedra
 */
public abstract class DynamicallyCallable<P, R> {
    private final Invokable<DynamicallyCallable, R>
            method;

    public DynamicallyCallable() {
        method = _getCallableMethod();
    }

    /**
     * The public name of the exported function or predicate.
     *
     * @return the unqualified name as a string.
     */
    public abstract String getName();

    /**
     * Get the arity of the callable.
     *
     * @return the arity of the callable method.
     */
    public int getArity() {
        return method.getParameters().size();
    }


    /**
     * This function calls the implemented CallableMethod method in the
     * class. If it does not typecheck, an IllegalAccessException will be
     * thrown wrapped in a RuntimeException.
     *
     * @param params The vararg parameters to call the function with
     * @return the result of the function call
     */
    @SafeVarargs
    final public R call(P... params) {
        try {
            Object[] args = params;

            if (method.isVarArgs()) {
                args = convertParamsToVarargs(params);
            }
            typecheck(args);
            return method.invoke(this, (Object[]) args);

        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Typechecks the call to this object without actually invoking the code.
     *
     * @param args the varargs argument list of actual arguments
     * @throws IllegalAccessException when the method does not typecheck
     */
    final public void typecheck(Object... args)
            throws IllegalAccessException {
        List<Parameter> params = method.getParameters();
        for (int i = 0; i < args.length; i++) {
            Object o = args[i];
            TypeToken<?> declaredType = params.get(i).getType();

            if (!typecheck_type(args[i], declaredType.getRawType())) {
                throw new IllegalAccessException("Declared parameter " +
                        declaredType + " is not a supertype of parameter #"
                        + i + "" +
                        " of type " + TypeToken.of(o.getClass()));
            }
        }
    }

    /**
     * Allows subclasses to improve the typechecking by allowing some
     * characteristics that may not be assumed by the base class.
     *
     * @param param        the actual parameter to typecheck
     * @param declaredType the declared type of the {@link CallableMethod}
     * @return a boolean indicating whether <code>param</code> conforms to
     * <code>declaredType</code>
     */
    protected boolean typecheck_type(Object param, Class<?> declaredType) {
        return declaredType.isAssignableFrom(param.getClass());
    }

    /**
     * This method allows calling the {@link DynamicallyCallable} instance
     * with a {@link List} instead of relying on varargs.
     *
     * @param params {@link List} of <code>P</code> parameters.
     * @return the result of type <code>R</code>
     * @see #call(Object[])
     */
    @SuppressWarnings("unchecked")
    public R call(List<P> params) {
        return call((P[]) params.toArray());
    }

    private Object[] convertParamsToVarargs(P[] params) {
        List<Object> args = new ArrayList<>();
        List<P> varargs = new ArrayList<>();

        List<Parameter> method_params = method.getParameters();
        int len = method_params.size();

        // We first add all the non-varargs parameters
        args.addAll(Arrays.asList(params).subList(0, len - 1));

        // The latest parameters is the varargs parameter. So we collect
        // all remaining parameters as varargs.
        varargs.addAll(Arrays.asList(params).subList(len - 1, params.length));

        // We add to the arguments array the varargs *itself as an array*
        args.add(varargs.toArray(createVarargsArray(varargs.size())));

        // We copy the list to an array, which is what's needed for
        // invoking a method through reflection.
        Object[] a = new Object[len];

        return args.toArray(a);
    }

    private P[] createVarargsArray(int len) {
        List<Parameter> p = method.getParameters();
        int last_pos = p.size() - 1;
        Parameter last = p.get(last_pos);

        assert last.getType().isArray();

        TypeToken<?> arrayComponentType = last.getType().getComponentType();

        assert arrayComponentType != null;

        @SuppressWarnings("unchecked")
        P[] r = (P[]) Array.newInstance(arrayComponentType.getRawType(), len);

        return r;
    }

    /**
     * Finds the method annotated with {@link CallableMethod}, to be used in
     * the rest of the class. May be overriden in subclasses to make use of a
     * fixed callable method instead of relying on the {@link CallableMethod}
     * annotation being present.
     *
     * @return the callable method
     */
    protected Method getCallableMethod() {
        Method current = null;
        for (Method m : getClass().getMethods()) {
            if (m.getAnnotation(CallableMethod.class) != null) {
                if (current != null) {
                    // More than one method with the annotation!
                    throw new RuntimeException(
                            String.format(
                                    "More than one CallableMethod found in " +
                                            "class %s",
                                    getClass()));
                }
                current = m;
            }
        }
        if (current == null) {
            throw new RuntimeException(
                    String.format("No CallableMethod found in class %s",
                            getClass())
            );
        }
        return current;
    }

    private Invokable<DynamicallyCallable, R> _getCallableMethod() {
        if (method != null)
            return method;

        TypeToken<R> returnType = new TypeToken<R>(getClass()) {
        };

        @SuppressWarnings("unchecked")
        TypeToken<DynamicallyCallable> selfType =
                TypeToken.of((Class<DynamicallyCallable>) getClass());

        return selfType.method(getCallableMethod()).returning(returnType);
    }
}
