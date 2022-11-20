package model;

import java.util.ArrayList;

public class UserPremium extends UserConsumer {

    private ArrayList<Playlist> playlists;

    public UserPremium(String fecha, String nickname, String cc) {
        super(fecha, nickname, cc);
    }

    public String addPlayList(String name) {
        playlists.add(new Playlist(name));
        return "The playlist created successfully";
    }

    public String toString() {
        String message = super.toString();
        return message;
    }

   
    public ArrayList<Playlist> getPlaylists() {
        return playlists;
    }

    
    public void setPlaylists(ArrayList<Playlist> playlists) {
        this.playlists = playlists;
    }

}
