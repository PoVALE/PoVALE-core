package tfg.Entity;


public class StringEntity implements Entity{
    
    private String s;

    public StringEntity(String s) {
        this.s = s;
    }
    
    @Override
    public boolean equals(Object obj) {
        StringEntity b = (StringEntity)obj;
        return (this.s == b.s);
    }
    

    
    
    
}
