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
package es.ucm.povale.function;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import es.ucm.povale.annotation.CallableMethod;
import es.ucm.povale.entity.Entity;
import es.ucm.povale.entity.WrappedObjectEntity;
import es.ucm.povale.internal.DynamicallyCallable;
import es.ucm.povale.function.IdentityFunction;
import es.ucm.povale.internal.DynamicName;

/**
 * This is the base Function class which handles functions on our system.
 * <p>
 * Functions are one of the main building blocks of the system.
 * <p>
 * Usage: functions must extend this base class, and usually implement two
 * methods: {@link #getName()} and another method which must contain the
 * {@link CallableMethod} annotation. See the sample
 * {@link IdentityFunction} for more details.
 * <p>
 * The result in getName will provide the (unqualified) function name, to
 * be appended to the plugin package name in order to be used in the XML
 * documents.
 * <p>
 * The main entry point from the system is the {@link #call(Entity...)}
 * method, which finds the appropriate annotated function and calls it. In
 * case several such functions exist (which might happen if there are more
 * than one CallableMethod-annotated functions), all of them are tried
 * before giving up with a RuntimeException.
 *
 * @author Santiago Saavedra
 */
abstract public class Function extends DynamicName<Entity, Entity> {

    // Overridden just to remove the type erasure for Javadoc et al.
    @Override
    public Entity call(Entity... params) {
        if (Entity.class.isAssignableFrom(getCallableMethod().getReturnType())) {
            return super.call(params);
        } else {
            throw new RuntimeException(new IllegalAccessException(
                    String.format(
                            "Target method %s does not return an Entity.",
                            getCallableMethod())
            ));
        }
    }

    /**
     * Typecheck for a type including generic types (for taking
     * {@link WrappedObjectEntity} objects into consideration).
     *
     * @param param
     * @param parameterType
     * @param genericParameterType
     * @return
     */
    @Override
    protected boolean typecheck_type(Entity param, Class<?> parameterType, Type genericParameterType) {

        if (super.typecheck_type(param, parameterType, genericParameterType)) {
            if (parameterType.equals(WrappedObjectEntity.class) &&
                    genericParameterType instanceof ParameterizedType) {
                ParameterizedType g = (ParameterizedType) genericParameterType;
                Class<?> typeArgument = (Class<?>) g.getActualTypeArguments()[0];
                return typeArgument.isAssignableFrom(param.getType());
            }
            return true;
        }
        return false;
    }
    
    @Override
    public String getMessage(Entity... params){
        return super.getMessage(params);
    } 
    
}
