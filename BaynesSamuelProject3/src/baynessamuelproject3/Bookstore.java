/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baynessamuelproject3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Bookstore functions for project 3.
 * @author Samuel Baynes
 * @since 8/1/2022
 * @version 3.0
 */
public class Bookstore implements BookstoreSpecification {
    
    private ArrayList<Members> membersList = new ArrayList<>();
    private ArrayList<Inventory> inventoryList = new ArrayList<>();
    private ArrayList<Members> newMembersList = new ArrayList<>(); // new members added. Resets after daily report is generated.
    private ArrayList<Inventory> productsSold = new ArrayList<>(); //daily products sold. Resets after daily report is generated.
    private static int nextItemNum;
    private static int nextMemberNum;
    private int monthlyFee = 5;
    
    /**
     * Bookstore Constructor, used to implement and create the Inventory and Member lists and information
     */
    public Bookstore()
    {
        //Read daily inventory file and create inventory items (CDs, DVDs, Books) for program
        Scanner fileScanner;
        try{   
            fileScanner = new Scanner(new File("ProductInventory-1.csv")); //enter filepath here
            String line;
            while (fileScanner.hasNext()) // Read lines and create objects to add to ArrayList inventoryList
            {
                line = fileScanner.nextLine();
                String[] elements = line.split(",");
                if(line.contains("book")) // Create Book objects and add to inventoryList
                {
                   int _itemNum = Integer.parseInt(elements[0]);
                   String _title = elements[2];
                   String _author = elements[3];
                   double _price = Double.parseDouble(elements[5]);
                   int _amount = Integer.parseInt(elements[4]);
                   int _yearReleased = Integer.parseInt(elements[6]);
                   boolean _bestSeller = Boolean.parseBoolean(elements[7]);
                   Inventory item1 = new Book(_title, _author, _price, _amount, _yearReleased,  _itemNum, _bestSeller);
                   inventoryList.add(item1);
                   incrementNextItemNum();  
                }
                if(line.contains("cd")) // Create CD objects and add to inventoryList
                {
                   int _itemNum = Integer.parseInt(elements[0]);
                   String _title = elements[2];
                   String _band = elements[3];
                   double _price = Double.parseDouble(elements[5]);
                   int _amount = Integer.parseInt(elements[4]);
                   int _yearReleased = Integer.parseInt(elements[6]);
                   int _chartRanking = Integer.parseInt(elements[9]);
                   Inventory item1 = new CD(_title, _band, _price, _amount, _yearReleased,  _itemNum, _chartRanking);
                   inventoryList.add(item1);
                   incrementNextItemNum();  
                }
                if(line.contains("dvd")) // Create DVD objects and add to inventoryList
                {
                   int _itemNum = Integer.parseInt(elements[0]);
                   String _title = elements[2];
                   String _director = elements[3];
                   double _price = Double.parseDouble(elements[5]);
                   int _amount = Integer.parseInt(elements[4]);
                   int _yearReleased = Integer.parseInt(elements[6]);
                   String _rating = elements[8];
                   Inventory item1 = new DVD(_title, _director, _price, _amount, _yearReleased,  _itemNum, _rating);
                   inventoryList.add(item1);
                   incrementNextItemNum();  
                }
            }
            fileScanner.close();    
        }catch (FileNotFoundException ex){
            System.out.println("Caught FileNotFoundException for C:/Users/WhatI/Documents/NetBeansProjects/ProductInventory-1.csv. Try again making sure the file name and path are correct.");
        }catch (ArrayIndexOutOfBoundsException ex){
            System.out.println("Caught ArrayIndexOutofBoundsException for inputData.txt. Please enter the remaining inventory parameters.");
        }catch (NumberFormatException ex){
            System.out.println("Caught NumberFormatException for C:/Users/WhatI/Documents/NetBeansProjects/ProductInventory-1.csv. Missing inventory item parameters.");
        }

        //Members currently in system
        Members member1 = new Members("Sam", "sdbaynes@uncc.edu", 1, true, true, "Cash", 350, 2999);
        Members member2 = new Members("David", "david@gmail.com", 2, true, false, "Credit", 0, 150.65);
        Members member3 = new Members("John", "john@gmail.com", 3, false, false, "Cash", 0, 10.00);
        Members member4 = new Members("Bruce", "bruce@hotmail.com", 4, true, false, "Cash", 0, 18.95);
        Members member5 = new Members("Jake", "jake@gmail.com", 5, false, false, "Credit", 0, 205.16);
        
        membersList.add(member1);
        incrementNextMemberNum();
        membersList.add(member2);
        incrementNextMemberNum();
        membersList.add(member3);
        incrementNextMemberNum();
        membersList.add(member4);
        incrementNextMemberNum();
        membersList.add(member5);
        incrementNextMemberNum();
        
    }
    
