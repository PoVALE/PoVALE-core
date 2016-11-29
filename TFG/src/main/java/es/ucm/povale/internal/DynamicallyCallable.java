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

package es.ucm.povale.internal;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

import es.ucm.povale.annotation.CallableMethod;

/**
 * Base DynamicallyCallable class which gets a callable method using Java
 * reflection semantics.
 *
 * The method is located at {@link #getCallableMethod()}, it is callable
 * with the approriate arguments to {@link #call(Object[])}, its arity
 * can be checked with {@link #getArity()}, and it can be independently
 * typechecked with {@link #typecheck(Object[])}.
 *
 * Subclasses may choose to reimplement call and typecheck_type for
 * specific checks that cannot be included here generally.
 *
 * @author Santiago Saavedra
 */
public abstract class DynamicallyCallable<P, R> {
    private final Method method;

    public DynamicallyCallable() {
        method = getCallableMethod();
    }

    /**
     * The public name of the exported function or predicate.
     *
     * @return the unqualified name as a string.
     */
    public abstract String getName();

    /**
     * Gets the method annotated with {@link CallableMethod}, to be used in
     * the rest of the class.
     *
     * @return the callable method
     */
    protected Method getCallableMethod() {
        if (method != null) {
            // Avoid reflection if we are already constructed
            return method;
        }

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

    /**
     * Get the arity of the callable.
     *
     * @return the arity of the callable method.
     */
    public int getArity() {
        return method.getParameterCount();
    }


    /**
     * This function typechecks and calls the implemented CallableMethod
     * method in the class.
     *
     * @param params The vararg parameters to call the function with
     * @return the result of the function call
     */
    public R call(P... params) {
        try {
            typecheck(params);
            return (R) method.invoke(this, (P[]) params);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Typechecks a specific method of the object.
     *
     * @param params the actual arguments to the function for matching
     * @throws IllegalAccessException when the function does not typecheck
     */
    final public void typecheck(P... params)
            throws IllegalAccessException {
        Class<?>[] parameterTypes = method.getParameterTypes();
        Type[] genericParameterTypes = method.getGenericParameterTypes();

        if (parameterTypes.length != params.length) {
            throw new IllegalAccessException();
        }

        for (int i = 0; i < parameterTypes.length; i++) {
            if (!typecheck_type(
                    params[i],
                    parameterTypes[i],
                    genericParameterTypes[i]
            )) {
                throw new IllegalAccessException(
                        String.format(
                                "Parameter %s is not assignable from %s",
                                parameterTypes[i].getCanonicalName(),
                                params[i].getClass().getCanonicalName()));
            }
        }
    }

    protected boolean typecheck_type(
            P param,
            Class<?> parameterType,
            Type genericParameterType
    ) {
        return parameterType.isAssignableFrom(param.getClass());
    }
}
