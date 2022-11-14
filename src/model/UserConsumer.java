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
    /**
     * @return double return the timeReached
     */
    public double getTimeReached() {
        return timeReached;
    }

    /**
     * @param timeReached the timeReached to set
     */
    public void setTimeReached(double timeReached) {
        this.timeReached = timeReached;
    }

    /**
     * @return String return the contentFav
     */
    public String getContentFav() {
        return contentFav;
    }

    /**
     * @param contentFav the contentFav to set
     */
    public void setContentFav(String contentFav) {
        this.contentFav = contentFav;
    }

    /**
     * @return String return the producerFav
     */
    public String getProducerFav() {
        return producerFav;
    }

    /**
     * @param producerFav the producerFav to set
     */
    public void setProducerFav(String producerFav) {
        this.producerFav = producerFav;
    }

}
