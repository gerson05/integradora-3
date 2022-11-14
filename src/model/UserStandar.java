package model;

public class UserStandar extends UserConsumer{
    private int purshasedSongs;
    private int createAlbum;

    private Playlist [] myplaylist;
    private Ads ads;

public UserStandar(String fecha, String nickname, String cc){
    super(fecha, nickname, cc);
    myplaylist = new Playlist[20];
}

public String addPlaylist(String name){
    String message="";
    boolean stop = false;
    for (int i = 0;i<myPlaylist.length && !stop; i++){
            if(myPlaylist[i] == null){
                    myPlaylist[i] = new Playlist(name);
                    message="Playlist created successfully";
                    stop = true;
            }message="Already exist a playlist with that id.";
    }
    return message;
}

}