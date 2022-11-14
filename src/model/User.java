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
    /**
     * @return String return the nickname
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * @param nickname the nickname to set
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * @return String return the cc
     */
    public String getCc() {
        return cc;
    }

    /**
     * @param cc the cc to set
     */
    public void setCc(String cc) {
        this.cc = cc;
    }


    /**
     * @return String return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

}