    /**
     * Get the next member number.
     * @return nextMemberNum;
     */
    public int getNextMemberNum()
    {
        return nextMemberNum;
    }
    
    /**
     * Increments the member numbers.
     */
    private static void incrementNextMemberNum()
    {
        nextMemberNum++;
    }
    
    /**
     * Get the next item number.
     * @return nextItemNum Next items numbers.
     */
    public int getNextItemNum()
    {
        return nextItemNum;
    }
    
    /**
     * Increments the item numbers
     * @return The incremented item number.
     */
    private static void incrementNextItemNum()
    {
        nextItemNum++;
    }
    
    /**
     * Used to create a new member
     * @param _name
     * @param _email
     * @param _memberID
     * @param _premiumStatus
     * @param _owePremiumFee
     * @param _paymentMethod
     * @param _balance
     * @param _totalSpent
     * @return Returns the new Member ID Number
     */
    public int addMember(String _name, String _email, int _memberID, boolean _premiumStatus, boolean _owePremiumFee, String _paymentMethod, double _balance,
            double _totalSpent)
    {
        incrementNextMemberNum();
        Members member6 = new Members(_name, _email, nextMemberNum, _premiumStatus, _owePremiumFee, _paymentMethod, _balance, _totalSpent);
        membersList.add(member6);
        newMembersList.add(member6);
        int newMemberID = getNextMemberNum();
        return newMemberID;
    }
    
    /**
     * Used to add a CD to the inventory
     * @param _title CD title
     * @param _band Band
     * @param _price Price of CD
     * @param _amount Amount in stock
     * @param _yearReleased Year released
     * @param _itemNum New item number
     * @param _chartRanking Peak US chart position
     * @return Returns the new CD's ID Number
     */
    public int addCD(String _title, String _band, double _price, int _amount, int _yearReleased, int _itemNum, int _chartRanking)
    {
        incrementNextItemNum();
        Inventory item21 = new CD(_title, _band, _price, _amount, _yearReleased, nextItemNum, _chartRanking);
        inventoryList.add(item21);
        int newItemNum = getNextItemNum();
        return newItemNum;
    }
    
    /**
     * Used to add a DVD to the inventory
     * @param _title DVD title
     * @param _director Director's name
     * @param _price Price of DVD
     * @param _amount Amount in stock
     * @param _yearReleased Year released
     * @param _itemNum New item number
     * @param _rating Movie rating
     * @return Returns the new DVD's ID Number
     */
    public int addDVD(String _title, String _director, double _price, int _amount, int _yearReleased, int _itemNum, String _rating)
    {
        incrementNextItemNum();
        Inventory item21 = new DVD(_title, _director, _price, _amount, _yearReleased, nextItemNum, _rating);
        inventoryList.add(item21);
        int newItemNum = getNextItemNum();
        return newItemNum;
    }
    
