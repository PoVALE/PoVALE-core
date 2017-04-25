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

import es.ucm.povale.annotation.NameMethod;

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
 * @author Santiago Saavedra and PoVALE team
 */
public abstract class DynamicName<P, R> extends DynamicallyCallable<P, R>{
    private final Method method;
    private final Method methodName;

    public DynamicName() {
        method = getCallableMethod();
        methodName = getNameMethod();
    }

    /**
     * Gets the method annotated with {@link NameMethod}, to be used in
     * the rest of the class.
     *
     * @return the callable method
     */
    protected final Method getNameMethod() {
        if (methodName != null) {
            // Avoid reflection if we are already constructed
            return methodName;
        }

        Method current = null;
        for (Method m : getClass().getMethods()) {
            if (m.getAnnotation(NameMethod.class) != null) {
                if (current != null) {
                    // More than one method with the annotation!
                    throw new RuntimeException(
                            String.format(
                                    "More than one NameMethod found in " +
                                            "class %s",
                                    getClass()));
                }
                current = m;
            }
        }
        
        return current;
    }

    public String getMessage(P... params) {
        try {
            typecheck(params);
            return (String) methodName.invoke(this);
            //si method name es null devolver el nombre del metodo (params, params)
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

}
