package model;

import java.security.MessageDigest;
import java.util.*;

public class Controller {

    private ArrayList<User> users;
    private ArrayList<Audio> audios;
    private ArrayList<Playlist> playlists;
    int[][] matriz = new int[6][6];

    public Controller() {
        users = new ArrayList<User>();
        audios = new ArrayList<Audio>();
        playlists = new ArrayList<Playlist>();

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
    public String addUserProducer(int typeUser, String name, String photo, String fecha, String nickname, String cc) {
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
            register = obj.addPodcast(name, description, category, urlCoverPage, duration, reproductionNumber);
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
    public String addPlaylist(String name, String cc, int userType) {
        String message = "user not found";
        if (search(cc) & userType == 1) {
            for (int i = 0; i < users.size(); i++) {
                if (users.get(i) instanceof UserStandar) {
                    UserStandar obj = (UserStandar) users.get(i);
                    if (obj.getCc().equals(cc)) {
                        if (searchIdPlaylist(i) == false) {
                            message = obj.addPlaylist(name);
                            playlists.add(new Playlist(name));
                        }
                    }
                }
            }
        } else if (search(cc) & userType == 2) {
            for (int i = 0; i < users.size(); i++) {
                if (users.get(i) instanceof UserPremium) {
                    UserPremium obj = (UserPremium) users.get(i);
                    if (obj.getCc().equals(cc)) {
                        if (searchIdPlaylist(i) == false) {
                            message = obj.addPlayList(name);
                            playlists.add(new Playlist(name));
                        }
                    }
                }
            }
        }
        return message;
    }

    public User searchU(String cc) {
        User objUser = null;
        boolean confirm = false;
        for (int i = 0; i < users.size() && !confirm; i++) {
            if (users.get(i).getCc().equalsIgnoreCase(cc)) {
                objUser = users.get(i);
                confirm = true;
            }
        }
        return objUser;
    }

    public boolean searchIdPlaylist(double id) {
        boolean condition = false;
        for (int i = 0; i < playlists.size() && !condition; i++) {
            if (playlists.get(i).getId() == id) {
                condition = true;
            }
        }
        return condition;
    }

    /**
     * 
     * @param cc
     * @return
     */
    public boolean search(String cc) {
        boolean confirm = false;
        for (int i = 0; i < users.size() && !confirm; i++) {
            if (users.get(i).getCc().equals(cc)) {
                confirm = true;
            }

        }
        return confirm;
    }

    public Playlist searchObj(int id) {
        Playlist obj = null;
        boolean confirm = false;
        for (int i = 0; i < playlists.size() && !confirm; i++) {
            if (playlists.get(i).getId() == id) {
                obj = playlists.get(i);
                confirm = true;
            }
        }
        return obj;
    }

    public String giveInformationAudios() {
        String message = "";
        for (int i = 0; i < audios.size(); i++) {
            message = audios.get(i).toString();
        }
        return message;
    }

    public String editPlaylist(String name, int option, int id) {
        String message = "";
        Playlist obj = searchObj(id);
        if (obj != null) {
            if (option == 1) {
                obj.setName(name);
            } else if (option == 2) {
            }
        }
        return message;
    }

    public void fillMatrix(int[][] matriz) {
        for (int x = 0; x < matriz.length; x++) {
            for (int y = 0; y < matriz[x].length; y++) {
                matriz[x][y] = (int) (Math.random() * 35 + 1);
            }
        }
    }

    public static void ShowMatrix(int[][] square) {
        for (int i = 0; i < square.length; i++) {
            for (int j = 0; j < square[i].length; j++) {
                if (square[i][j] < 10) {
                    System.out.print(" " + square[i][j] + " ");
                } else {
                    System.out.print(square[i][j] + " ");
                }

            }
        }
    }

    public String genreMorseListened() {
        int rpdNumer1 = 0, rpdNumer2 = 0, rpdNumer3 = 0, rpdNumer4 = 0;
        Song objaudio = null;
        int count1 = 0, count2 = 0, count3 = 0, count4 = 0;
        String mesagge = "";
        for (int i = 0; i < audios.size(); i++) {
            if (audios.get(i) instanceof Song) {
                objaudio = (Song) audios.get(i);
                if (objaudio.getGenderType() == Gender.POP) {
                    count1++;
                    rpdNumer1 += objaudio.getReproductionNumber();

                } else if (objaudio.getGenderType() == Gender.ROCK) {
                    count2++;
                    rpdNumer2 += objaudio.getReproductionNumber();

                } else if (objaudio.getGenderType() == Gender.HOUSE) {
                    count3++;
                    rpdNumer3 += objaudio.getReproductionNumber();

                } else if (objaudio.getGenderType() == Gender.TRAP) {
                    count4++;
                    rpdNumer4 += objaudio.getReproductionNumber();
                }
            }
        }

        if (count1 > count2 && count1 > count3 && count1 > count4) {
            mesagge = "the most listened genre is Pop with: " + rpdNumer1 + "reproductions";
        } else if (count2 > count1 && count2 > count3 && count2 > count4) {
            mesagge = "the most listened genre is Rock" + rpdNumer2 + "reproductions";
        } else if (count3 > count1 && count1 > count2 && count1 > count4) {
            mesagge = "the most listened genre is House" + rpdNumer3 + "reproductions";
        } else if (count4 > count1 && count4 > count2 && count1 > count3) {
            mesagge = "the most listened genre is Trap" + rpdNumer4 + "reproductions";
        }
        return mesagge;
    }

    public String categoryMorseListened() {
        int rpdNumer1 = 0, rpdNumer2 = 0, rpdNumer3 = 0, rpdNumer4 = 0;
        PodCast objpodcast = null;
        int count1 = 0, count2 = 0, count3 = 0, count4 = 0;
        String mesagge = "";
        for (int i = 0; i < audios.size(); i++) {
            if (audios.get(i) instanceof PodCast) {
                objpodcast = (PodCast) audios.get(i);
                if (objpodcast.getCategoryType() == Category.ENTERTEINMENT) {
                    count1++;
                    rpdNumer1 += objpodcast.getReproductionNumber();

                } else if (objpodcast.getCategoryType() == Category.FASHION) {
                    count2++;
                    rpdNumer2 += objpodcast.getReproductionNumber();

                } else if (objpodcast.getCategoryType() == Category.POLITICISM) {
                    count3++;
                    rpdNumer3 += objpodcast.getReproductionNumber();

                } else if (objpodcast.getCategoryType() == Category.VIDEOGAMES) {
                    count4++;
                    rpdNumer4 += objpodcast.getReproductionNumber();
                }
            }
        }

        if (count1 > count2 && count1 > count3 && count1 > count4) {
            mesagge = "the most listened genre is Pop with: " + rpdNumer1 + "reproductions";
        } else if (count2 > count1 && count2 > count3 && count2 > count4) {
            mesagge = "the most listened genre is Rock" + rpdNumer2 + "reproductions";
        } else if (count3 > count1 && count1 > count2 && count1 > count4) {
            mesagge = "the most listened genre is House" + rpdNumer3 + "reproductions";
        } else if (count4 > count1 && count4 > count2 && count1 > count3) {
            mesagge = "the most listened genre is Trap" + rpdNumer4 + "reproductions";
        }
        return mesagge;
    }

    public String totalNumReproductions() {
        int rpd1 = 0, rpd2 = 0;
        Song objsong = null;
        PodCast objpodcast = null;
        for (int i = 0; i < audios.size(); i++) {
            if (audios.get(i) instanceof Song) {
                objsong = (Song) audios.get(i);
                rpd1 += objsong.getReproductionNumber();
            } else if (audios.get(i) instanceof PodCast) {
                objpodcast = (PodCast) audios.get(i);
                rpd2 = objpodcast.getReproductionNumber();
            }
        }
        return "the number of reproductions for Songs are: " + rpd1 + " the number of reproductions for Podcast are: "
                + rpd2;
    }

    // private void sortPlayersByScore() {
    // Artist objArtist= null;
    // Artist nextArtist = null;
    // CreatorContent objCreatorContent = null;
    // CreatorContent nextcCreatorContent=null;

    // for (int i = 0; i < users.size(); i++) {
    // for (int j = 0; j < users.size() - 1; j++) {
    // if(users.get(i) instanceof Artist){
    // if(users.get(j) instanceof Artist){
    // objArtist = (Artist) users.get(i);
    // nextArtist =(Artist) users.get(j+1);
    // if ( objArtist.getPoints() < nextPlayer.getPoints()) {
    // players[j] = nextPlayer;
    // players[j+1] = currentPlayer;
    // }
    // }

    // }

    // }

    // }
    // }

    public String unitsSoldForGenre() {
        int units1 = 0, units2 = 0, units3 = 0, units4 = 0;
        Song objsong = null;
        for (int i = 0; i < audios.size(); i++) {
            if (audios.get(i) instanceof Song) {
                objsong = (Song) audios.get(i);

                if (objsong.getGenderType() == Gender.HOUSE) {
                    units1 += objsong.getNumUnitsSold();

                } else if (objsong.getGenderType() == Gender.POP) {
                    units2 += objsong.getNumUnitsSold();

                } else if (objsong.getGenderType() == Gender.ROCK) {
                    units3 += objsong.getNumUnitsSold();

                } else if (objsong.getGenderType() == Gender.TRAP) {
                    units4 += objsong.getNumUnitsSold();
                }
            }
        }

        return "the number of units sold for genre House are: " + units1
                + " the number of units sold for genre pop are: " + units2 + "the number of units sold for rock are: "
                + units3 + "the numeber of units sold for trap are: " + units4;
    }

    public String mostSoldSong(){
        double value =0.0;
        Song objsong=null;
        Song winner = null;
        for(int i=0;i< audios.size();i++){
            if(audios.get(i) instanceof Song){
                objsong= (Song) audios.get(i);
                winner = objsong;
                if(objsong.getNumUnitsSold()>winner.getNumUnitsSold()){
                    winner = objsong;
                }
            }
        }
        value = winner.getNumUnitsSold()* winner.getValue();

        return"the song with more units solds are: "+ winner.getName() + "with: "+ winner.getNumUnitsSold()+ " units sold" + "with a total price of $"+ value;
    }

    public String shareMatrix(int opc, int[][] matriz) {
        String message = "";
        if (opc == 1) {
            System.out.print("you choose share playlist");

        } else if (opc == 2) {
            System.out.print("you choose share song");
        } else if (opc == 3) {
            System.out.print("you choose share podcast");
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
