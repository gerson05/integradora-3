package model;

import java.util.ArrayList;

public class UserPremium extends UserConsumer {

    private ArrayList<Playlist> playlists;

    public UserPremium(String fecha, String nickname, String cc) {
        super(fecha, nickname, cc);
    }

    public String addPlayList(String name) {
        String message = "";
        playlists.add(new Playlist(name));
        return message;
    }

    public String toString(){
        String message = super.toString();
        return message;
    }
    /**
     * @return ArrayList <Playlist> return the playlists
     */
    public ArrayList<Playlist> getPlaylists() {
        return playlists;
    }

    /**
     * @param playlists the playlists to set
     */
    public void setPlaylists(ArrayList<Playlist> playlists) {
        this.playlists = playlists;
    }

}
