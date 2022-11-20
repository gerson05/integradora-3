package model;
public class User{
    private String fecha;
    private String nickname; 
    private String cc;
    
public User(String fecha, String nickname, String cc){
this.fecha= fecha;
this.nickname=nickname;
this.cc=cc;
}

public String toString(){
    String message =nickname+""+ cc+""+ fecha;
    return message;
}
   
    public String getNickname() {
        return nickname;
    }

  
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

   
    public String getCc() {
        return cc;
    }

    
    public void setCc(String cc) {
        this.cc = cc;
    }


    public String getFecha() {
        return fecha;
    }

    
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

}