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

package es.ucm.povale.predicate;

import es.ucm.povale.annotation.CallableMethod;
import es.ucm.povale.entity.Entity;
import es.ucm.povale.internal.DynamicallyCallable;

/**
 * This is the base Predicate class which handles predicates on our system.
 * <p>
 * Predicates, along with functions, are one of the main building blocks
 * of the system.
 * <p>
 * Usage: predicates must extend this base class, and usually implement two
 * methods: {@link #getName()} and another method which must contain the
 * {@link CallableMethod} annotation. See the sample
 * {@link TruePredicate} for more details.
 * <p>
 * The result in getName will provide the (unqualified) predicate name, to
 * be appended to the plugin package name in order to be used in the XML
 * documents.
 * <p>
 * The main entry point from the system is the {@link #call(Entity...)}
 * method, which finds the appropriate annotated method and calls it. In
 * case several such methods exist (which might happen if there are more
 * than one CallableMethod-annotated methods), all of them are tried
 * before giving up with a RuntimeException.
 *
 * @author Santiago Saavedra
 */
public abstract class Predicate extends DynamicallyCallable<Entity,Boolean>{
    @Override
    public Boolean call(Entity... params) {
        return super.call(params);
    }

    public abstract String getName();
    
    public abstract String getMessage();
}
