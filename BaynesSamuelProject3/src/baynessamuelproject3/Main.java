/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package baynessamuelproject3;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This project is a bookstore management system for keeping track of inventory and members.
 * ITSC 1213-081
 * @author Samuel Baynes 
 * @since 8/1/2022
 */
public class Main {

    /**
     * Project 3
     * Main class for running store operations.
     * @param args the command line arguments
     * @author Samuel Baynes
     */
    public static void main(String[] args) {
        //
        Bookstore store = new Bookstore();
        ArrayList<Double> totalSales = new ArrayList<>();
        ArrayList<Double> totalPaymentsOnAccount = new ArrayList<>();

        try{
        String decorativeLine = "\n$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$\n";
        String companyName = "Sam's Books and Such";
        
        //Welcome statement
        System.out.println(decorativeLine);
        System.out.println("Welcome to " + companyName + "!!\n");
        
        //select random item for daily discount
        int discountedID = store.dailySaleItem();
        
        //Beginning of the functionality and customer options.
        // while loop makes it so the user may continue using the program until ready to exit.
        int exit = 0;
        while (exit == 0)
        {
            Scanner console = new Scanner(System.in);
            try{
                System.out.println("Please enter the number of the task you wish to perform:");  
                System.out.println("\t 1. View or Compare inventory items.");
                System.out.println("\t 2. Administrative Duties.");
                System.out.println("\t 3. Save Daily Report and Updated Inventory Files");
                System.out.println("\t 4. Exit Program");
                //int num = console.nextInt();
                switch (console.nextInt()) {
                            //Sort and view items by different parameters and compare prices 
                    case 1: System.out.println("\nBefore you begin, check out the Daily Sale");
                            System.out.println(store.displaySale(discountedID));
                            System.out.println("\nPlease enter the number of the option you would like to View or Perform: ");
                            System.out.println("\t 1. DVD's");
                            System.out.println("\t 2. CD's");
                            System.out.println("\t 3. Books");
                            System.out.println("\t 4. View All Items- Sorted by ID Number");
                            System.out.println("\t 5. View All Items- Sorted by Price (Lowest to Highest)");
                            System.out.println("\t 6. Compare Prices of Two Items");
                            try{
                            int input = console.nextInt();
                            switch (input) {
                                case 1: //sort and view items by DVD
                                    System.out.println("\t*** DVD's For Sale ***\n");
                                    for (Inventory dvd : store.getInventoryList()) 
                                    {
                                        if(dvd instanceof DVD && store.getInventoryList().get(discountedID).getItemNum() == dvd.getItemNum())
                                        {
                                            System.out.println("***" + store.getInventoryList().get(discountedID).getTitle() + " is on Sale today for $2.00 OFF (Discount is reflected in listed price)***");
                                            System.out.println("  " + dvd);
                                        }
                                        else if(dvd instanceof DVD){
                                            System.out.println("  " + dvd);
                                        }
                                    }
                                    System.out.println("\nHopefully you found items to purchase. If so, please remember or write down the item(s) ID number(s).");
                                    System.out.println("ID Numbers are needed to make purchases.\n");
                                    break;
                                case 2: //sort and view items by CD
                                    System.out.println("\t*** CD's For Sale ***\n");
                                    for (Inventory cd : store.getInventoryList()) 
                                    {
                                        if(cd instanceof CD && store.getInventoryList().get(discountedID).getItemNum() == cd.getItemNum())
                                        {
                                            System.out.println("***" + store.getInventoryList().get(discountedID).getTitle() + " is on Sale today for $2.00 OFF (Discount is reflected in listed price)***");
                                            System.out.println("  " + cd);
                                        }
                                        else if(cd instanceof CD)
                                        {
                                            System.out.println("  " + cd);
                                        }
                                    }
                                    System.out.println("\nHopefully you found items to purchase. If so, please remember or write down the item(s) ID number(s).");
                                    System.out.println("ID Numbers are needed to make purchases.\n");
                                    break;
                                case 3: //sort and view items by Books
                                    System.out.println("\t*** Book's For Sale ***\n");
                                    for (Inventory book : store.getInventoryList()) 
                                    {
                                        if(book instanceof Book && store.getInventoryList().get(discountedID).getItemNum() == book.getItemNum())
                                        {
                                            System.out.println("***" + store.getInventoryList().get(discountedID).getTitle() + " is on Sale today for $2.00 OFF (Discount is reflected in listed price)***");
                                            System.out.println("  " + book);
                                        }
                                        else if(book instanceof Book)
                                        {
                                            System.out.println("  " + book);
                                        }
                                    }
                                    System.out.println("\nHopefully you found items to purchase. If so, please remember or write down the item(s) ID number(s).");
                                    System.out.println("ID Numbers are needed to make purchases.\n");
                                    break;
                                case 4: //sort and view all items by ID Number. Discounted item is designated in print statement.
                                    System.out.println("*** All Products for Sale- Sorted by ID Number ***\n");
                                    for (Inventory allItems : store.getInventoryList()) 
                                    {
                                        if (store.getInventoryList().get(discountedID).getItemNum() == allItems.getItemNum())
                                        {
                                            System.out.println("***" + store.getInventoryList().get(discountedID).getTitle() + " is on Sale today for $2.00 OFF (Discount is reflected in listed price)***");
                                            System.out.println("  " + allItems);
                                        }
                                        else{
                                            System.out.println("  " + allItems);
                                        }
                                    }
                                    System.out.println("\nHopefully you found items to purchase. If so, please remember or write down the item(s) ID number(s).");
                                    System.out.println("ID Numbers are needed to make purchases.\n");
                                    break;
                                case 5: //sort and view all items by prices in ascending order. Discounted item is designated in print statement.
                                    System.out.println("*** All Products for Sale- Sorted by Price (Lowest to Highest) ***\n");
                                    Collections.sort(store.getInventoryList());
                                    for (Inventory allItems : store.getInventoryList()) 
                                    {
                                        if (store.getInventoryList().get(discountedID).getItemNum() == allItems.getItemNum())
                                        {
                                            System.out.println("***" + store.getInventoryList().get(discountedID).getTitle() + " is on Sale today for $2.00 OFF (Discount is reflected in listed price)***");
                                            System.out.println("  " + allItems);
                                        }
                                        else{
                                            System.out.println("  " + allItems);
                                        }
                                    }
                                    System.out.println("\nHopefully you found items to purchase. If so, please remember or write down the item(s) ID number(s).");
                                    System.out.println("ID Numbers are needed to make purchases.\n");
                                    break;
                                case 6: //compare prices of two items users select
                                    System.out.println("In order to compare prices of two items, you must have the two items' ID Numbers.");
                                    System.out.println("If you do not have the ID Numbers with you, please enter 0 to exit");
                                    System.out.println("and consult the \"See what's for sale.\" option found on the previous page.");
                                    System.out.println("\nOtherwise, please enter the item ID Number of the first item you wish to compare:");
                                    int input7 = console.nextInt();
                                    if (input7 == 0)
                                    {
                                        break;
                                    }
                                    System.out.println("\nPlease enter the item ID Number of the second item.");
                                    int input8 = console.nextInt();
                                    int comparePrices = store.getInventoryItem(input7).compareTo(store.getInventoryItem(input8));
                                    if (comparePrices == 1)
                                    {
                                        System.out.println("\nThe first item you entered: " + store.getInventoryItem(input7).display());
                                        System.out.println("Costs more than the second item: " + store.getInventoryItem(input8).display());
                                    }
                                    else if (comparePrices == -1)
                                    {
                                        System.out.println("\nThe first item you entered: " + store.getInventoryItem(input7).display());
                                        System.out.println("Costs less than the second item: " + store.getInventoryItem(input8).display());
                                    }
                                    else{
                                        System.out.println("\nThe first item you entered: " + store.getInventoryItem(input7).display());
                                        System.out.println("Costs the same as the second item: " + store.getInventoryItem(input8).display());
                                    }
                                    break;
                                default: //print statement for if a number not provided (1-6) is entered
                                    System.out.println("The option you entered does not exist. Please try again.");
                                    break;
                            }
                            } catch(InputMismatchException e){
                                System.out.println("INVALID RESPONSE.  You have been returned to the main menu. Please use numbers, not letters, when prompted.");
                            }    
                            break;
                                        

                            // Administrative Duties
                    case 2: //Note: I printed the password only for testing purposes.
                            try{
                                int password = 1234;  //Use this simple password to gain access to this case
                                System.out.println("Please enter the Administrative Password to proceed: (it's 1234 for testing purposes)");
                                int attempt = console.nextInt();
                                if(attempt != password)
                                {
                                    System.out.println("Wrong Password. ACCESS DENIED!!");
                                    break;
                                }
                            } catch(InputMismatchException e){
                                System.out.println("Wrong Password. ACCESS DENNIED!!");
                                break;
                            }    
                            System.out.println("Enter the number of the option of the following task you wish to complete:");
                            System.out.println("\t 1. Register New Member.");
                            System.out.println("\t 2. Make a sale.");
                            System.out.println("\t 3. Pay a Member account balance.");
                            System.out.println("\t 4. Add New Item to Inventory (CDs, DVDs, Books).");
                            System.out.println("\t 5. Remove Item from Inventory");
                            System.out.println("\t 6. Add Monthly $5.00 Premium Membership Fee to Premium Member's Balance.");
                            System.out.println("\t 7. Re-Stock or Add an amount of items to existing inventory list.");
                            System.out.println("\t 8. See the dollar amount of current inventory.");
                            try{
                                int input3 = console.nextInt();
                                switch (input3) {

                                    case 1: // register new member
                                        Scanner memberScan = new Scanner(System.in);
                                        System.out.println("Please enter the following metrics pertaining to the new member.");
                                        System.out.println("MEMBER NAME: ");
                                        String _name = memberScan.nextLine();
                                        System.out.println("MEMBER E-MAIL: ");
                                        String _email = memberScan.nextLine();
                                        System.out.println("Premium Members receive a monthly newsletter and alerts for local events.");
                                        System.out.println("Would the new member like to become a premium member for $5.00 a month? Yes/No");
                                        int yesNo = 0;
                                        boolean _premiumStatus = false;
                                        boolean _owePremiumFee = false;
                                        double _balance= 0;
                                        while(yesNo != 1){ //Loop Yes or No option to ensure correct response
                                            String response = memberScan.nextLine();
                                            if (response.equalsIgnoreCase("Yes")) {
                                                _premiumStatus = true;
                                                _balance= 5.00;
                                                _owePremiumFee = true;
                                                yesNo = 1;
                                            }
                                            else if(response.equalsIgnoreCase("No"))
                                            {
                                                _premiumStatus = false;
                                                _balance = 0;
                                                _owePremiumFee = false;
                                                yesNo = 1;
                                            }
                                            else{
                                                System.out.println("Your answer is not recognized. Please enter Yes or No.");
                                        }}
                                        System.out.println("Does the new member prefer to make Cash or Card payments? (Please enter the corresponding number of your preference)");
                                        System.out.println("\t1. Cash");
                                        System.out.println("\t2. Card");
                                        String _paymentMethod = "";
                                        int loopPaymentPref = 0;
                                        while(loopPaymentPref != 1 ){ //Loop Cash/Card preference to ensure correct input
                                            try{
                                                int cashCard = memberScan.nextInt();
                                                if (cashCard == 1)
                                                {
                                                    _paymentMethod = "Cash";
                                                    loopPaymentPref = 1;
                                                }
                                                else if (cashCard == 2)
                                                {
                                                    _paymentMethod = "Card";
                                                    loopPaymentPref = 1;
                                                }
                                                else{
                                                    System.out.println("Your response is not recognized. Please enter \'1' for Cash or \'2' for Credit.");
                                                }
                                            } catch (InputMismatchException e){
                                                System.out.println("Your response is not recognized. Please enter \'1' for Cash or \'2' for Credit.");
                                                memberScan.nextLine();
                                        }}
                                        double _totalSpent = 0;
                                        int newMem= store.addMember(_name, _email, 0, _premiumStatus, _owePremiumFee, _paymentMethod, _balance, _totalSpent);
                                        System.out.println("Thanks, you are now in our system.  Your member ID number is ");
                                        System.out.println(newMem);
                                        System.out.println("You now appear in our system as: ");
                                        System.out.println(store.displayMember(newMem) + "\n");
                                        break;

                                    case 2: // make a sale option
                                        //List items for sale
                                        System.out.println("\n*** The following items are currently for sale (Sorted by ID Number) ***\n");
                                        for (Inventory allItems : store.getInventoryList()) 
                                                {
                                                    if (store.getInventoryList().get(discountedID).getItemNum() == allItems.getItemNum())
                                                    {
                                                        System.out.println("***" + store.getInventoryList().get(discountedID).getTitle() + " is on Sale today for $2.00 OFF (Discount is reflected in listed price)***");
                                                        System.out.println("  " + allItems);
                                                    }
                                                    else{
                                                        System.out.println("  " + allItems);
                                                    }
                                                }
                                        System.out.println("*** The items listed above are available for purchase. You will need the ID Number of the items you wish to purchase. ***\n");

                                        //Collect number of items and items, calculate totalBill
                                        
                                        System.out.println("\nHow many items would you like to purchase?");
                                        try{
                                            int numberOfItems = console.nextInt();
                                            Inventory[] orderedItemsList = new Inventory[numberOfItems];
                                            double totalBill= 0;
                                            for(int itemNumberCounter = 0; itemNumberCounter < orderedItemsList.length ; itemNumberCounter++ )
                                            {
                                                if(numberOfItems == 0)
                                                {
                                                    break;
                                                }
                                                else if(numberOfItems > 0)
                                                {
                                                System.out.println("What item ID Number would you like for your item number " + (itemNumberCounter + 1) + "?");
                                                int itemNums = console.nextInt();
                                                store.decrementItemAmount(itemNums);
                                                orderedItemsList[itemNumberCounter]= store.getInventoryItem(itemNums);
                                                double price = store.getItemPrice(itemNums);
                                                totalBill = totalBill +price;
                                                }
                                            }   
                                            System.out.println("\nI have your order down as: ");
                                            for (Inventory item : orderedItemsList) 
                                            {
                                                store.getProductsSold().add(item);
                                                System.out.println("  " + item.display());
                                            }
                                            String orderTotal = String.format("%.2f",totalBill);
                                            System.out.println("\n___________________ ITEM AMOUNT : $" + orderTotal);
                                            String orderWithTax = String.format("%.2f",store.calculateTotalWithTax(totalBill));
                                            System.out.println("___________________ TOTAL after Tax: $" +  orderWithTax);

                                            //Look up member information
                                            System.out.println("\nLets get you checked out.  What is your Member ID Number?");
                                            int memberInfo1 = console.nextInt();
                                            if(memberInfo1 > store.getMembersList().size() || memberInfo1 < 1)
                                            {
                                                System.out.println("The Member ID number you entered does not exist. Please try again.");
                                                break;
                                            }
                                            System.out.println("\nYour account appears in our system as follows: ");
                                            System.out.println(store.displayMember(memberInfo1));
                                            double balanceWithPremiumFee = store.newBalance(store.calculateTotalWithTax(totalBill), memberInfo1);
                                            String newBalanceFormatted = String.format("%.2f", balanceWithPremiumFee);
                                            if(store.owePremium(memberInfo1))
                                                {   
                                                    System.out.println("\nA Premium Membership Fee of $5.00 still exists on this account. This fee is already reflected in the member Balance.");
                                                    System.out.println("\n________________________________Remaining Balance (Prior Balance + Current Order Total) : $" + newBalanceFormatted);
                                                }
                                            else
                                                {
                                                    System.out.println("\nNo Membership Fees exist at this time.");
                                                    System.out.println("________________________Order Total : $" + newBalanceFormatted);
                                                }

                                            //Collect Payment
                                            System.out.println("Please enter your payment amount.");
                                            System.out.print("$");
                                            double payment1 = console.nextDouble();
                                            store.makeAccountPayment(payment1, memberInfo1);
                                            store.findBalance(memberInfo1);
                                            totalSales.add(payment1);
                                            String remainingBalance = String.format("%.2f", store.findBalance(memberInfo1));
                                            if(store.findBalance(memberInfo1) > 0)
                                            {
                                                System.out.println("\nThank you for the payment. You now have an outstanding balance of $" + remainingBalance);
                                                System.out.println("You will be billed this outstanding balance.  Please make arrangments to pay immediately, or you will be charged interest.");
                                            }
                                            else
                                            {
                                                System.out.println("\nThank you for your payment. You have no remaining balance.");
                                                store.changeOwedPremiumStatus(memberInfo1, false);
                                            }
                                            String totalSpent = String.format("%.2f", store.findTotalSpent(memberInfo1));
                                            System.out.println("You have now spent $" + totalSpent + " at " + companyName + ".  We really value your loyalty!!");

                                            System.out.println("\nYour updated account appears as: ");
                                            System.out.println(store.displayMember(memberInfo1));
                                        } catch (InputMismatchException e){
                                            System.out.println("INVALID INPUT. You have been returned to the Main Menu. Please use numbers, not letters, when prompted making a purchase/sale.");
                                            break;
                                        } catch (IndexOutOfBoundsException e){
                                            System.out.println("INVALID INPUT. The ID Number you provided is not in our records.  Please check your information and try again.");
                                            break;
                                        }
                                        break;
                                        

                                    case 3: // look up customer balance and make a payment
                                        try{
                                            System.out.println("Please enter your Member ID number so we can look your information up.");
                                            int memberInfo = console.nextInt();
                                            if(memberInfo > store.getMembersList().size() || memberInfo < 1)
                                            {
                                                System.out.println("The Member ID number you entered does not exist. Please try again.");
                                                break;
                                            }
                                            System.out.println("The following information reflects your account: ");
                                            System.out.println(store.displayMember(memberInfo));
                                            double balance = store.findBalance(memberInfo);
                                            String formattedBalance = String.format("%.2f", balance);
                                            store.findTotalSpent(memberInfo);
                                            if(balance > 0)
                                            {
                                                System.out.println("\nYou have an outstanding balance of $" + formattedBalance);
                                                System.out.println("How much of your balance would you like to pay?");
                                                System.out.print("$");
                                                double payment = console.nextDouble();
                                                store.makeAccountPayment(payment, memberInfo);
                                                totalPaymentsOnAccount.add(payment);
                                                double updatedBalance= store.findBalance(memberInfo);
                                                String formattedUpdatedBalance = String.format("%.2f", updatedBalance);
                                                System.out.println("Thank you for your payment. Your remaining balance is $" + formattedUpdatedBalance);
                                                double lifetimeSpending = store.findTotalSpent(memberInfo);
                                                String formattedLifetimeSpending = String.format("%.2f", lifetimeSpending);
                                                System.out.println("You have now spent $" + formattedLifetimeSpending + " at " + companyName + ". We value your loyalty!\n");
                                            }
                                            else
                                            {
                                                System.out.println("You have no remaining balance.");
                                                store.changeOwedPremiumStatus(memberInfo, false);
                                            }
                                        } catch (InputMismatchException e){
                                                System.out.println("INVALID INPUT. You have been returned to the Main Menu. Please use numbers (not letters) when prompted."
                                                + " No payment was registered.");
                                        }
                                        break;

                                    case 4: // add inventory (CDs, DVDs, Books)
                                        System.out.println("Enter the number corresponding to the type of item you would like to add: ");
                                        System.out.println("\t1. CD");
                                        System.out.println("\t2. DVD");
                                        System.out.println("\t3. Book");
                                        try{
                                            int input5 = console.nextInt();
                                            Scanner scnr = new Scanner(System.in);
                                            switch (input5){
                                                case 1: //create CD by taking user input and add new CD to Inventory
                                                    System.out.println("Please enter the following metrics to create a new CD to the inventory.");
                                                    System.out.println("CD Title:");
                                                    String _cdTitle = scnr.nextLine();
                                                    System.out.println("Band Name:");
                                                    String _band = scnr.nextLine();
                                                    System.out.println("Price:");
                                                    System.out.print("$ ");
                                                    double _cdPrice = console.nextDouble();
                                                    System.out.println("Amount added to inventory:");
                                                    int _cdAmount = console.nextInt();
                                                    System.out.println("Year released:");
                                                    int _cdYearReleased = console.nextInt();
                                                    System.out.println("Peak ranking on the US charts:");
                                                    int _chartRanking = console.nextInt();
                                                    int newCdNum = store.addCD(_cdTitle, _band, _cdPrice, _cdAmount, _cdYearReleased, 0, _chartRanking);
                                                    System.out.println("The new item has been successfully added to the inventory. The item appears in the system as: \n");
                                                    System.out.println(store.getInventoryItem(newCdNum));
                                                    break;

                                                case 2: ////create DVD by taking user input and add new DVD to Inventory                                           
                                                    System.out.println("Please enter the following metrics to create a new DVD to the inventory.");
                                                    System.out.println("DVD Title:");
                                                    String _dvdTitle = scnr.nextLine();
                                                    System.out.println("Directed by:");
                                                    String _director = scnr.nextLine();
                                                    System.out.println("Movie rating:");
                                                    String _rating = scnr.nextLine();
                                                    System.out.println("Price:");
                                                    System.out.print("$ ");
                                                    double _dvdPrice = console.nextDouble();
                                                    System.out.println("Amount added to inventory:");
                                                    int _dvdAmount = console.nextInt();
                                                    System.out.println("Year released:");
                                                    int _dvdYearReleased = scnr.nextInt();
                                                    int newDVDNum = store.addDVD(_dvdTitle, _director, _dvdPrice, _dvdAmount, _dvdYearReleased, 0, _rating);
                                                    System.out.println("The new item has been successfully added to the inventory. The item appears in the system as: \n");
                                                    System.out.println(store.getInventoryItem(newDVDNum));
                                                    break;

                                                case 3: //create Book by taking user input and add new Book to Inventory                                         
                                                    System.out.println("Please enter the following metrics to create a new book to the inventory.");
                                                    System.out.println("Book Title:");
                                                    String _bookTitle = scnr.nextLine();
                                                    console.nextLine();
                                                    System.out.println("Author:");
                                                    String _author = scnr.nextLine();
                                                    System.out.println("Price:");
                                                    System.out.print("$ ");
                                                    double _bookPrice = console.nextDouble();
                                                    System.out.println("Amount added to inventory:");
                                                    int _bookAmount = console.nextInt();
                                                    System.out.println("Year released:");
                                                    int _bookYearReleased = console.nextInt();
                                                    System.out.println("Is the book a New York Times Best Seller? (Yes/No)");
                                                    String input6 = scnr.nextLine();
                                                    boolean _bestSeller= false;
                                                    if(input6.equalsIgnoreCase("Yes"))
                                                    {
                                                        _bestSeller = true;
                                                    }
                                                    int newBookNum = store.addBook(_bookTitle, _author, _bookPrice, _bookAmount, _bookYearReleased, 0, _bestSeller);
                                                    System.out.println("The new item has been successfully added to the inventory. The item appears in the system as: \n");
                                                    System.out.println(store.getInventoryItem(newBookNum));
                                                    break;

                                                default: //default option
                                                    System.out.println("The option you entered does not exist. Please try again.");
                                                    break; 
                                            } 
                                        } catch (InputMismatchException e){
                                                System.out.println("INVALID INPUT. You have been returned to the Main Menu. Please use numbers (not letters) when prompted."
                                                        + " No item was added to the inventory.");
                                        } 
                                        break;
                                        

                                    case 5: //remove items from the inventory
                                        try{
                                            System.out.println("The following items are currently in the system: \n");
                                            for (Inventory allItems : store.getInventoryList()) 
                                            {
                                                System.out.println("  " + allItems.display());
                                            }
                                            System.out.println("\n*** The items above appear in the system ***");
                                            System.out.println("Enter the ID Number of the item you would like to remove from inventory:");
                                            int input8 = console.nextInt();
                                            System.out.println("You have selected to remove the following item:\n");
                                            System.out.println(store.getInventoryItem(input8));
                                            System.out.println("Are you sure you want to delete this item?");
                                            System.out.println("\tEnter 1 to delete the item.");
                                            System.out.println("\tEnter 0 if you do not want to remove the item and wish to exit.");
                                            int input9 = console.nextInt();
                                            if(input9 == 1)
                                            {
                                                System.out.println("\nThe following item was deleted from the system:");
                                                System.out.println(store.getInventoryItem(input8).display());
                                                store.removeInventory(input8);
                                                System.out.println("\n*** Updated Inventory List: ***");
                                                for (Inventory allItems : store.getInventoryList()) 
                                                    {
                                                        System.out.println("  " + allItems.display());
                                                    }
                                                System.out.println("\nNote: ID Numbers for remaining items will adjust accordingly.");
                                            }
                                            else if(input9 == 0)
                                            {
                                                System.out.println("\nNo update occured.");
                                            }
                                            else{
                                                System.out.println("\nYour response was not recognized.");
                                                System.out.println("No update occured.");
                                            }
                                        } catch (InputMismatchException e){
                                            System.out.println("INVALID INPUT. You have been returned to the Main Menu. Please use numbers (not letters) when prompted."
                                            + " No item was removed from the inventory.");
                                        } catch (IndexOutOfBoundsException e){
                                            System.out.println("INVALID INPUT. The ID Number you provided is not in our records.  Please check your information and try again.");
                                            break;
                                        }
                                        break;

                                    case 6: //add $5 to Premium Members' balance
                                        try{
                                            System.out.println("Please Enter 0 to confirm and add $5.00 to each Premium Member's Balance");
                                            System.out.println("*** You may enter any other command to exit the program ***");
                                            int input4 = console.nextInt();
                                            if(input4 == 0)
                                            {
                                                store.addMonthlyFee();
                                                System.out.println("The monthly %5.00 Premium Membership fee has been added.");
                                                System.out.println("The updated Premium Member accounts are as follows: ");
                                                System.out.println(store.confirmPremiumFees());
                                            }
                                            System.out.println("Function was exited successfully. No balance was added to the Premium Members' Balances.");
                                        } catch (InputMismatchException e){
                                            System.out.println("Function was exited successfully. No balance was added to the Premium Members' Balances.");
                                        }
                                        break;

                                    case 7: //restock or add items to the current list of items in inventory
                                        try{
                                            System.out.println("The following items are currently in the system: \n");
                                            for (Inventory allItems : store.getInventoryList()) 
                                            {
                                                System.out.println("  " + allItems);
                                            }
                                            System.out.println("*** The items above reflect current items in our system. ***\n");
                                            System.out.println("Please enter the item's ID Number you would like to re-stock: ");
                                            int restockID = console.nextInt();
                                            System.out.println("The item you selected appears in our system as: \n");
                                            System.out.println(store.getInventoryItem(restockID));
                                            System.out.println("How many items would you like to add to the inventory?");
                                            int restockAmount = console.nextInt();
                                            store.restockProduct(restockID, restockAmount);
                                            System.out.println(">>>Inventory was successfully updated.  The item now appears in our system as:\n");
                                            System.out.println(store.getInventoryItem(restockID));
                                        }catch (InputMismatchException e){
                                            System.out.println("INVALID INPUT. You have been returned to the Main Menu. Please use numbers (not letters) when prompted."
                                            + " No items were restocked.");
                                        } catch (IndexOutOfBoundsException e){
                                            System.out.println("INVALID INPUT. The ID Number you provided is not in our records.  Please check your information and try again.");
                                            break;
                                        }
                                        break;

                                    case 8: //calculate and print the total value of inventory
                                        double inventoryPrice = store.inventoryValue();
                                        String formattedInventoryPrice = String.format("%.2f",inventoryPrice);
                                        System.out.println("The current total inventory value is: $" + formattedInventoryPrice);
                                        break;

                                    default:
                                        System.out.println("The option you entered does not exist. Please try again.");
                                        break; 

                           } } catch(InputMismatchException e){
                                System.out.println("INVALID RESPONSE.  You have been returned to the main menu. Please use numbers, not letters, when prompted.");
                            }  
                            break;

                    case 3: // Generate and save Updated Inventory csv file and Daily Report txt file
                            store.resetDiscountToOriginalPrice(discountedID); //Reset daily discounted item's price to original price
                            //Create and Write Update Inventory CSV
                            String updatedInventoryFilePath = "BookInventoryDay2.csv";
                            try{
                                FileWriter fw = new FileWriter(updatedInventoryFilePath);
                                BufferedWriter bw = new BufferedWriter(fw);
                                PrintWriter pw = new PrintWriter(bw);

                                pw.println("productID,type,title,author/artist/director,numInStock,price,yearReleased,nyBestSeller,rating,chartRanking");
                                for(Inventory i: store.getInventoryList())
                                {
                                    if(i instanceof CD)
                                    {
                                        pw.println(i.getItemNum()+ ",cd," + i.getTitle() + "," + ((CD) i).getBand()+ "," + i.getAmount()
                                        + "," + i.getPrice() + "," + i.getYearReleased() + ",n/a,n/a" + ((CD) i).getChartRanking());
                                    }
                                    else if(i instanceof DVD)
                                    {
                                        pw.println(i.getItemNum()+ ",dvd," + i.getTitle() + "," + ((DVD) i).getDirector()+ "," + i.getAmount()
                                        + "," + i.getPrice() + "," + i.getYearReleased() + ",n/a," + ((DVD) i).getRating() + ",n/a");
                                    }
                                    else if(i instanceof Book)
                                    {
                                        pw.println(i.getItemNum() + ",book," + i.getTitle() + "," + ((Book) i).getAuthor() + "," + i.getAmount()
                                        + "," + i.getPrice() + "," + i.getYearReleased() + "," +((Book) i).isBestSeller() + ",n/a,n/a");
                                    }
                                }
                                pw.flush();
                                pw.close();
                            //Create and Write Daily Report
                            File dailyReport = new File("DailyReport.txt");
                            dailyReport.createNewFile();
                            FileWriter outFW = new FileWriter(dailyReport);
                            PrintWriter outDR = new PrintWriter(outFW);
                                outDR.println("**** DAILY REPORT ****\n");
                                double totalS = 0;
                                for(Double sales: totalSales)
                                {
                                    totalS += sales;
                                }
                                double totalP = 0;
                                for(Double payments: totalPaymentsOnAccount)
                                {
                                    totalP += payments;
                                }
                                outDR.println("Total Sales:  $" + totalS); //total amount from sales
                                outDR.println("\nTotal Revenue:  $" + (totalP + totalS)); //total amount from sales and payments on account
                                outDR.println("\nNumber of Products Sold: " + store.getProductsSold().size()); //print products sold
                                if (store.getProductsSold().isEmpty())
                                {
                                    outDR.println( "\nProducts Sold: NONE");
                                }
                                else{
                                    outDR.println("\nProducts Sold: ");
                                    int count = 1;
                                    for (Inventory purchasedItems : store.getProductsSold()) 
                                    {
                                        outDR.println("ITEM# "+ count++ + " >> " + purchasedItems.display());
                                    }
                                }
                                outDR.println("\nNumber of New Members: " + store.getNewMembersList().size()); //print new members 
                                if (store.getNewMembersList().isEmpty())
                                {
                                    outDR.print("\nNew Members: NONE");
                                }
                                else{
                                    outDR.println("\nNew Members: ");
                                    for(Members newMembers: store.getNewMembersList())
                                    {
                                        outDR.println(store.displayMember(newMembers.getMemberID()));
                                    }
                                }
                                store.getNewMembersList().clear(); //clear the new members list for the next day's report
                                //Print Daily Sale Item information
                                outDR.println("\nDaily Discounted Item: " + store.getInventoryList().get(discountedID).display());
                                int count= 0;
                                for(int i = 0; i < store.getProductsSold().size(); i++)
                                    {
                                        if(store.getProductsSold().get(i).getItemNum() == store.getInventoryList().get(discountedID).getItemNum()){
                                            count++;
                                        }
                                    }       
                                outDR.println("\nNumber of Daily Discounted Items Sold: " + count);
                                outDR.flush();
                                outDR.close();
                            } catch (FileNotFoundException e){
                                System.out.println("Caught FileNotFoundException for outputData.txt. Try again making sure the file name and path are correct.");
                            } catch (IOException e){
                                System.out.println("Caught IOException when closing output stream. Try again.");
                            }
                            System.out.println("Updated Inventory List and Daily Report were successfully generated and saved.");
                            System.out.println("The Updated Inventory List was saved as : BookInventoryDay2.csv");
                            System.out.println("The Daily Report was saved as: DailyReport.txt");
                            System.out.println("Discounted Item's price has been returned to the original price. A new item will be selected for dicount"
                                    + " when the program is re-started.");
                            System.out.println("\n");
                            break;

                    case 4: // Exit program by closing while loop
                        exit = 1;
                        console.close();
                        System.out.println("Sam's Books and Such Bookstore system has been closed.\n");
                        break;

                    default:
                        System.out.println("The option you entered does not exist. Please try again.");
                        break;
                }
            } catch(InputMismatchException e){
                System.out.println("INVALID RESPONSE.  Please enter the NUMBER corresponding to the function you wish to complete.");
            }    
        }
        System.out.println(decorativeLine); //print decorative ending line  
        }catch (IndexOutOfBoundsException e){
            System.out.println(e + ". Error occured, likely due to no file found. Please check path. "
                    + "\nInaccurate ID Numbers also often cause this error.");
        }catch (Exception e){
            System.out.println(e + ". An unexpected Error Occurred. Please check your input for inaccuracies."
                    + "\nContact program administor if problem persists.");
        }
    }    //end main method
} //end main class
