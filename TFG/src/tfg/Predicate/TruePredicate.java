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

package tfg.Predicate;

import tfg.Entity.Entity;
import tfg.Entity.WrappedObjectEntity;
import tfg.Predicate.Predicate;
import tfg.annotation.CallableMethod;

/**
 * The predicate constant true.
 *
 * @author Santiago Saavedra
 */
public class TruePredicate extends Predicate {

    @CallableMethod
    public Entity apply() {
        return new WrappedObjectEntity<>(true);
    }

    @Override
    public String getName() {
        return "true";
    }
}