    /**
     * Used to add a Book to the inventory
     * @param _title Book title
     * @param _author Author's name
     * @param _price Price of Book
     * @param _amount Amount in stock
     * @param _yearReleased Year released
     * @param _itemNum New item number
     * @param _bestSeller Best seller status
     * @return Returns the new Book's ID Number
     */
    public int addBook(String _title, String _author, double _price, int _amount, int _yearReleased, int _itemNum, boolean _bestSeller)
    {
        incrementNextItemNum();
        Inventory item21 = new Book(_title, _author, _price, _amount, _yearReleased, nextItemNum, _bestSeller);
        inventoryList.add(item21);
        int newItemNum = getNextItemNum();
        return newItemNum;
    }    
    
    /**
     * Removes item from inventoryList and changes the ID Numbers of the remaining
     * items so no number is skipped. This is necessary because the indexes of the
     * items on the inventoryList and the ID Numbers work concurrently within some methods 
     * used in the program.
     * @param _itemID Item ID Number
     */
    public void removeInventory(int _itemID)
    {
        for(int i = 0; i < inventoryList.size(); i++)
        {
            if(inventoryList.get(i).getItemNum() == _itemID)
            {
                inventoryList.remove(i);
            }
        }
        for(int j = 0; j < inventoryList.size(); j++)
        {
            if(inventoryList.get(j).getItemNum()== _itemID)
            {
                inventoryList.get(j).setitemNum(j);
            }
            else if(inventoryList.get(j).getItemNum()> _itemID)
            {
                inventoryList.get(j).setitemNum(j+1);
            }
        }
    }
    
    /**
     * Decrement the amount of units available in the inventory.
     * @param _itemID Item ID Number
     */
    public void decrementItemAmount(int _itemID)
    {
        for(int i = 0; i < inventoryList.size(); i++)
        {
            if(inventoryList.get(i).getItemNum() == _itemID)
            {
                inventoryList.get(i).setAmount(inventoryList.get(i).getAmount()-1);
            }
        }
    }
    /**
     * Accesses the Members List
     * @return List of Members
     */
    public ArrayList<Members> getMembersList()
    {
        return membersList;
    }       
   
    /**
     * Accesses the Inventory List
     * @return inventoryList Items in inventory.
     */
    public ArrayList<Inventory> getInventoryList()
    {
        return inventoryList;
    }
    
    /**
     * Accesses the New Members List
     * @return List of New Members
     */
    public ArrayList<Members> getNewMembersList()
    {
        return newMembersList;
    }
 
    /**
     * Accesses the Products Sold List
     * @return List of Products Sold
     */
    public ArrayList<Inventory> getProductsSold()
    {
        return productsSold;
    }
    
    /**
     * Created a readable format for printing a member's information out.
     * @param _memberID Member ID number
     * @return A statement with the member's information
     */
    public String displayMember(int _memberID)
    {
        String member = "";
        String twoDecimalBalance;
        String twoDecimalLifetimeBalance;
        for(int i = 0; i< membersList.size(); i++)
        {
            if (membersList.get(i).getMemberID() == _memberID)
            {
            twoDecimalBalance = String.format("%.2f", membersList.get(i).getBalance());
            twoDecimalLifetimeBalance = String.format("%.2f", membersList.get(i).getTotalSpent());
            return "MEMBER ID:" + membersList.get(i).getMemberID()+ " >>NAME:" + membersList.get(i).getName() + " >>EMAIL:" + membersList.get(i).getEmail() + " >>MEMBERSHIP STATUS:" + membersList.get(i).checkMemberStatus()
                    + " >>PREFFERRED PAYMENT:" + membersList.get(i).getPaymentMethod() + " >> BALANCE:$" + twoDecimalBalance + " >>LIFETIME SPENDING:$" + twoDecimalLifetimeBalance;
            }
        }
        return member;
    }
    
    /**
     * Finds the balance the member owes the store.
     * @param _memberID Member's ID
     * @return Amount of money the member owes or is owed by the store.
     */
    public double findBalance(int _memberID)
    {
        double memberBalance= 0;
        for(int i= 0; i<membersList.size(); i++)
        {
            if(membersList.get(i).getMemberID() == _memberID )
            {
                memberBalance= membersList.get(i).getBalance();
            }
        }
        return memberBalance;
    }
    
