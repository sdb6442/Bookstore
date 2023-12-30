/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package baynessamuelproject3;

/**
 * BookstoreSpecification Interface
 * @author Samuel Baynes
 */
public interface BookstoreSpecification {
    
    /**
     * Given a product ID and a product quantity, stock is updated
     * by adding an amount to existing product quantity
     * @param productID
     * @param amount
     * @return 
     */
    public int restockProduct (int productID, int amount);
    
    /**
     * Calculates and returns dollar amount for current inventory of products in stock
     * @return 
     */
    public double inventoryValue();
}
