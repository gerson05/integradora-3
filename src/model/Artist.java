package model;

import java.util.ArrayList;

public class Artist extends UserProducer{
    private int typeUser;
    private ArrayList<Song> songs;

    public Artist(int typeUser,String name, String photo,String fecha, String nickname, String cc){
        super(name, photo, fecha, nickname, cc);
        this.typeUser= typeUser;
        songs = new ArrayList<Song>();
    }

    public String addSong(String name, String album, String gender, String urlcoverLage, double duration, double value, int reproductionNumber, int numUnitsSold){
        String message= "";
        songs.add(new Song(name, album, numUnitsSold, urlcoverLage, duration, value, reproductionNumber, numUnitsSold));
        message = "the song was add successful";
        return message;
    }
    
   
    public int getTypeUser() {
        return typeUser;
    }

    
    public void setTypeUser(int typeUser) {
        this.typeUser = typeUser;
    }

}
