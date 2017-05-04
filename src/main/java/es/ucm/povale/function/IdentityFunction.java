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
import es.ucm.povale.annotation.CallableMethod;
import es.ucm.povale.entity.WrappedObjectEntity;

/**
 * This is an example function on Strings. It is the identity function on
 * Strings, and will fail for any other data type.
 *
 * @author Santiago Saavedra
 */
public class IdentityFunction extends Function {

    @CallableMethod
    public WrappedObjectEntity<String> apply(WrappedObjectEntity<String> elt) {
        return elt;
    }

    public String getName() {
        return "identity";
    }

    @Override
    public String getMessage() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
