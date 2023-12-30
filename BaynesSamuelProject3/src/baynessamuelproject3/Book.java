/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baynessamuelproject3;

/**
 * Book class extends Inventory class
 * for Project 3
 * @author Samuel Baynes
 */
public class Book extends Inventory {
    private boolean bestSeller = false;
    private String author;
    
    /**
     * Book Constructor, specific parameters for Books
     * @param _title Title
     * @param _author Author
     * @param _price Price
     * @param _amount Amount in Inventory
     * @param _yearReleased Year Released
     * @param _itemNum Item ID Number
     * @param _bestSeller Best Seller Status
     */
    public Book(String _title, String _author, double _price, int _amount, int _yearReleased, int _itemNum, boolean _bestSeller)
    {
        super(_title, _price, _amount, _yearReleased, _itemNum);
        this.author = _author;
        this.bestSeller = _bestSeller;
    }
    
    /**
     * Returns whether or not the book was a New York Time's best seller.
     * @return False if the book was not a best seller, true if it was.
     */
    public boolean isBestSeller()
    {
        return bestSeller;
    }
    
    public void setBestSeller(boolean _bestSeller)
    {
        bestSeller = _bestSeller;
    }
    
    /**
     * Displays if the book was a New York Times best seller
     * @param _bestSeller
     * @return Statement on whether it was a best seller or not.
     */
    public String bestSellerStatement(boolean _bestSeller)
    {
        String bestSellerStatement = "";
        if (_bestSeller != false)
        {
            bestSellerStatement= "***This book was a New York Times Best Seller!!***";
        }
        else{
            bestSellerStatement= "Did not appear on the New York Times Best Selling list";
        }
        return bestSellerStatement;
    }
    
     /**
     * Get the book's author name.
     * @return director of the DVD
     */
    public String getAuthor()
    {
        return author;
    }
    
    /**
     * Sets the Author of the book.
     * @param _author Author of the book.
     */
    public void setAuthor(String _author)
    {
        author = _author;
    }
    
    /**
     * Overrides the Inventory toString() to display additional information
     * relevant to books.
     * @return Book information
     */
    @Override
    public String toString()
    {
        return this.getTitle() + ", written by " + this.getAuthor() + "\n\t " + bestSellerStatement(this.isBestSeller()) 
            + "\n\t Release Date: " + this.getYearReleased() + "\n\t Price: $" + this.getPrice()
            + "\n\t ID Number: " + this.getItemNum() + "\n\t Copies Available: " + this.getAmount() + "\n";
    }
}
