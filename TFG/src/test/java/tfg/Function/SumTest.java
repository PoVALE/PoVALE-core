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

package tfg.Function;

import org.junit.Test;
import tfg.Entity.Entity;
import tfg.Entity.IntegerEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Santiago Saavedra
 */
public class SumTest {
    @Test
    public void apply_on_1_correct_parameter() throws Exception {
        Sum f = new Sum();

        IntegerEntity p1 = new IntegerEntity(1);

        IntegerEntity result = (IntegerEntity) f.call(new IntegerEntity[]{p1});

        assertEquals(result.getValue(), p1.getValue());
    }

    @Test
    public void apply_on_2_correct_parameters() throws Exception {
        Function f = new Sum();

        IntegerEntity p1 = new IntegerEntity(1);
        IntegerEntity p2 = new IntegerEntity(2);

        IntegerEntity result = (IntegerEntity) f.call(p1, p2);

        assertEquals(result.getValue(), 3);
    }

}