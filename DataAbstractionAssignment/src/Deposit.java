package DataAbstractionAssignment.src;

import java.util.Date;

public class Deposit {
    private double amount;
    private Date date;
    private String account;
    private double balance;

    // Requires: amount to be deposited as a double, the date as a Date type, the account (either CHECKING or SAVING), and the balance of that account as a double
    // Modifies: this
    // Effects: Stores the deposit transaction as a Deposit object.
    public Deposit(double amount, Date date, String account, double balance){
        this.amount = amount;
        this.date = date;
        this.account = account;
        this.balance = balance;
    }
    // Requires: nothing
    // Modifies: nothing
    // Effects: returns the deposit transaction made from the customer in a formatted string
    public String toString(){
        //your code here
        return ("Deposit of: $" + amount + " Date: " + date + " into account: " + account + " Current Balance in " + account + " is: $" + balance);
    }
}
