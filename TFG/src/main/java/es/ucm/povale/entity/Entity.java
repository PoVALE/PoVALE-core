package es.ucm.povale.entity;


public interface Entity {
    
    default Class<? extends Entity> getType(){
        return this.getClass();
    }
}