    /**
     * Used to find the Total lifetime spending of the member.
     * @param _memberID Member's ID
     * @return The balance of total spending by the member, at the store.
     */
    public double findTotalSpent(int _memberID)
    {
        double totalSpent= 0;
        for(int i= 0; i<membersList.size(); i++)
        {
            if(membersList.get(i).getMemberID() == _memberID )
            {
                totalSpent= membersList.get(i).getTotalSpent();
            }
        }
        return totalSpent;
    }
    
    /**
     * Get the Item price by entering the Item's ID number.
     * @param _itemID Item ID
     * @return itemPrice The price that matches the item ID number.
     */
    public double getItemPrice(int _itemID)
    {
        double itemPrice= 0;
        for(int i= 0; i<inventoryList.size(); i++)
        {
            if(inventoryList.get(i).getItemNum()== _itemID )
            {
                itemPrice= inventoryList.get(i).getPrice();
            }
        }
        return itemPrice;
    }

    /**
     * Finds the item in the inventory list.
     * @param itemNums Item Number
     * @return Inventory item matching the item ID Number
     */
    public Inventory getInventoryItem(int itemNums) {
        return inventoryList.get(itemNums-1);
      }

    /**
     * Discounts a randomly selected Inventory Item's price by 20%
     * @return Discounted Inventory Item's ID Number
     */
    public int dailySaleItem(){
        int _discountedItemID = (int) ((Math.random()*inventoryList.size()));
        inventoryList.get(_discountedItemID).setPrice(inventoryList.get(_discountedItemID).getPrice()-2);
        return _discountedItemID;
    }
    
    /**
     * Displays a message about the daily discounted item.
     * @param _discountedItemID Item ID number of the discounted item
     * @return 
     */
    public String displaySale(int _discountedItemID)
    {
        double originalPrice = inventoryList.get(_discountedItemID).getPrice()+2;
        double discountedPrice = inventoryList.get(_discountedItemID).getPrice();
        //String originalPrice = String.format("%.2f", inventoryList.get(_discountedItemID).getPrice()*1.25);
        //String discountedPrice = String.format("%.2f", inventoryList.get(_discountedItemID).getPrice());
        return "*** ON SALE TODAY ONLY ***\n" + inventoryList.get(_discountedItemID).getTitle() + ", originally priced at $"
                + originalPrice + ", is ON SALE for $2 OFF!!\n" + "Buy today for only $" + discountedPrice;
    }
    
    /**
     * Resets the price of the discounted daily sale item to the original price
     * @param _discountedItemID Item ID number of the discounted item
     */
    public void resetDiscountToOriginalPrice(int _discountedItemID)
    {
        inventoryList.get(_discountedItemID).setPrice(inventoryList.get(_discountedItemID).getPrice()+2);
    }
    
    /**
     * Calculates the Order Total with the Tax
     * @param _totalBill
     * @return Order Total with Tax
     */
    public double calculateTotalWithTax(double _totalBill)
    {
        double totalWithTax = _totalBill*1.05;
        return totalWithTax;
    }

    /**
     * Calculates the new Member Balance when an item is sold by adding the Cost of the Order 
     * to the amount of money in the Member's Balance.
     * @param _orderCost Total Cost of the Order
     * @param _memberID Member's ID Number
     * @return Adjusted Member Balance after the Order is added to the Balance
     */
    public double newBalance(double _orderCost, int _memberID)
    {
        double newBalance= 0;
        for(int i = 0; i< membersList.size(); i++)
        {  
            if(membersList.get(i).getMemberID() == _memberID)
            {
                newBalance= _orderCost + membersList.get(i).getBalance();
                membersList.get(i).setBalance(newBalance);
            }
        }
        return newBalance;
    }

