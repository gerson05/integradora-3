package model;
import java.util.*;

public class UserProducer extends User{ 
private String name;
private String photo;
private int numVisualization;

 
public UserProducer(String name, String photo,String fecha, String nickname, String cc){
    super(fecha, nickname, cc);
this.name=name;
this.photo=photo;
this.numVisualization=0;
}
public String toString(){
    String message = super.toString() +""+ name+"" +""+ photo+""+ "" +numVisualization;
    return message;
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
