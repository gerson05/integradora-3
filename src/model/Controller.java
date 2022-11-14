package model;

import java.util.*;

public class Controller {

    private ArrayList<User> users;
    private ArrayList<Audio> audios;
    private ArrayList<Playlist> playlists;

    public Controller() {
        users = new ArrayList<User>();
        audios = new ArrayList<Audio>();

    }

    /**
     * 
     * @param typeUser
     * @param name
     * @param photo
     * @param numVisualization
     * @param fecha
     * @param nickname
     * @param cc
     * @return
     */
    public String addUserProducer(int typeUser, String name, String photo, String fecha,String nickname, String cc) {
        String message = "";
        users.add(new Artist(typeUser, name, photo, fecha, nickname, cc));
        message = "the artist was create successful";
        return message;
    }

    /**
     * 
     * @param name
     * @param photo
     * @param numVisualization
     * @param typeUser
     * @param fecha
     * @param nickname
     * @param cc
     * @return
     */
    public String addUserProducer(String name, String photo, int typeUser, String fecha, String nickname, String cc) {
        String message = "";
        users.add(new CreatorContent(name, photo, typeUser, fecha, nickname, cc));
        message = "the creator content was create successful";
        return message;
    }

    /**
     * 
     * @param fecha
     * @param nickname
     * @param cc
     * @return
     */
    public String addUserStandar(String fecha, String nickname, String cc) {
        String message = "";
        users.add(new UserStandar(fecha, nickname, cc));
        message = "the user standar was create successful";
        return message;
    }

    /**
     * 
     * @param fecha
     * @param nickname
     * @param cc
     * @return
     */
    public String addUserPremium(String fecha, String nickname, String cc) {
        String message = "";
        users.add(new UserPremium(fecha, nickname, cc));
        message = "the user premium was create successful";
        return message;
    }

    /**
     * 
     * @param name
     * @param url
     * @param length
     * @param numRep
     * @param desc
     * @param category
     * @param number
     * @return
     */
    public String addContent(String name, String description, int category, String urlCoverPage, double duration,
            int reproductionNumber, int number) {
        String register = "";
        audios.add(new PodCast(name, description, category, urlCoverPage, duration, reproductionNumber));
        if (users.get(number) instanceof CreatorContent) {
            CreatorContent obj = (CreatorContent) users.get(number);
            register = obj.addPodcast(name,description, category, urlCoverPage, duration, reproductionNumber);
        }
        return register;
    }

    /**
     * 
     * @param name
     * @param url
     * @param length
     * @param numRep
     * @param album
     * @param price
     * @param numSold
     * @param genre
     * @param number
     * @return
     */
    public String addContent(String name, String url, double length, int numRep, String album, double price,
            int numSold, int genre, int number) {
        String register = "";
        audios.add(new Song(name, album, genre, url, numSold, genre, number, number));
        if (users.get(number) instanceof Artist) {
            Artist obj = (Artist) users.get(number);
            register = obj.addSong(name, album, register, url, numSold, genre, number, number);
        }
        return register;
    }

    /**
     * 
     * @return
     */
    public String giveInformationPeople() {
        String message = "";
        for (int i = 0; i < users.size(); i++) {
            message = users.get(i).toString();
        }
        return message;
    }

    /**
     * 
     * @return
     */
    public String showArtists() {
        String position = "";
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i) instanceof Artist) {
                Artist obj = (Artist) users.get(i);
                position += i + ". " + obj.getName() + " (Nickname: " + obj.getNickname() + ")." + "\n";
            }
        }
        return position;
    }

    /**
     * 
     * @return
     */
    public String showCreators() {
        String position = "";
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i) instanceof CreatorContent) {
                CreatorContent obj = (CreatorContent) users.get(i);
                position += i + ". " + obj.getName() + " (Nickname: " + obj.getNickname() + ")." + "\n";
            }
        }
        return position;
    }

    /**
     * 
     * @param name
     * @param cc
     * @param option
     * @return
     */
    public String addPlaylist(String name, String cc, int option) {
        String message = "";
        boolean confirm = search(cc);
        if (!confirm & option == 1) {
            for (int i = 0; i < users.size(); i++) {
                if (users.get(i) instanceof UserStandar) {
                    UserStandar obj = (UserStandar) users.get(i);
                    if (obj.getCc().equalsIgnoreCase(cc)) {
                        message = obj.addPlaylist(name);
                        playlists.add(new Playlist(name));
                    }
                }
            }
        } else if (!confirm & option == 2) {
            for (int i = 0; i < users.size(); i++) {
                if (users.get(i) instanceof UserPremium) {
                    UserPremium obj = (UserPremium) users.get(i);
                    if (obj.getCc().equalsIgnoreCase(cc)) {
                        message = obj.addPlayList(name);
                        playlists.add(new Playlist(name));
                    }
                }
            }
        }
        return message;
    }

    public User searchU(String cc){
        User objUser=null;
        boolean confirm= false;
        for(int i=0; i<users.size() && !confirm; i++){
            if(users.get(i).getCc().equalsIgnoreCase(cc)){
                objUser=users.get(i);
                confirm=true;
            }
        } 
        return objUser;
    }
    /**
     * 
     * @param cc
     * @return
     */
    public boolean search(String cc) {
        User objUser = null;
        boolean confirm = false;
        for (int i = 0; i < users.size() && !confirm; i++) {
            if (users.get(i).getCc().equalsIgnoreCase(cc)) {
                objUser = users.get(i);
                confirm = true;
            }

        }
        return confirm;
    }

    public Playlist searchObj(int id){
        Playlist obj=null;
        boolean confirm= false;
        for(int i=0; i<playlists.size() && !confirm; i++){
            if(playlists.get(i).getId()==id){
                    obj=playlists.get(i);
                    confirm=true;
                }
            } 
        return obj;
    }

    
    public String giveInformationAudios(){
        String message="";
        for(int i=0; i<audios.size(); i++){
                message=audios.get(i).toString();
        }
        return message;
    }


    
    
    
      public String editPlaylist(String name, int option, int id){
      String message="";
      Playlist obj = searchObj(id);
      if(obj!=null){
      if(option==1){
      obj.setName(name);
      }else if(option==2){
      }
      }
      return message;
      }
     

    /**
     * @return ArrayList<User> return the users
     */
    public ArrayList<User> getUsers() {
        return users;
    }

    /**
     * @param users the users to set
     */
    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    /**
     * @return ArrayList<Audio> return the audios
     */
    public ArrayList<Audio> getAudios() {
        return audios;
    }

    /**
     * @param audios the audios to set
     */
    public void setAudios(ArrayList<Audio> audios) {
        this.audios = audios;
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
