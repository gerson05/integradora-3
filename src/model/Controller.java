package model;

import java.util.*;
import java.util.Timer;
import java.util.TimerTask;

public class Controller {

    private ArrayList<User> users;
    private ArrayList<Audio> audios;
    private ArrayList<Playlist> playlists;
    private ArrayList<UserProducer> creators;
    

    public Controller() {
        users = new ArrayList<User>();
        audios = new ArrayList<Audio>();
        playlists = new ArrayList<Playlist>();
        creators = new ArrayList<UserProducer>();

    }

    /**
     * Description: this method corresponds to register add user in general, with
     * the parameters of characterize
     * 
     * @param typeUser         (int ) the type of user producer
     * @param name             (String) the name of the person
     * @param photo            (String) the String of url for the picture
     * @param numVisualization (int ) the num of visualization for the content
     * @param fecha            (String) the particular date at the moment of
     *                         registration in the user
     * @param nickname         (String) nickname particular for each user most be
     *                         unic
     * @param cc               (String) id or number identification for each user
     *                         most be unic
     * @return (String) message of user create successfully
     */
    public String addUserProducer(int typeUser, String name, String photo, String fecha, String nickname, String cc) {
        String message = "";
        users.add(new Artist(typeUser, name, photo, fecha, nickname, cc));
        creators.add(new Artist(typeUser, name, photo, fecha, nickname, cc));
        message = "the artist was create successful";
        return message;
    }

    /**
     * Description: this method corresponds to register add user in general, with
     * the parameters of characterize
     * 
     * @param name             (String) the name of the person
     * @param photo            (String) the String of url for the picture
     * @param numVisualization (int ) the num of visualization for the content
     * @param typeUser         (int ) the type of user producer
     * @param fecha            (String) the particular date at the moment of
     *                         registration in the user
     * @param nickname         (String) nickname particular for each user most be
     *                         unic
     * @param cc               (String) id or number identification for each user
     *                         most be unic
     * @return (String) message of user create successfully
     */
    public String addUserProducer(String name, String photo, int typeUser, String fecha, String nickname, String cc) {
        String message = "";
        users.add(new CreatorContent(name, photo, typeUser, fecha, nickname, cc));
        creators.add(new CreatorContent(name, photo, typeUser, fecha, nickname, cc));
        message = "the creator content was create successful";
        return message;
    }

    /**
     * Description: this method register a user of type standart in the array of
     * users general
     * 
     * @param fecha    (String) the particular date at the moment of
     *                 registration in the user
     * @param nickname (String) nickname particular for each user most be
     *                 unic
     * @param cc       (String) id or number identification for each user
     *                 most be unic
     * @return (mesagge) confirmation message
     */
    public String addUserStandar(String fecha, String nickname, String cc) {
        String message = "";
        users.add(new UserStandar(fecha, nickname, cc));
        message = "the user standar was create successful";
        return message;
    }

    /**
     * Description: this method register a user of type standart in the array of
     * users general
     * 
     * @param fecha    (String) the particular date at the moment of
     *                 registration in the user
     * @param nickname (String) nickname particular for each user most be
     *                 unic
     * @param cc       (String) id or number identification for each user
     *                 most be unic
     * @return (message) confirmation message
     */
    public String addUserPremium(String fecha, String nickname, String cc) {
        String message = "";
        users.add(new UserPremium(fecha, nickname, cc));
        message = "the user premium was create successful";
        return message;
    }

    /**
     * Description: this method register the content (podcast) for a user producer
     * (creator content)
     * 
     * @param name               (String) name of the article/ podcast
     * @param description        (String) description of the podcast
     * @param category           (int) category selec for the tyoe of podcast
     * @param urlCoverPage       (String) the url for the image png cover
     * @param duration           (double ) the time of duration for the podcast
     * @param reproductionNumber (int) the total number of reproductions for the
     *                           pocast
     * @param number             (int) identification
     * @return (register) object
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
     * Description : this method register content (Song) for a user producer
     * (artist)
     * 
     * @param name    (String) name fo the song
     * @param url     (String) url coverpage for the song
     * @param length  (double) duration of the song
     * @param numRep  (int) total number of repetitions for the song
     * @param album   (String) album of the song
     * @param price   (doouble) price of the song
     * @param numSold (int) num of sold units for the song
     * @param genre   (int) option type for genre of the song
     * @param number  (int) identification
     * @return (register) object
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
     * Description: this method give information of user
     * 
     * @return (String) information of users
     */
    public String giveInformationPeople() {
        String message = "";
        for (int i = 0; i < users.size(); i++) {
            message = users.get(i).toString();
        }
        return message;
    }

