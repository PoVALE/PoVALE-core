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

import com.google.common.reflect.TypeToken;
import org.junit.Test;
import tfg.annotation.CallableMethod;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author Santiago Saavedra
 */
public class DynamicallyCallableTest {

    @Test
    public void call_object_type() throws Exception {
        MySum s = new MySum();

        int r = s.call(1, 2, 3, 4);
        assert r == 1 + 2 + 3 + 4;
    }

    @Test(expected = IllegalArgumentException.class)
    public void call_primitive_type() throws Exception {
        BadSum s = new BadSum();

        int r = s.call(1, 2, 3, 4);
        assert r == 1 + 2 + 3 + 4;
    }

    @Test
    public void call_varargs_like_list() throws Exception {
        MySum s = new MySum();
        List<Integer> i = new ArrayList<>();
        i.add(1);
        i.add(2);
        i.add(3);
        i.add(4);

        int r1 = s.call(i);
        int r2 = s.call(i.toArray(new Integer[4]));

        assertEquals(r1, r2);
        assertEquals(r1, 10);
    }

    @Test
    public void call_typecheck_ok() throws Exception {
        PolyIdentity<Integer> intId = new PolyIdentity<>();

        int i = intId.call(5);
        assertEquals(i, 5);
    }

    @Test(expected = ClassCastException.class)
    public void call_typecheck_fail() throws Exception {
        PolyIdentity<Integer> intId = new PolyIdentity<>();

        String s = (String) (Object) intId.call(5);
    }

    @Test
    public void getCallableMethod() throws Exception {
        PolyIdentity<Object> objId = new PolyIdentity<>();
        objId.getCallableMethod().equals(PolyIdentity.class
                .getDeclaredMethod("apply", Object.class));
    }

    @Test
    public void getCustomCallableMethod() throws Exception {
        PolyInCustomMethod<String> intC = new PolyInCustomMethod<String>() {
        };

        assertEquals(intC.call(), "identity_poly_cm<java.lang.String>");
    }

    /**
     * This test fails because in the general case we do not have enough
     * type information at runtime to do this properly in Java.
     *
     * @throws Exception
     */
    @Test(expected = AssertionError.class)
    public void testGenericErasureTypecheck() throws Exception {
        ListMonoIdentity id = new ListMonoIdentity();
        List<String> l = new ArrayList<>();
        l.add("hello world");

        List<String> l2 = id.call(l);

        List<Integer> ll = new ArrayList<>();
        ll.add(1);
        List<String> ll2 = id.call(l);

        assert false;
    }

    public class PolyIdentity<T> extends DynamicallyCallable<T, T> {
        @CallableMethod
        public T apply(T arg) {
            return arg;
        }

        @Override
        public String getName() {
            TypeToken<T> t = new TypeToken<T>(getClass()) {
            };
            return "identity_poly<" + t + ">";
        }
    }

    public class ListMonoIdentity extends DynamicallyCallable<List<String>,
            List<String>> {
        @CallableMethod
        public List<String> apply(List<String> arg) {
            return arg;
        }

        @Override
        public String getName() {
            return "identity_list";
        }
    }


    abstract public class PolyInCustomMethod<T> extends DynamicallyCallable<T,
            String> {

        @Override
        protected Method getCallableMethod() {
            try {
                return getClass().getMethod("getName");
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        public String getName() {
            TypeToken<T> t = new TypeToken<T>(getClass()) {
            };
            return "identity_poly_cm<" + t + ">";
        }
    }

    public class MySum extends DynamicallyCallable<Integer, Integer> {
        @CallableMethod
        public Integer apply(Integer acc, Integer... args) {
            for (int arg : args) acc += arg;
            return acc;
        }

        @Override
        public String getName() {
            return "sum_test";
        }
    }

    /**
     * This class will **not** work because reflection does not
     * automatically box/unbox types from P and R to the
     * {@link CallableMethod}-annotated function.
     */
    public class BadSum extends DynamicallyCallable<Integer, Integer> {
        @CallableMethod
        public int apply(int acc, int... args) {
            for (int arg : args) acc += arg;
            return acc;
        }

        @Override
        public String getName() {
            return "sum_bad";
        }
    }
}