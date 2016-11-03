
package tfg.Assertion;

import tfg.Environment.Environment;



public class Not implements Assertion {
    
    private Assertion assertion;
    
    public Not(Assertion assertion) {
	super();
	this.assertion = assertion;
    }
    
    public Assertion getAssertion() {
        return assertion;
    }
    
    public void setAssertion(Assertion assertion) {
	this.assertion = assertion;
    }
    
    public boolean check(Environment env){
        if (assertion.check(env))
            return false;
        else
            return true;
    }
    
}
