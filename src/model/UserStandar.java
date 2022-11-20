package model;

public class UserStandar extends UserConsumer {
    private int purshasedSongs;
    private int createAlbum;

    private Playlist[] myplaylist;
    private Ads ads;

    public UserStandar(String fecha, String nickname, String cc) {
        super(fecha, nickname, cc);
        myplaylist = new Playlist[20];
    }


    public String addPlaylist(String name) {
        String message = "";
        boolean stop = false;
        for (int i = 0; i < myplaylist.length && !stop; i++) {
            if (myplaylist[i] == null) {
                myplaylist[i] = new Playlist(name);
                message = "Playlist created successfully";
                stop = true;
            }
        }
        if(stop == true){
            message = "Already exist a playlist with that id.";
        }
        
        return message;
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