    /**
     * Description: this method show the position of the artist
     * 
     * @return (String) message with the information of the position for the artist
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
     * Description: this method show the position for te creators content
     * 
     * @return (String) message with the information od position for the creator
     *         content
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
     * Description: this method add a new playlist for the user
     * 
     * @param name   (String) name of the playlist
     * @param cc     (String) identification of the user
     * @param option (int) option of type content for register in playlist
     * @return (String) message of confirmation
     */
    public String addPlaylist(String name, String cc, int userType) {
        String message = "User not found";
        User user = searchUser(cc, false);
        if (user != null & userType == 1) {
            UserStandar userStandar = (UserStandar) user;
            message = userStandar.addPlaylist(name);
            playlists.add(new Playlist(name));
        } else if (user != null && userType == 2) {
            UserPremium userPremium = (UserPremium) user;
            message = userPremium.addPlayList(name);
            playlists.add(new Playlist(name));
        }
        return message;
    }

    /**
     * Description:this method confirm if did exist a playlit with a id already
     * taken
     * 
     * @param id (double) the id
     * @return (boolean) the response
     */
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
     * Description: this method search a user
     * 
     * @param cc (String) the id of the user
     * @return (boolean) the response
     */
    public User searchUser(String id, boolean nickName) {
        boolean found = false;
        User user = null;
        for (int i = 0; i < users.size() && !found; i++) {
            User myUser = (users.get(i));
            if (nickName) {
                if (myUser.getNickname().equals(id)) {
                    found = true;
                    user = myUser;
                }
            } else {
                if (myUser.getCc().equals(id)) {
                    found = true;
                    user = myUser;
                }
            }
        }
        return user;
    }

    /**
     * Description: this method serach the position in the array for a user
     * 
     * @param nickName (String) the nickname of the user
     * @return (int) the position in the array
     */
    public int positionUser(String nickName) {
        User userOBJ = null;
        boolean exist = false;
        int position = 0;

        for (int i = 0; i < users.size() && !exist; i++) {
            if (users.get(i).getNickname().equals(nickName)) {
                userOBJ = users.get(i);
                exist = true;
                position = i;
            }
        }

        return position;
    }

    /**
     * Description: this method search the obj of content in the playlist
     * 
     * @param id (int) the id for the playlist
     * @return (object) the response
     */
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

