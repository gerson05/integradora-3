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

    /**
     * @return int return the purshasedSongs
     */
    public int getPurshasedSongs() {
        return purshasedSongs;
    }

    /**
     * @param purshasedSongs the purshasedSongs to set
     */
    public void setPurshasedSongs(int purshasedSongs) {
        this.purshasedSongs = purshasedSongs;
    }

    /**
     * @return int return the createAlbum
     */
    public int getCreateAlbum() {
        return createAlbum;
    }

    /**
     * @param createAlbum the createAlbum to set
     */
    public void setCreateAlbum(int createAlbum) {
        this.createAlbum = createAlbum;
    }

    /**
     * @return Playlist [] return the myplaylist
     */
    public Playlist[] getMyplaylist() {
        return myplaylist;
    }

    /**
     * @param myplaylist the myplaylist to set
     */
    public void setMyplaylist(Playlist[] myplaylist) {
        this.myplaylist = myplaylist;
    }

    /**
     * @return Ads return the ads
     */
    public Ads getAds() {
        return ads;
    }

    /**
     * @param ads the ads to set
     */
    public void setAds(Ads ads) {
        this.ads = ads;
    }

}