package tfg.entity;


public class IntegerEntity implements Entity{
    
    private int n;

    public IntegerEntity(int n) {
        this.n = n;
    }

    public int getValue() {
        return n;
    }
   
    @Override
    public boolean equals(Object obj) {
        IntegerEntity b = (IntegerEntity)obj;
        return (this.n == b.n);
    }

    @Override
    public Class<? extends Entity> getType() {
        return IntegerEntity.class;
    }
}
