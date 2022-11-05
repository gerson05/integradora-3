package model;

public class PodCast {
    private String name;
    private String description;
    private String category;
    private String urlCoverPage;
    private double duration;
    private int reproductionNumber;
    
    public PodCast(String name, String description, String category, String urlCoverPage, double duration, int reproductionNumber){
        this.name= name;
        this.description=description;
        this.category= category;
        this.urlCoverPage= urlCoverPage;
        this.duration= duration;
        this.reproductionNumber=reproductionNumber;
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
     * @return String return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return String return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(String category) {
        this.category = category;
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