    /**
     * Sets the adjusted Member account Balance and lifetime Total Spent based on payments made.
     * @param _paymentAmount Amount paid (to be deducted from Balance and added to Total Spent)
     * @param _memberID Member ID number
     */
    public void makeAccountPayment(double _paymentAmount, int _memberID)
    {
        for(int i = 0; i< membersList.size(); i++)
        {
            if(membersList.get(i).getMemberID() == _memberID)
            {
                membersList.get(i).setBalance(membersList.get(i).getBalance()-_paymentAmount);
                membersList.get(i).setTotalSpent(membersList.get(i).getTotalSpent()+_paymentAmount);
            }
        }
    }

    /**
     * If a member is Premium Status, then it shows Member ID, Member Name, and New Balance,
     * used to confirm Premium Fees have been added to the Member's account.
     * @return Member ID, Member Name,and Adjusted Balance
     */
    public String confirmPremiumFees()
    {
        String premiumUpdate= "";
        for(int i = 0; i< membersList.size(); i++)
        {
            if(membersList.get(i).isMemberPremium() == true)
            {
                System.out.println("Member ID >>: " + membersList.get(i).getMemberID() + ", Member Name: " +
                        membersList.get(i).getName() + ", Premium Membership Owed: "+ membersList.get(i).isOwingPremiumFee()+ ", New Balance: $"+ membersList.get(i).getBalance());
            }
        }
        return premiumUpdate;
    }
    
    /**
     * Adds a monthly premium membership fee of $5, if members are premium.
     * Sets all of the Owed Premium Membership Fees to true.
     */
    public void addMonthlyFee()
    {
        for(int i = 0; i< membersList.size(); i++)
        {
            if(membersList.get(i).isMemberPremium()== true)
            {
                membersList.get(i).setBalance(membersList.get(i).getBalance()+ monthlyFee);
                membersList.get(i).setOwedPremiumFee(true);
            }
        }
    }

    /**
     * Determines if the provided member owes their Premium Membership fee.
     * @param _memberID Member ID Number
     * @return True if the member owes Premium Membership Fees, False if the member
     * does not owe Premium Membership Fees
     */
    public boolean owePremium(int _memberID)
    {
        boolean owingPremium = false;
          for(int i = 0; i< membersList.size(); i++)
          {
              if (membersList.get(i).getMemberID() == _memberID)
              {
                owingPremium= membersList.get(i).isOwingPremiumFee();
              }
          }
          return owingPremium;
    }

    /**
     * Change the Owing Premium Membership Fee status of an individual member. Used when a membership fee is paid.
     * @param _memberID Member ID
     * @param _newOwedStatus New Status of Owing Premium Fee (False or True)
     */
    public void changeOwedPremiumStatus(int _memberID, boolean _newOwedStatus)
    {
         for(int i = 0; i< membersList.size(); i++)
          {
              if (membersList.get(i).getMemberID() == _memberID)
              {
                  membersList.get(i).setOwedPremiumFee(_newOwedStatus);
              }
          }
    }

    /**
     * Given a product ID and a product quantity, stock is updated
     * by adding an amount to existing product quantity
     * @param productID
     * @param amount
     * @return 
     */
    @Override
    public int restockProduct(int productID, int amount) {
        int newAmount = 0;
        for(int i = 0; i < inventoryList.size(); i++)
        {
            if(inventoryList.get(i).getItemNum() == productID)
            {
                newAmount = inventoryList.get(i).getAmount() + amount;
                inventoryList.get(i).setAmount(newAmount);
            }
        }
        return newAmount;
    }

    /**
     * Calculates and returns dollar amount for current inventory of products in stock
     * @return 
     */    
    @Override
    public double inventoryValue() {
        double individualItemValue = 0;
        double totalInventoryValue = 0;
        for (Inventory item: inventoryList)
        {
            individualItemValue = item.getAmount() * item.getPrice();
            totalInventoryValue += individualItemValue;
        }
        return totalInventoryValue;
    }
}

