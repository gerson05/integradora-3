package model;

public class PodCast extends Audio {
    private String description;
    private int category;
    
    private Category categoryType;
    
    public PodCast(String name, String description, int category, String urlCoverPage, double duration, int reproductionNumber){
        super(name, urlCoverPage, duration, reproductionNumber);
        this.description= description;
        this.category= category;
        
        categoryType = chooseCategoryType(category);
    }
    
public Category chooseCategoryType(int category){
    switch(category){
        case 1:
        categoryType = Category.ENTERTEINMENT;
        break;

        case 2:
        categoryType = Category.FASHION;
        break;

        case 3:
        categoryType = Category.POLITICISM;
        break;

        case 4:
        categoryType = Category.VIDEOGAMES;
        break;

    }
    return categoryType;
}   

    /**
     * @return int return the category
     */
    public int getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(int category) {
        this.category = category;
    }


   
    /**
     * @return Category return the categoryType
     */
    public Category getCategoryType() {
        return categoryType;
    }

    /**
     * @param categoryType the categoryType to set
     */
    public void setCategoryType(Category categoryType) {
        this.categoryType = categoryType;
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

}
