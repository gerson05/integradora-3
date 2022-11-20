package model;

public class UserConsumer extends User {

    private double timeReached;
    private String contentFav;
    private String producerFav;
    
    public UserConsumer( String fecha, String nickname, String cc){
        super(fecha, nickname, cc);
        this.timeReached= 0;
        this.contentFav= null;
        this.producerFav= null;
    }

    public String toString(){
        String message = super.toString() +""+ timeReached +""+ contentFav+ "" + "" + producerFav;
        return message;
    }
   
    public double getTimeReached() {
        return timeReached;
    }

   
    public void setTimeReached(double timeReached) {
        this.timeReached = timeReached;
    }

   
    public String getContentFav() {
        return contentFav;
    }

   
    public void setContentFav(String contentFav) {
        this.contentFav = contentFav;
    }

  
    public String getProducerFav() {
        return producerFav;
    }

   
    public void setProducerFav(String producerFav) {
        this.producerFav = producerFav;
    }

}
