package tfg;

import java.util.LinkedList;
import java.util.List;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tfg.Assertion.Assertion;
import tfg.Assertion.Equals;
import tfg.Assertion.Exist;
import tfg.Assertion.ForAll;
import tfg.Entity.Entity;
import tfg.Entity.IntegerEntity;
import tfg.Entity.ListEntity;
import tfg.Environment.Environment;
import tfg.Term.FunctionApplication;
import tfg.Term.ListTerm;
import tfg.Term.LiteralInteger;
import tfg.Term.Term;
import tfg.Term.Variable;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        /*Parent root = FXMLLoader.load(getClass().getResource("/fxml/Scene.fxml"));
        
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");
        
        stage.setTitle("JavaFX and Maven");
        stage.setScene(scene);
        stage.show();*/

    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //launch(args);

        List<Entity> listE = new LinkedList();
        listE.add(new IntegerEntity(1));
        listE.add(new IntegerEntity(3));
        listE.add(new IntegerEntity(6));

        List<Term> listT = new LinkedList();
        listT.add(new LiteralInteger(new IntegerEntity(1)));
        listT.add(new LiteralInteger(new IntegerEntity(3)));
        listT.add(new LiteralInteger(new IntegerEntity(6)));

        Environment env = new Environment();
        env.getValues().put("x", new IntegerEntity(3));
        //env.getValues().put("secuencia", new ListEntity(listE));

        Exist e = new Exist("x", new ListTerm(listT), new Equals(new Variable("x"), new LiteralInteger(new IntegerEntity(3))));
        
        if(e.check(env))
            System.out.println("true");
        else
            System.out.println("false");
                
        
        
        
        
        List<Entity> listE2 = new LinkedList();
        listE.add(new IntegerEntity(8));
        listE.add(new IntegerEntity(6));
        listE.add(new IntegerEntity(3));

        List<Term> listT2 = new LinkedList();
        listT.add(new LiteralInteger(new IntegerEntity(8)));
        listT.add(new LiteralInteger(new IntegerEntity(6)));
        listT.add(new LiteralInteger(new IntegerEntity(3)));

        env.getValues().put("y", new IntegerEntity(3));
        
        
        List<Term> listTxy = new LinkedList();
        listT.add(new Variable("x"));
        listT.add(new Variable("y"));
        
        FunctionApplication sum = new FunctionApplication("sum",listTxy);
        Equals eq = new Equals(sum,new LiteralInteger(new IntegerEntity(9)));
        Exist existy = new Exist("y",new ListTerm(listT2),eq);
        ForAll fa = new ForAll("x",new ListTerm(listT),existy);
        
      
        if(fa.check(env))
            System.out.println("true");
        else
            System.out.println("false");
        
        
        
        
                
        
        
    }

}
