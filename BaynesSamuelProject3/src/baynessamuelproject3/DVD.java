/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baynessamuelproject3;

/**
 * DVD class that extends Inventory class
 * for Project 3
 * @author Samuel Baynes
 */
public class DVD extends Inventory {
    
    private String rating;
    private String director;
    
    /**
     * DVD Constructor, specific parameters for DVDs
     * @param _title DVD Title
     * @param _director Director
     * @param _price Price
     * @param _amount Amount in Inventory
     * @param _yearReleased Year Released
     * @param _itemNum Item ID Number
     * @param _rating Rating
     */
    public DVD(String _title, String _director, double _price, int _amount, int _yearReleased, int _itemNum, String _rating)
    {
        super(_title, _price, _amount, _yearReleased, _itemNum);
        this.director = _director;
        this.rating = _rating;
    }
    
    /**
     * Get the DVD's rating.
     * @return Rating of DVD
     */
    public String getRating()
    {
        return rating;
    }
    
    /**
     * Set the DVD rating.
     * @param _rating DVD rating
     */
    public void setRating(String _rating)
    {
        rating = _rating;
    }
    
     /**
     * Get the item's artist or creator's name.
     * @return director of the DVD
     */
    public String getDirector()
    {
        return director;
    }
    
    /**
     * Sets the Director that created the content.
     * @param _director Director of the content.
     */
    public void setDirector(String _director)
    {
        director = _director;
    }
    
    /**
    * Overrides the Inventory toString() to display additional information
    * relevant to DVDs.
    * @return DVD information
    */
    @Override
    public String toString()
    {
        return this.getTitle() + ", directed by " + this.getDirector() + "\n\t Rated: " + this.getRating() +
            "\n\t Release Date: " + this.getYearReleased() + "\n\t Price: $" + this.getPrice() + "\n\t ID Number: " +
            this.getItemNum() + "\n\t Copies Available: " + this.getAmount() + "\n";
    }
}
