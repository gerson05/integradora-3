package model;
import java.util.Date;

public class UserProducer extends User{
Date fecha = new Date(0, 0, 0);    
private String name;
private String photo;
private int numVisualization;

 
public UserProducer(String name, String photo, int numVisualization){
this.name=name;
this.photo=photo;
this.numVisualization=numVisualization;

}

    public String getName() {
        return name;
    }

    
    public void setName(String name) {
        this.name = name;
    }

  
    public String getPhoto() {
        return photo;
    }

    
    public void setPhoto(String photo) {
        this.photo = photo;
    }

    
    public int getNumVisualization() {
        return numVisualization;
    }

    
    public void setNumVisualization(int numVisualization) {
        this.numVisualization = numVisualization;
    }

    
   

}
