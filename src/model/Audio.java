package model;

public class Audio {
    private String name;
    private String urlCoverPage;
    private double duration;
    private int reproductionNumber;

    public Audio(String name,  String urlcoverLage, double duration, int reproductionNumber){
        this.name= name;
        this.urlCoverPage= urlcoverLage;
        this.duration= duration;
        this.reproductionNumber= reproductionNumber;

    }


    /**
     * @return String return the name
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
     * @return String return the urlCoverPage
     */
    public String getUrlCoverPage() {
        return urlCoverPage;
    }

    /**
     * @param urlCoverPage the urlCoverPage to set
     */
    public void setUrlCoverPage(String urlCoverPage) {
        this.urlCoverPage = urlCoverPage;
    }

    /**
     * @return double return the duration
     */
    public double getDuration() {
        return duration;
    }

    /**
     * @param duration the duration to set
     */
    public void setDuration(double duration) {
        this.duration = duration;
    }


    /**
     * @return int return the reproductionNumber
     */
    public int getReproductionNumber() {
        return reproductionNumber;
    }

    /**
     * @param reproductionNumber the reproductionNumber to set
     */
    public void setReproductionNumber(int reproductionNumber) {
        this.reproductionNumber = reproductionNumber;
    }

}
