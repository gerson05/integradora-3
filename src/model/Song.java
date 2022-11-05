package model;

public class Song {
    private String name;
    private String album;
    private String gender;
    private String urlCoverPage;
    private double duration;
    private double value;
    private int reproductionNumber;
    private int numUnitsSold;

    public Song(String name, String album, String gender, String urlcoverLage, double duration, double value, int reproductionNumber, int numUnitsSold){
        this.name= name;
        this.album=album;
        this.gender= gender;
        this.urlCoverPage= urlcoverLage;
        this.duration= duration;
        this.value= value;
        this.reproductionNumber= reproductionNumber;
        this.numUnitsSold= numUnitsSold;

    }

    
    public String getName() {
        return name;
    }

    
    public void setName(String name) {
        this.name = name;
    }

    
    public String getAlbum() {
        return album;
    }

    
    public void setAlbum(String album) {
        this.album = album;
    }

    
    public String getGender() {
        return gender;
    }

    
    public void setGender(String gender) {
        this.gender = gender;
    }

    
    public String getUrlCoverPage() {
        return urlCoverPage;
    }

    
    public void setUrlCoverPage(String urlCoverPage) {
        this.urlCoverPage = urlCoverPage;
    }

    
    public double getDuration() {
        return duration;
    }

    
    public void setDuration(double duration) {
        this.duration = duration;
    }

    
    public double getValue() {
        return value;
    }

    
    public void setValue(double value) {
        this.value = value;
    }

    
    public int getReproductionNumber() {
        return reproductionNumber;
    }

    
    public void setReproductionNumber(int reproductionNumber) {
        this.reproductionNumber = reproductionNumber;
    }

    
    public int getNumUnitsSold() {
        return numUnitsSold;
    }

    
    public void setNumUnitsSold(int numUnitsSold) {
        this.numUnitsSold = numUnitsSold;
    }

}
