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
            System.out.println("1. Agregar usuario consumidor");
            System.out.println("2. Agregar usuario productor");
            System.out.println("3. Registrar canciones y podcast");
            System.out.println("4. Crear una lista de reproducción");
            System.out.println("5. Editar una lista de reproducción");
            System.out.println("6. Cerrar menu");
            System.out.print("Opcion: ");
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

                    break;

                default:

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
        } while (controller.search(cc) == true);

        System.out.println("Enter the type user that you are\nuser consumer:\n1 for standar\n2 for premium");
        int opc2 = sc.nextInt();
        if (opc2 == 1) {
            System.out.println(controller.addUserStandar(date, nickname, cc)) ;
        } else if (opc2 == 2) {
            System.out.println(controller.addUserPremium(date, nickname, cc)) ;
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
        } while (controller.search(cc) == true);

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
                    sc.nextLine();
                    System.out.println("Enter the name of the song ");
                    String name = sc.nextLine();
                    System.out.println("Url of the representative image for album ");
                    String url = sc.nextLine();
                    System.out.println("album name ");
                    String album = sc.nextLine();
                    sc.nextLine();
                    System.out.println("duration of this song ");
                    double duration = sc.nextDouble();
                    System.out.println("reproduction number ");
                    int numRep = sc.nextInt();
                    System.out.println("units sold number ");
                    int numSold = sc.nextInt();
                    System.out.println("Gender: 1 rock\n2: pop\n3: trap\n4: house ");
                    int genre = sc.nextInt();
                    System.out.println("price for the article ");
                    double price = sc.nextDouble();
                    System.out
                            .println(controller.addContent(name, url, duration, numRep, album, price, numSold, genre, i));
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
        String name ="";
        System.out.println("Id de la playlist: ");
        int id = sc.nextInt();
        System.out.println("Qué quieres editar en la playlist?:" + "\n" +
                "1. Editar nombre. " + "\n" +
                "2. Agregar audios." + "\n" +
                "3. Quitar audios" + "\n" +
                "Opción: ");
        int opcion = sc.nextInt();
        switch (opcion) {
            case 1:
                System.out.println("Nombre nuevo para la playlist: ");
                String name2 = sc.nextLine();
                System.out.println(controller.editPlaylist(opcion, id, opcion, name));
                break;
            case 2:
                String obj = controller.searchObj(id).getName();
                System.out.println(controller.editPlaylist(opcion, id, opcion, name));
                break;
            case 3:
                String obj2 = controller.searchObj(id).getName();
                System.out.println(controller.editPlaylist(opcion, id, opcion, name));
            default:
                break;
        }

    }

}
