package model;

public class CreatorContent extends UserProducer{
    private int typeUser;

    public CreatorContent(String name, String photo, int numVisualization,int typeUser){
        super(name, photo, numVisualization);
        this.typeUser= typeUser;
    }

    
    public int getTypeUser() {
        return typeUser;
    }

    
    public void setTypeUser(int typeUser) {
        this.typeUser = typeUser;
    }

}
