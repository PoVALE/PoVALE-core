package tfg.entity;

import java.util.LinkedList;
import tfg.entity.Entity;
import java.util.List;

public class ListEntity implements Entity{
    
    private List<Entity> list;

    public ListEntity(List<? extends Entity> list) {
        this.list = new LinkedList<>();
        this.list.addAll(list);
    }

    public List<Entity> getList() {
        return list;
        
    }
    
    public boolean addEntity(Entity e){
        return list.add(e);
    }
    
    @Override
    public Class<? extends Entity> getType() {
        return  ListEntity.class;
    }
}
