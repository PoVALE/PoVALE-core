//package tfg;
//
//import tfg.Assertion.Equals;
//import tfg.Assertion.Exist;
//import tfg.Assertion.ForAll;
//import tfg.Entity.Entity;
//import tfg.Entity.IntegerEntity;
//import tfg.Environment.Environment;
//import tfg.Function.Function;
//import tfg.Function.Sum;
//import tfg.Term.*;
//
//import java.util.LinkedList;
//import java.util.List;
//
//public class MainApp {
//
//
//    /**
//     * The main() method is ignored in correctly deployed JavaFX application.
//     * main() serves only as fallback in case the application can not be
//     * launched through deployment artifacts, e.g., in IDEs with limited FX
//     * support. NetBeans ignores main().
//     *
//     * @param args the command line arguments
//     */
//    public static void main(String[] args) {
//        //launch(args);
//
//        List<Entity> listE = new LinkedList();
//        listE.add(new IntegerEntity(1));
//        listE.add(new IntegerEntity(3));
//        listE.add(new IntegerEntity(6));
//
//        List<Term> listT = new LinkedList();
//        listT.add(new LiteralInteger(new IntegerEntity(1)));
//        listT.add(new LiteralInteger(new IntegerEntity(3)));
//        listT.add(new LiteralInteger(new IntegerEntity(6)));
//
//        Environment env = new Environment();
//        env.getValues().put("x", new IntegerEntity(3));
//        //env.getValues().put("secuencia", new ListEntity(listE));
//
//        Exist e = new Exist("x", new ListTerm(listT), new Equals(new Variable("x"), new LiteralInteger(new IntegerEntity(3))));
//
//        if(e.check(env))
//            System.out.println("true");
//        else
//            System.out.println("false");
//
//
//
//
//
//        List<Entity> listE2 = new LinkedList();
//        listE2.add(new IntegerEntity(8));
//        listE2.add(new IntegerEntity(6));
//        listE2.add(new IntegerEntity(3));
//
//        List<Term> listT2 = new LinkedList();
//        listT2.add(new LiteralInteger(new IntegerEntity(8)));
//        listT2.add(new LiteralInteger(new IntegerEntity(6)));
//        listT2.add(new LiteralInteger(new IntegerEntity(3)));
//
//        env.getValues().put("y", new IntegerEntity(3));
//
//
//        List<Term> listTxy = new LinkedList();
//        listTxy.add(new Variable("x"));
//        listTxy.add(new Variable("y"));
//
//        List<Class<?>> ielist = new LinkedList();
//        ielist.add(LiteralInteger.class);
//        Class<?> ie = LiteralInteger.class;
//        List<Function> func = new LinkedList();
//        func.add(new Sum("Sum",  ielist,  ie));
//        env.addFunctions(func);
//
//        FunctionApplication sum = new FunctionApplication("Sum",listTxy);
//        Equals eq = new Equals(sum,new LiteralInteger(new IntegerEntity(9)));
//        Exist existy = new Exist("y",new ListTerm(listT2),eq);
//        ForAll fa = new ForAll("x",new ListTerm(listT),existy);
//
//
//        if(fa.check(env))
//            System.out.println("true");
//        else
//            System.out.println("false");
//
//
//
//
//
//
//
//    }
//
//}
