package es.ucm.povale;


import java.util.List;

import es.ucm.povale.assertion.Assertion;
import es.ucm.povale.entity.IntegerEntity;
import es.ucm.povale.environment.Environment;
import es.ucm.povale.plugin.Import;
import es.ucm.povale.reader.XMLParser;

public class MainApp {

    public static void main(String[] args) {

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
