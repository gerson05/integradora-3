package ui;

import java.util.*;
import model.Controller;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    Controller controller;

    public Main() {
        controller = new Controller();
    }

    public static void main(String[] args) {
        Main tool = new Main();
        int opc = 0;

        while (opc != 6) {
            System.out.println("Menu");
            System.out.println("1. add user consumer");
            System.out.println("2. add user producer");
            System.out.println("3. register podcast and song");
            System.out.println("4. create playlist");
            System.out.println("5. edit playlist");
            System.out.println("6. share code");
            System.out.println("7. reproduce playlist");
            System.out.println("8. shop song ");
            System.out.println("9. total reproductions");
            System.out.println("10. most listened genre");
            System.out.println("11. most listened category");
            System.out.print("12. top plataform");
            System.out.println("13.top content plataform");
            System.out.println("14. most listened song");
            System.out.println("15. close");
            opc = sc.nextInt();
            sc.nextLine();

            switch (opc) {
                case 1:
                    tool.registerUser();
                    break;
                case 2:
                    tool.registerUserProducer();
                    break;
                case 3:
                    tool.addAudio();
                    break;

                case 4:
                    tool.createPlaylist();
                    break;

                case 5:
                    tool.editPlaylist();
                    break;

                case 6:
                    tool.shareCode();
                    break;
                case 7:
                    tool.reproducePlaylist();
                    break;

                case 8:
                    tool.shopSong();
                    break;

                case 9:
                    tool.totalReproductions();

                case 10:
                    tool.moreListenedGenre();
                    break;

                case 11:
                    tool.moreListenedCategory();
                    break;

                case 12:
                    tool.topPlataform();
                    break;

                case 13:
                    tool.topContentPlataform();
                    break;

                case 14:
                    tool.mostSoldSong();
                    break;

                case 15:
                    System.out.println("bye bye");
                    break;

                default:
                    System.out.println("que es eso mi so?");
                    break;
            }
        }
    }

    public void registerUser() {
        String cc = "";
        System.out.println("Enter the date acording for this register");
        String date = sc.nextLine();

        System.out.println("Enter the nickname");
        String nickname = sc.nextLine();
        System.out.println();

        do {
            System.out.println("Número de cédula: ");
            cc = sc.nextLine();
        } while (controller.searchUser(cc, false) != null);

        System.out.println("Enter the type user that you are\nuser consumer:\n1 for standar\n2 for premium");
        int opc2 = sc.nextInt();
        if (opc2 == 1) {
            System.out.println(controller.addUserStandar(date, nickname, cc));
        } else if (opc2 == 2) {
            System.out.println(controller.addUserPremium(date, nickname, cc));
        }
    }

    public void registerUserProducer() {
        String cc = "";

        System.out.println("Enter the date acording for this register");
        String date = sc.nextLine();
        System.out.println("Enter the nickname");
        String nickname = sc.nextLine();
        System.out.println();

        do {
            System.out.println("Número de cédula: ");
            cc = sc.nextLine();
        } while (controller.searchUser(cc, false) != null);

        System.out.println("Enter the name");
        String name = sc.nextLine();

        System.out.println("Enter the url for you representative image ");
        String photo = sc.nextLine();

        System.out.println("Enter the user producer type\n1 for artist\n2 for creator content");
        int typeUser = sc.nextInt();
        if (typeUser == 1) {
            System.out.println(controller.addUserProducer(typeUser, name, photo, date, nickname, cc));
        } else if (typeUser == 2) {
            System.out.println(controller.addUserProducer(name, photo, typeUser, date, nickname, cc));
        }

    }

    public void addAudio() {
        String show = "";
        System.out.println("El usuario al que le pertenece el contenido es: \n" +
                "1. Artista \n" +
                "2. Creador de contenido \n" +
                "Opción: ");
        int opcion1 = sc.nextInt();
        sc.nextLine();

        switch (opcion1) {
            case 1:
                System.out.println("Choose artist");
                show = controller.showArtists();
                System.out.println(show);
                if (!show.equalsIgnoreCase("")) {
                    int i = sc.nextInt();
                    System.out.println("Enter the name of the song ");
                    String name = sc.nextLine();
                    sc.nextLine();
                    System.out.println("Url of the representative image for album ");
                    String url = sc.nextLine();
                    System.out.println("album name ");
                    String album = sc.nextLine();
                    System.out.println("duration of this song ");
                    double duration = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("reproduction number ");
                    int numRep = sc.nextInt();
                    sc.nextLine();
                    System.out.println("units sold number ");
                    int numSold = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Gender\n: 1 rock\n2: pop\n3: trap\n4: house ");
                    int genre = sc.nextInt();
                    sc.nextLine();
                    System.out.println("price for the article ");
                    double price = sc.nextDouble();
                    sc.nextLine();
                    System.out
                            .println(controller.addContent(name, url, duration, numRep, album, price, numSold, genre,
                                    i));
                    System.out.println("Ver datos...");
                    System.out.println(controller.giveInformationAudios());
                }
                System.out.println("no there artist registered with that parameters ");
                break;

            case 2:
                System.out.println("choose crator content");
                show = controller.showCreators();
                System.out.println(show);
                if (!show.equalsIgnoreCase("")) {
                    int i = sc.nextInt();
                    sc.nextLine();
                    System.out.println("name of podcast ");
                    String name = sc.nextLine();
                    System.out.println("Url representative image ");
                    String url = sc.nextLine();
                    System.out.println("description ");
                    String description = sc.nextLine();
                    sc.nextLine();
                    System.out.println("Duración del podcast: ");
                    double duration = sc.nextDouble();
                    System.out.println("reproduction number ");
                    int numRep = sc.nextInt();
                    System.out.println("Categoría:\n1: Politicism\n2: enterteiment\n3: videogame\n4: fashion ");
                    int category = sc.nextInt();
                    System.out.println(controller.addContent(name, description, category, url, duration, numRep, i));
                    System.out.println("Ver datos...");
                    System.out.println(controller.giveInformationAudios());
                }
                System.out.println("No hay creadores de contenidos aún registrados para almacenar su contenido. ");
                break;

            default:
                break;
        }
    }

    public void createPlaylist() {
        System.out.println("Consumidor de tipo: 1.Standar\n 2.Premium \nOpción: ");
        int opcion = sc.nextInt();
        sc.nextLine();
        System.out.println("Identificación del usuario: ");
        String cc = sc.nextLine();
        System.out.println("Nombre de la playlist: ");
        String name = sc.nextLine();
        System.out.println(controller.addPlaylist(name, cc, opcion));
    }

    public void editPlaylist() {
        System.out.println("Enter the nickname ");
        String nickname = sc.nextLine();

        controller.showPlaylist(nickname);
        System.out.println("select the playlist to edit");
        int optionPlaylist = sc.nextInt();

        System.out.println("What action do you want execute?" + "\n" +
                "1. add audios." + "\n" +
                "2. delete audios" + "\n" +
                "option: ");
        int option = sc.nextInt();
        switch (option) {

            case 1:
                if (option == 1) {
                    controller.showAudios();
                    System.out.println("select an audio");
                    int optionAudio = sc.nextInt();
                    System.out.println(controller.editPlaylist(option, optionPlaylist,optionAudio , nickname));
                }
            case 2:
                if(option==2){
                    controller.showAudios();
                    System.out.println("select an audio");
                    int optionAudio = sc.nextInt();
                    System.out.println(controller.editPlaylist(option, optionPlaylist,optionAudio , nickname));
                }
            default:
                break;
        }

    }

    public void shareCode() {
        String[][] matriz = new String[6][6];
        System.out.println("type 1 if you can share the code of song\n2 for share podcast\n3 for share both");
        int opc = sc.nextInt();
        if(opc==1){
            controller.fillMatrix(matriz);
            controller.ShowMatrix(matriz);
            controller.codeMatrixN(matriz);
            
        }

        if(opc ==2){
            controller.fillMatrix(matriz);
            controller.ShowMatrix(matriz);
            controller.codeMatrixT(matriz);
        }

        if(opc ==3){
            controller.fillMatrix(matriz);
            controller.ShowMatrix(matriz);
            controller.codeMatrixR(matriz);
        }
        
    }

    public void reproducePlaylist() {
        System.out.println("type the cc");
        String id= sc.nextLine();
        System.out.println("type the name of playlist");
        String name= sc.nextLine();
        controller.playPlayList(id, name);
        System.out.println();
    }

    public void shopSong() {
        controller.showAudios();
        System.out.println("select an option");
        int opc = sc.nextInt();
        controller.buySong(opc);
    }

    public void totalReproductions() {
        controller.totalNumReproductions();
    }

    public void moreListenedGenre() {
        controller.genreMorseListened();
    }

    public void moreListenedCategory() {
        controller.categoryMorseListened();
    }

    public void topPlataform() {
        controller.top5ArtistAndCreators();
    }

    public void topContentPlataform() {
        controller.top10SongsAndPodcasts();
    }

    public void mostSoldSong() {
        controller.mostSoldSong();
    }
}
