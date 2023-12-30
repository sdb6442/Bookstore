/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baynessamuelproject3;

/**
 * Inventory of bookstore
 * for Project 3
 * @author Samuel Baynes
 */
public abstract class Inventory implements Comparable<Inventory>{
    private String title;
    private double price;
    private int amount;
    private int yearReleased;
    private int itemNum;
    
    /**
     * Inventory Constructor, sets the following parameters for each bookstore item.
     * @param _title  Title of item
     * @param _price Price of the item
     * @param _amount Amount of items in stock
     * @param _yearReleased Release date of item
     * @param _itemNum Unique ID number found in the system.
     */
    public Inventory(String _title, double _price, int _amount, int _yearReleased, int _itemNum)
    {
        title = _title;
        price = _price;
        amount = _amount;
        yearReleased = _yearReleased;
        itemNum = _itemNum;
    }
    
    /**
     * Get the item's title.
     * @return title Title to the CD, DVD, or Book
     */
    public String getTitle()
    {
        return title;
    }
    
    /** Sets the title of the item in the system.
     * @param _title Title of the item.
     */
    public void setTitle(String _title)
    {
        title = _title;
    }
    

    /**
     * Returns the price of the item
     * @return price Price of the item.
     */
    public double getPrice()
    {
        return price;
    }
    
    /**Sets the price of the item for the store.
     * 
     * @param _price  Item's price.
     */
    public void setPrice(double _price)
    {
        price = _price;
    }
    
    /**
     * Returns the number of the items available for sale.
     * @return amount Amount of items in inventory.
     */
    public int getAmount()
    {
        return amount;
    }
    
    /**Sets the amount of items in stock.
     * 
     * @param _amount Amount of items.
     */
    public void setAmount(int _amount)
    {
        amount = _amount;
    }
    
    /**
     * Returns the release date (year) of the item.
     * @return yearReleased Year the item was released.
     */
    public int getYearReleased()
    {
        return yearReleased;
    }
    
    /**
     * Sets the year of the item's release.
     * @param _yearReleased Release date.
     */
    public void setYearReleased(int _yearReleased)
    {
        yearReleased = _yearReleased;
    }
    
    /**
     * Returns the unique ID number of the item.
     * @return 
     */
    public int getItemNum()
    {
        return itemNum;
    }
    
    /**
     * Allows the user to set the item's ID number.
     * @param _itemNum Item's ID Number
     */
    public void setitemNum(int _itemNum)
    {
        itemNum = _itemNum;
    }
    

    /**
     * Displays the Item ID, Title, and Price at Checkout. Used to provide output
     * that is cleaner and consistent with all of the different product types.
     * @return Item ID Number, Title, and Price
     */
    public String display()
    {
        return "ITEM ID: " + itemNum + " >>> " + title + " >>> $" + price;
    }

    /**
     * Compares two item's prices against each other and returns values depending on which amount is greater.
     * @param o Inventory item to compare first item against
     * @return Positive number, Negative number, or Zero, used to compare the objects.
     */
    @Override
    public int compareTo(Inventory o) {
        double firstItemPrice = getPrice();
        double oPrice = o.getPrice();
        
        if (firstItemPrice > oPrice)
            {
                return 1;
            }
        else if (firstItemPrice < oPrice)
            {
                return -1; 
            }
        else
            {
                return 0;
            }
    }
    
    
}
