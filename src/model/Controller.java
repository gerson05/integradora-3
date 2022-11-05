package model;
import java.util.*;
public class Controller {

private ArrayList<User> users;
private ArrayList<Audio> audios;
private ArrayList<Song> songs;
private ArrayList<PodCast> podcasts;

public Controller(){
    users= new ArrayList<User>();
    audios = new ArrayList<Audio>();

    songs = new ArrayList<Song>();
    podcasts = new ArrayList<PodCast>();
}

public String addUserProducer(int typeUser,String name, String photo, int numVisualization,String fecha, String nickname, String cc){
String message = "";
users.add( new Artist(typeUser, name, photo, numVisualization, fecha, nickname, cc));
message= "the artist was create successful";
return message;
}

public String addUserProducer(String name, String photo, int numVisualization,int typeUser,String fecha, String nickname, String cc){
    String message = "";
    users.add( new CreatorContent(name, photo, numVisualization, typeUser, fecha, nickname, cc));
    message= "the creator content was create successful";
    return message;
}

public String addUserStandar(String fecha, String nickname, String cc){
    String message="";
    users.add(new UserStandar(fecha, nickname, cc));
    message ="the user standar was create successful";
    return message;
}

public String addUserPremium(){
    String message="";
    users.add(new UserPremium(message, message, message));
    message ="the user premium was create successful";
    return message;
}

public String addSong(String name, String album, String gender, String urlcoverLage, double duration, double value, int reproductionNumber, int numUnitsSold){
    String message= "";
    songs.add(new Song(gender, album, value, numUnitsSold, name, urlcoverLage, duration, reproductionNumber));
    message = "the song was add successful";
    return message;
}

public String addPodcast(String name, String description, String category, String urlCoverPage, double duration, int reproductionNumber){
    String message="";
    podcasts.add(new PodCast(category, name, urlCoverPage, duration, reproductionNumber));
    message = "the podcast was create successful";
    return message;
}
}


public boolean search(String cc){
    User objUser=null;
    boolean confirm= false;
    for(int i=0; i<users.size() && !confirm; i++){
    if(users.get(i).getCc().equalsIgnoreCase(cc)){
            objUser=users.get(i);
            confirm=true;
        }
        
    } 
    return confirm;
}