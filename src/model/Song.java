package model;

public class Song extends Audio {
    private String album;
    private double value;
    private int numUnitsSold;

    private Gender genderType;

    public Song(String name, String album, int gender, String urlcoverLage, double duration, double value, int reproductionNumber, int numUnitsSold){
        super(name, urlcoverLage, duration, reproductionNumber);
        this.album=album;
        this.value= value;
        this.numUnitsSold= numUnitsSold;
        genderType = chooseGenderType(gender);

    }

    public Gender chooseGenderType(int gender){
        switch(gender){
            case 1:
            genderType= Gender.POP;
            break;

            case 2:
            genderType= Gender.ROCK;
            break;

            case 3: 
            genderType= Gender.TRAP;
            break;

            case 4: 
            genderType= Gender.HOUSE;
            break;
        }
        return genderType;
    }

    
   
    
    public String getAlbum() {
        return album;
    }

    
    public void setAlbum(String album) {
        this.album = album;
    }
    
    public double getValue() {
        return value;
    }

    
    public void setValue(double value) {
        this.value = value;
    }
    
    public int getNumUnitsSold() {
        return numUnitsSold;
    }

    public void setNumUnitsSold(int numUnitsSold) {
        this.numUnitsSold = numUnitsSold;
    }


    


    /**
     * @return Gender return the genderType
     */
    public Gender getGenderType() {
        return genderType;
    }

    /**
     * @param genderType the genderType to set
     */
    public void setGenderType(Gender genderType) {
        this.genderType = genderType;
    }

}
