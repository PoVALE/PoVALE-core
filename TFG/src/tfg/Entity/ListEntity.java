package tfg.Entity;

import tfg.Entity.Entity;
import java.util.List;

public class ListEntity implements Entity{
    
    private List<Entity> list;

    public ListEntity(List<Entity> list) {
        this.list = list;
    }

    public List<Entity> getList() {
        return list;
        
    }
    
    public boolean addEntity(Entity e){
        return list.add(e);
    }
    
    
}