    public User SearchNickname(String nickname) {
        User obj = null;
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getNickname().equals(nickname)) {
                obj = users.get(i);
            } else {
                System.out.println("did not exist an user");
            }
        }
        return obj;
    }

    /**
     * Description: this method give the total information of audios
     * 
     * @return(String) the message
     */
    public String giveInformationAudios() {
        String message = "";
        for (int i = 0; i < audios.size(); i++) {
            message = audios.get(i).toString();
        }
        return message;
    }

    /**
     * Description: the method allows edit the playlist for a user
     * 
     * @param option         (int) the option for edit playlist
     * @param optionPlaylist (int) option playlist
     * @param optionSong     (int) option song
     * @param nameUser       (String) name of user
     * @return (String) message of confirmation
     */
    public String editPlaylist(int option, int optionPlaylist, int optionSong, String nameUser) {
        String message = "";
        Audio objAudio = audios.get(optionSong - 1);
        User objUser = searchUser(nameUser, true);
        if (objUser instanceof UserStandar && objUser != null && option == 1) {
            UserStandar userStandard = (UserStandar) objUser;
            userStandard.getMyplaylist()[optionPlaylist - 1].getAudios().add(objAudio);
            message = "La canción ha sido añadida para el usuario standard";
        }
        
        if (objUser instanceof UserPremium && objUser != null && option == 1) {
            UserPremium userPremium = (UserPremium) objUser;
            userPremium.getPlaylists().get(optionPlaylist -1).getAudios().add(objAudio);
            message = "La canción ha sido añadida para el usuario premium";
        }

        if (objUser instanceof UserStandar && objUser != null && option == 2) {
            UserStandar userStandard = (UserStandar) objUser;
            userStandard.getMyplaylist()[optionPlaylist - 1].getAudios().remove(objAudio);
            message = "La canción ha sido eliminada para el usuario standard";
        } 
        
        if (objUser instanceof UserPremium && objUser != null && option == 2) {
            UserPremium userPremium = (UserPremium) objUser;
            userPremium.getPlaylists().get(optionPlaylist - 1).getAudios().remove(objAudio);
            message = "La canción" + "ha sido eliminada para el usuario Premium";
        }
        return message;
    }

    public void showAudios() {
        int count = 1;
        for (int i = 0; i < audios.size(); i++) {
            Audio audio = audios.get(i);
            System.out.println("" + count + "" + audio.getName() + " " + audio.getDuration());
            count++;
        }
    }

    /*
     * public void showAudiosOfPlaylist(int optionPlaylist, String nickname){
     * optionPlaylist--;
     * int cont =1;
     * Playlist playlist1 =null;
     * UserStandar objUser1 = null;
     * UserPremium objUser2= null;
     * User obj =SearchNickname(nickname);
     * if(obj instanceof UserStandar){
     * objUser1 =(UserStandar) obj;
     * playlist1 = objUser1.getMyplaylist()[optionPlaylist];
     * for(int i =0; i< playlist1)
     * }else if(obj instanceof UserPremium){
     * objUser2 = (UserPremium) obj;
     * for(int j=0;j<objUser2.getPlaylists().get(optionPlaylist).get;j++){
     * 
     * }
     * }
     * 
     * }
     */

    public void showPlaylist(String nickname) {
        UserStandar obj1 = null;
        UserPremium obj2 = null;
        User user = searchUser(nickname, true);
        if (user instanceof UserStandar) {
            obj1 = (UserStandar) user;
            int count = 1;
            for (int i = 0; i < obj1.getMyplaylist().length; i++) {
                Playlist playlist = obj1.getMyplaylist()[i];
                if (playlist != null) {
                    System.out.println(count + " - " + obj1.getMyplaylist()[i].getName());
                } else {
                    System.out.println(count + " - Available slot");
                }
                count++;
            }
        }        
        if (user instanceof UserPremium) {
            obj2 = (UserPremium) user;
            int count = 1;
            for (int i = 0; i < obj2.getPlaylists().size(); i++) {
                System.out.println(count + " - " + obj2.getPlaylists().get(i).getName());
                count++;
            }
        }
        if (user == null) {
            System.out.println("user not found");
        }        
    }

    /**
     * Description:this method fill the matrix with random numbers
     * 
     * @param matriz (int matrix) the matrix to share code
     */
    public void fillMatrix(String[][] matriz) {
        for (int x = 0; x < matriz.length; x++) {
            for (int y = 0; y < matriz[x].length; y++) {
                matriz[x][y] = "" + (int) (Math.random() * 35 + 1);
            }
        }
    }

    /**
     * Description: this method show the matrix
     * 
     * @param matriz (int matriz) the matriz
     */
    public void ShowMatrix(String [][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");

            }
        }
    }

    public String codeMatrixN(String[][] matriz) {
        String subcode1 = "";
        String subcode2 = "";
        String subcode3 = "";

        for (int i = 0; i < matriz.length; i++) {
            subcode1 += matriz[matriz.length - (i + 1)][0];
            if (i > 0 && i < matriz.length - 1) {
                subcode2 += matriz[i][i];
            }
            subcode3 += matriz[matriz.length - (i + 1)][5];
        }

        String code = subcode1 + subcode2 + subcode3;

        return code;
    }

    public String codeMatrixT(String[][] matriz) {
        String subcode1 = "";
        String subcode2 = "";
        String subcode3 = "";
        String subcode4 = "";
        // | 0,0 | 0,1 | 0,2 | 1,2 | 2,2 | 3,2 | 4,2 | 5,2 | 5,3 | 4,3 | 3,3 | 2,3 | 1,3
        // | 0,3 | 0,4 | 0,5 |
        for (int i = 0; i < matriz.length; i++) {
            if (i < 2) {
                subcode1 += matriz[0][i];
            }
            subcode2 += matriz[i][2];
            subcode3 += matriz[matriz.length - (i + 1)][3];
            if (i > 3) {
                subcode4 += matriz[0][i];
            }
        }

        String code = subcode1 + subcode2 + subcode3 + subcode4;
        return code;
    }

    public String codeMatrixR(String[][] matriz) {
        // | 5,4 | 5,2 | 5,0 | 4,5 | 4,3 | 4,1 | 3,4 | 3,2 | 3,0 | 2,5 | 2,3 | 2,1 | 1,4
        // | 1,2 | 0,5 | 0,3 |
        String subcode1 = "";
        String subcode2 = "";
        String subcode3 = "";
        String subcode4 = "";
        String subcode5 = "";
        String subcode6 = "";

        for (int i = matriz.length - 1; i > -1; i--) {
            if (i % 2 == 0) {
                subcode1 += matriz[5][i];
                subcode3 += matriz[3][i];
            }

            if (i % 2 == 1) {
                subcode2 += matriz[4][i];
                subcode4 += matriz[2][i];
            }

            if (i > 1) {
                if (i % 2 == 0) {
                    subcode5 += matriz[1][i];
                } else {
                    subcode6 += matriz[0][i];
                }
            }
        }

        String code = subcode1 + subcode2 + subcode3 + subcode4 + subcode5 + subcode6;
        return code;
    }

    public String buySong(int option) {
        Song obj = null;
        PodCast obj2=null;
        System.out.println("select the song for purchase");
        showAudios();
        if (audios.get(-option) instanceof Song) {
            obj = (Song) audios.get(-option);
            obj.setNumUnitsSold(+1);
            return "the song: " + obj.getName() + " was purchase sucssefully";
        }else{
            obj2 = (PodCast) audios.get(-option);
            return "the podcast: " + obj2.getName() + " was purchase sucssefully";
        } 
        

    }

    /**
     * Description: this method show the genre more listened for the song
     * 
     * @return (String) the more listened genre
     */
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

    /**
     * Description: this method show the category more listened for the podcast
     * 
     * @return(String) the more listenes categories
     */
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
        } else if (count3 > count1 && count3 > count2 && count3 > count4) {
            mesagge = "the most listened genre is House" + rpdNumer3 + "reproductions";
        } else if (count4 > count1 && count4 > count2 && count1 > count3) {
            mesagge = "the most listened genre is Trap" + rpdNumer4 + "reproductions";
        }
        return mesagge;
    }

    /**
     * Description: total number of reproductions for podcast and songs
     * 
     * @return (String) message with the number of reproductions for podcast and
     *         songs
     */
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

    /**
     * Description: this method show the units sold for the genre int the songs
     * 
     * @return (String) message with units sold for genre
     */
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

    /**
     * Description: this method return the most sold song in the plataform
     * 
     * @return (String) message with the most sold song
     */
    public String mostSoldSong() {
        double value = 0.0;
        Song objsong = null;
        Song winner = null;
        for (int i = 0; i < audios.size(); i++) {
            if (audios.get(i) instanceof Song) {
                objsong = (Song) audios.get(i);
                winner = objsong;
                if (objsong.getNumUnitsSold() > winner.getNumUnitsSold()) {
                    winner = objsong;
                }
            }
        }
        value = winner.getNumUnitsSold() * winner.getValue();

        return "the song with more units solds are: " + winner.getName() + "with: " + winner.getNumUnitsSold()
                + " units sold" + "with a total price of $" + value;
    }

    /**
     * Description: this method return the code for share
     * 
     * @param opc    (int) the option selected for the user
     * @param matriz (int Matrix) the matrix with the random numbers for generate
     *               the code
     * @return(String) message with the code
     */
    public String shareMatrix(int opc) {
        String message = "";
        if (opc == 1) {
            System.out.print("you choose share song");

        } else if (opc == 2) {
            System.out.print("you choose share podcast");
        } else if (opc == 3) {
            System.out.print("you choose share playlist");
        }
        return message;
    }

    /**
     * Description: this method return the top of creators and artist
     * 
     * @return(String) message with the data
     */
    public String top5ArtistAndCreators() {
        String msj = "Top 5 artistas:\n";
        msj += top5Artist() + "\n" + "Top 5 creadores de contenido:\n";
        msj += top5Creators();
        return msj;
    }

    /**
     * Description: this the method return the top 5 artist
     * 
     * @return(String) message with the top
     */
    public String top5Artist() {
        String msj = "Top | Name | Plays\n";
        String[] names = new String[5];
        double[] plays = new double[5];
        int producerPlays;
        String name;
        int position;
        for (int i = 0; i < 5; i++) {
            names[i] = "-----";
        }
        for (int i = 0; i < creators.size(); i++) {
            if (creators.get(i) instanceof Artist) {
                producerPlays = creators.get(i).getNumVisualization();
                name = creators.get(i).getName();
                position = -1;
                for (int j = 0; j < 5; j++) {
                    if (producerPlays > plays[j]) {
                        position = j;
                    }
                }
                for (int j = 1; j <= position; j++) {
                    plays[j - 1] = plays[j];
                    names[j - 1] = names[j];
                }
                if (position != -1) {
                    plays[position] = producerPlays;
                    names[position] = name;
                }
            }
        }
        int top = 1;
        for (int i = 4; i >= 0; i--) {
            msj += top + " | " + names[i] + " | " + plays[i] + "\n";
            top++;
        }
        return msj;
    }

    /**
     * Description:this method return the top 5 of creators content
     * 
     * @return(String) message with the top
     */
    public String top5Creators() {
        String msj = "Top | Name | Plays\n";
        String[] names = new String[5];
        double[] plays = new double[5];
        int producerPlays;

        String name;
        int position;
        for (int i = 0; i < 5; i++) {
            names[i] = "-----";
        }
        for (int i = 0; i < creators.size(); i++) {
            if (creators.get(i) instanceof CreatorContent) {
                producerPlays = creators.get(i).getNumVisualization();
                name = creators.get(i).getName();
                position = -1;
                for (int j = 0; j < 5; j++) {
                    if (producerPlays > plays[j]) {
                        position = j;
                    }
                }
                for (int j = 1; j <= position; j++) {
                    plays[j - 1] = plays[j];
                    names[j - 1] = names[j];
                }
                if (position != -1) {
                    plays[position] = producerPlays;
                    names[position] = name;
                }
            }
        }
        int top = 1;
        for (int i = 4; i >= 0; i--) {
            msj += top + " | " + names[i] + " | " + plays[i] + "\n";
            top++;
        }
        return msj;
    }

    /**
     * Description: this method return the top of songs and podcast
     * 
     * @return(String) message with the top
     */
    public String top10SongsAndPodcasts() {
        String msj = "Top 10 canciones:\n";
        msj += top5Artist() + "\n" + "Top 10 podcasts:\n";
        msj += top5Creators();
        return msj;
    }

    /**
     * Description: this method return the top 10 of songs
     * 
     * @return(String) message with the top
     */
    public String top10Songs() {
        String msj = "Top | Name | Plays\n";
        String[] names = new String[10];
        double[] plays = new double[10];
        int audioPlays;
        String name;
        int position;
        for (int i = 0; i < 5; i++) {
            names[i] = "-----";
        }
        for (int i = 0; i < audios.size(); i++) {
            if (audios.get(i) instanceof Song) {
                audioPlays = audios.get(i).getReproductionNumber();
                name = audios.get(i).getName();
                position = -1;
                for (int j = 0; j < 5; j++) {
                    if (audioPlays > plays[j]) {
                        position = j;
                    }
                }
                for (int j = 1; j <= position; j++) {
                    plays[j - 1] = plays[j];
                    names[j - 1] = names[j];
                }
                if (position != -1) {
                    plays[position] = audioPlays;
                    names[position] = name;
                }
            }
        }
        int top = 1;
        for (int i = 4; i >= 0; i--) {
            msj += top + " | " + names[i] + " | " + plays[i] + "\n";
            top++;
        }
        return msj;
    }

    public void playPlayList(String userID, String playListName) {
        
        
        Playlist playList = searchPlaylist(userID,playListName);
        Timer timer = new Timer();
        TimerTask reproducir = new TimerTask() {
            public void run() {
                System.out.println("Playing playlist: "  + playList.getName());
            }
        };
        timer.schedule(reproducir, 0, playList.totalDuration() * 60000);
    }

    public Playlist searchPlaylist(String id,String name){
        Playlist obj=null;
        UserStandar obj2=null;
        UserPremium obj3=null;
        User objUser= null;
        for(int i=0; i<users.size();i++){
            if(users.get(i).getCc().equals(id)){
                objUser= users.get(i);
                if(objUser instanceof UserStandar){
                    obj2 = (UserStandar) users.get(i);
                    for(int j=0;j<obj2.getMyplaylist().length;j++){
                        if(obj2.getMyplaylist()[j].getName().equals(name)){
                            obj=obj2.getMyplaylist()[j];
                        }
                    }
                }else if(users.get(i) instanceof UserPremium){
                    obj3=(UserPremium) users.get(i);
                    for(int k=0;k<obj3.getPlaylists().size();k++){
                        if(obj3.getPlaylists().get(k).getName().equals(name)){
                            obj=obj3.getPlaylists().get(k);
                        }
                    }
                } 
            }
        }
        return obj;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public ArrayList<Audio> getAudios() {
        return audios;
    }

    public void setAudios(ArrayList<Audio> audios) {
        this.audios = audios;
    }

    public ArrayList<Playlist> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(ArrayList<Playlist> playlists) {
        this.playlists = playlists;
    }

}
