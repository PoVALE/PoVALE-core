/*
 * The MIT License
 *
 * Copyright 2016 PoVALE team.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package es.ucm.povale;


import java.util.List;
import es.ucm.povale.assertion.Assertion;
import es.ucm.povale.entity.IntegerEntity;
import es.ucm.povale.environment.Environment;
import es.ucm.povale.plugin.Import;
//import es.ucm.povale.reader.XMLParser;

public class MainApp {

    public static void main(String[] args) {

        /*
        String XMLFile = "src/main/resources/existPrueba1.xml";
        XMLParser parser = new XMLParser();
        parser.parseXMLFile(XMLFile);

        Environment env = new Environment();
        
         List<String> plugins = parser.getMyPlugins();
        
        for (String a : plugins){
            Import plugin = new Import(a);
        }

        env.getValues().put("x", new IntegerEntity(3));

        List<Assertion> assertions = parser.getMyAsserts();
        for (Assertion a : assertions) {
            
            if (!a.check(env).isPresent()) {
                System.out.println("true");
            } else {
                System.out.println("false");
                System.out.println(a.check(env).get().toString());
            }
        }

        /*
        
        
        List<Entity> listE2 = new LinkedList();
        listE2.add(new IntegerEntity(8));
        listE2.add(new IntegerEntity(6));
        listE2.add(new IntegerEntity(3));

        List<Term> listT2 = new LinkedList();
        listT2.add(new LiteralInteger(new IntegerEntity(8)));
        listT2.add(new LiteralInteger(new IntegerEntity(6)));
        listT2.add(new LiteralInteger(new IntegerEntity(3)));

        env.getValues().put("y", new IntegerEntity(3));

        List<Term> listTxy = new LinkedList();
        listTxy.add(new Variable("x"));
        listTxy.add(new Variable("y"));

        List<Class<?>> ielist = new LinkedList();
        ielist.add(LiteralInteger.class);
        Class<?> ie = LiteralInteger.class;
        List<Function> func = new LinkedList();
        func.add(new Sum());
        env.addFunctions(func);

        FunctionApplication sum = new FunctionApplication("sum", listTxy);
        Equals eq = new Equals(sum, new LiteralInteger(new IntegerEntity(9)));
        Exist existy = new Exist("y", new ListTerm(listT2), eq);
        ForAll fa = new ForAll("x", new ListTerm(listT), existy);

        if (!fa.check(env).isPresent()) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }   
        */
        
    }

}
