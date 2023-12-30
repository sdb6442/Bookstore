/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baynessamuelproject3;

/**
 * Membership Information, including information for regular and premium members
 * Project 3
 * @author Samuel Baynes
 */
public class Members {
    
    private String name;
    private String email;
    private int memberID;
    private boolean premiumStatus = false;
    private boolean owePremiumFee = false;
    private String paymentMethod;
    private double balance;
    private double totalSpent;
    
    /**
     * Constructor- Membership constructor
     * @param _name Member name
     * @param _email Member email address
     * @param _memberID Member ID number
     * @param _premiumStatus Status of Premium Membership
     * @param _owePremiumFee Status of whether or not a Premium Membership Fee is owed
     * @param _paymentMethod Preferred Payment Method
     * @param _balance Member's balance owed to the store
     * @param _totalSpent Member's life time spending at the bookstore
     */
    public Members(String _name, String _email, int _memberID, boolean _premiumStatus, boolean _owePremiumFee, String _paymentMethod, double _balance,
            double _totalSpent)
    {
        name = _name;
        email = _email;
        memberID = _memberID;
        premiumStatus = _premiumStatus;
        owePremiumFee= _owePremiumFee;
        paymentMethod = _paymentMethod;
        balance= _balance;
        totalSpent= _totalSpent;
    }
    
    /**
     * Get the member name.
     * @return Name
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Set the member's name.
     * @param _name Customer name
     */
    public void setName(String _name)
    {
        name = _name;
    }
    
    /**
     * Get the member's email.
     * @return email Member's email
     */
    public String getEmail()
    {
        return email;
    }
    
    /**
     * Allows the email address to be set.
     * @param _email User's email address.
     */
    public void setEmail(String _email)
    {
        email = _email;
    }
    
    /**
     * Get the member's Member ID.
     * @return memberID The member's unique ID number.
     */
    public int getMemberID()
    {
        return memberID;
    }
    
    /**
     * Allows the member ID to be set.
     * @param _memberID Member's unique ID number.
     */
    public void setMemberID(int _memberID)
    {
        memberID = _memberID;
    }
    
    /**
     * Shows whether or not the member has premium status.
     * @return premiumStatus The status of the member's membership (regular or premium)
     */
    public boolean isMemberPremium()
    {
        return premiumStatus;
    }
    
    
    /** Allows the premium membership to be set to true or false.
     * @param _premiumStatus The status of the member's membership.
     */
    public void setPremiumStatus(boolean _premiumStatus)
    {
        premiumStatus = _premiumStatus;
    }
    
    /**
     * Indicates whether the member currently owes the monthly membership fee.
     * @return Status of membership fee being owed.
     */
    public boolean isOwingPremiumFee()
    {
        return owePremiumFee;
    }
    
    /**
     * Sets whether or not the member owes the monthly membership fee.
     * @param _owePremiumFee 
     */
    public void setOwedPremiumFee(boolean _owePremiumFee)
    {
         owePremiumFee = _owePremiumFee;
    }
    
    /**
     * Get the member's preferred payment method.
     * @return Payment method the customer prefers.
     */
    public String getPaymentMethod()
    {
        return paymentMethod;
    }
    
    /**
     * Sets the member's preferred payment method.
     * @param _paymentMethod Member preferred payment method.
     */
    public void setPaymentMethod(String _paymentMethod)
    {
        paymentMethod = _paymentMethod;
    }
    
    /**
     * Get the member's current balance owed to the store.
     * @return balance Member's balance owed.
     */
    public double getBalance()
    {
        return balance;
    }
    
    /**
     * Sets the balance owed to the bookstore.
     * @param _balance Balance owed to the bookstore.
     */
    public void setBalance(double _balance)
    {
        balance = _balance;
    }
    
    /**
     * Get the member's total lifetime spending at the store.
     * @return totalSpent The lifetime amount of member spending.
     */
    public double getTotalSpent()
    {
        return totalSpent;
    }
    
    /**
     * Sets the total amount the member has spent at the store.
     * @param _totalSpent Lifetime spending at the store.
     */
    public void setTotalSpent(double _totalSpent)
    {
        totalSpent = _totalSpent;
    }
    
    /**
     * Shortcut for determining and printing if the member is premium or regular status.
     * @return Membership status.
     */
    public String checkMemberStatus()
    {
        if( premiumStatus == true)
        {
            return "Premium Member";
        }
        else
        {
            return "Regular Member";
        }
    }
    
}
