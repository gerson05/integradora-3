package model;

import java.util.ArrayList;

public class Playlist {
    private String name;
    private double id;

    private ArrayList <Audio> audios;
    public Playlist(String name){
        this.name= name;
        id= Math.random()*100;
        audios = new ArrayList <Audio>();
    }

    /**
     * @return String return the name
     * 
     * 
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return int return the id
     */
    public double getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }


 

    /**
     * @return ArrayList <Audio> return the audios
     */
    public ArrayList <Audio> getAudios() {
        return audios;
    }

    /**
     * @param audios the audios to set
     */
    public void setAudios(ArrayList <Audio> audios) {
        this.audios = audios;
    }

}
