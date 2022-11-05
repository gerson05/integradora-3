package model;

public class Artist extends UserProducer{
    private int typeUser;

    public Artist(int typeUser,String name, String photo, int numVisualization){
        super(name, photo, numVisualization);
        this.typeUser= typeUser;
    }

    /**
     * @return int return the typeUser
     */
    public int getTypeUser() {
        return typeUser;
    }

    /**
     * @param typeUser the typeUser to set
     */
    public void setTypeUser(int typeUser) {
        this.typeUser = typeUser;
    }

}
