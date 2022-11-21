package model;

public class UserStandar extends UserConsumer {

    private static int MAX_PLAYLIST_LENGHT = 20;

    private int purshasedSongs;
    private int createAlbum;

    private Playlist[] myplaylist;
    private Ads ads;

    public UserStandar(String fecha, String nickname, String cc) {
        super(fecha, nickname, cc);
        myplaylist = new Playlist[MAX_PLAYLIST_LENGHT];
    }


    public String addPlaylist(String name) {
        String message = "Already exist a playlist with that id";
        boolean added = false;
        if (!searchPlaylist(name)) {
            for (int i = 0; i < myplaylist.length && !added; i++) {
                if (myplaylist[i] == null) {
                    myplaylist[i] = new Playlist(name);
                    message = "Playlist created successfully";
                    added = true;
                }
            }
        }
        if (!added) {
            message = "User already has reached the maximum number of playlist created";
        }
        return message;        
    }

    private boolean searchPlaylist(String name) {
        boolean found = false;
        for (int i = 0; i < myplaylist.length && !found; i++) {
            if (myplaylist[i] != null && myplaylist[i].getName().equals(name)) {
                found = true;
            }
        }
        return found;
    }

    public String toString() {
        String message = super.toString();
        return message;
    }

  
    public int getPurshasedSongs() {
        return purshasedSongs;
    }

   
    public void setPurshasedSongs(int purshasedSongs) {
        this.purshasedSongs = purshasedSongs;
    }

  
    public int getCreateAlbum() {
        return createAlbum;
    }

   
    public void setCreateAlbum(int createAlbum) {
        this.createAlbum = createAlbum;
    }

    
    public Playlist[] getMyplaylist() {
        return myplaylist;
    }

   
    public void setMyplaylist(Playlist[] myplaylist) {
        this.myplaylist = myplaylist;
    }

   
    public Ads getAds() {
        return ads;
    }

    
    public void setAds(Ads ads) {
        this.ads = ads;
    }

}