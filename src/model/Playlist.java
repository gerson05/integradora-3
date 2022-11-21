package model;

import java.util.ArrayList;
import java.lang.Math;

public class Playlist {
    private String name;
    private double id;

    private ArrayList <Audio> audios;
    public Playlist(String name){
        this.name= name;
        id= Math.random()*100;
        audios = new ArrayList <Audio>();
    }

    public int totalDuration() {
        double total = 0.0;
        for (int i = 0; i < audios.size(); i++) {
            total += audios.get(i).getDuration();
        }
        return (int) Math.ceil(total);
    }
  
    public String getName() {
        return name;
    }

   
    public void setName(String name) {
        this.name = name;
    }

    
    public double getId() {
        return id;
    }

   
    public void setId(int id) {
        this.id = id;
    }
   
    public ArrayList <Audio> getAudios() {
        return audios;
    }

    
    public void setAudios(ArrayList <Audio> audios) {
        this.audios = audios;
    }

}
