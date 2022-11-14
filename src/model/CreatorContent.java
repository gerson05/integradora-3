package model;

import java.util.ArrayList;

public class CreatorContent extends UserProducer{
    private int typeUser;
    private ArrayList<PodCast> podcasts;

    public CreatorContent(String name, String photo,int typeUser,String fecha, String nickname, String cc){
        super(name, photo, fecha, nickname, cc);
        this.typeUser= typeUser;
        podcasts = new ArrayList<PodCast>();
    }

    public String addPodcast(String name, String description, int category, String urlCoverPage, double duration, int reproductionNumber){
    String message="";
    podcasts.add(new PodCast(name, description, category, urlCoverPage, duration, reproductionNumber));
    message = "the podcast was create successful";
    return message;
}
    
    public int getTypeUser() {
        return typeUser;
    }

    
    public void setTypeUser(int typeUser) {
        this.typeUser = typeUser;
    }

}
