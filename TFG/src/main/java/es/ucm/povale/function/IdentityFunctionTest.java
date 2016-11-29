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

import static org.junit.Assert.assertEquals;

import es.ucm.povale.entity.WrappedObjectEntity;

/**
 * @author Santiago Saavedra
 */
public final class IdentityFunctionTest {
    @org.junit.Test
    public void apply_on_correct_parameters() throws Exception {

        Function f = new IdentityFunction();

        WrappedObjectEntity<String> param = new WrappedObjectEntity<>("Hello, world");

        assertEquals(f.call(param).toString(), param.toString());
        assertEquals(f.call(param), param);
    }

    @org.junit.Test(expected = RuntimeException.class)
    public void apply_on_incorrect_parameters() throws Exception {
        Function f = new IdentityFunction();
        System.out.println("We got: " + f.call(new WrappedObjectEntity<>(6)));
    }

}