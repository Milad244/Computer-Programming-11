package DataAbstractionAssignment.src;//import javax.security.sasl.SaslClient;
import java.util.ArrayList;
import java.util.Date;

public class Customer {
    private int accountNumber;
    private ArrayList<Deposit> deposits;
    private ArrayList<Withdraw> withdraws;
    private double checkBalance;
    private double savingBalance;
    private double savingRate;
    private String name;
    public static final String CHECKING = "Checking";
    public static final String SAVING = "Saving";
    private final int OVERDRAFT = -100;

    // Requires: nothing
    // Modifies: this
    // Effects: Creates default fields for customer
    public Customer(){
        //create default constructor
        deposits = new ArrayList<>();
        withdraws = new ArrayList<>();
        this.name = "UnNamed Customer";
        this.accountNumber = 1;
    }

    // Requires: name of customer as a string, account number as an integer, amount for check deposit as double, and amount for saving deposit as double
    // Modifies: this
    // Effects: Creates specific fields for customer and adds a starting deposit to the checking and saving accounts
    public Customer(String name, int accountNumber, double checkDeposit, double savingDeposit){
        //constructor code here
        deposits = new ArrayList<>();
        withdraws = new ArrayList<>();
        this.name = name;
        this.accountNumber = accountNumber;
        deposit(checkDeposit, new Date(), CHECKING);
        deposit(savingDeposit, new Date(), SAVING);
    }

    // Requires: amount to be deposited as a double, date as a Date type, and an account (either CHECKING or SAVING)
    // Modifies: this
    // Effects: Deposits money into either a checking or saving account, provided the amount is equal or higher than zero.
    // In addition, this method saves the transactions in the "deposits" ArrayList.
    public double deposit(double amt, Date date, String account){
        //your code here
        if (amt >= 0){
            if (account.equals(CHECKING)){
                checkBalance += amt;
                this.deposits.add(new Deposit(amt, date, account, checkBalance));
                return amt;
            } else if(account.equals(SAVING)){
                savingBalance += amt;
                this.deposits.add(new Deposit(amt, date, account, savingBalance));
                return amt;
            }
        }
        return amt;
    }

    // Requires: amount to be withdrawn as a double, date as a Date type, and an account (either CHECKING or SAVING)
    // Modifies: this
    // Effects: Withdraws money from either a checking or saving account, provided the amount is equal or higher than zero.
    // In addition, it checks and deals with a possible overdraft by using the overdraft method.
    // Finally, this method saves the transactions in the "withdraws" ArrayList.
    public double withdraw(double amt, Date date, String account){
        //your code here
        if (amt >= 0) {
            if (account.equals(CHECKING)) {
                checkOverdraft(amt, CHECKING);
                checkBalance -= amt;
                this.withdraws.add(new Withdraw(amt, date, account, checkBalance));
                return amt;
            } else if (account.equals(SAVING)) {
                checkOverdraft(amt, SAVING);
                savingBalance -= amt;
                this.withdraws.add(new Withdraw(amt, date, account, savingBalance));
                return amt;
            }
        }
        return amt;
    }

    // Requires: amount to be withdrawn as a double, and an account (either CHECKING or SAVING)
    // Modifies: this
    // Effects: Checks whether the account will get overdrafted. If it will overdraft, then it returns false, occurs a fee on the account
    // and prints "OverDraft!" in the console. Otherwise, it returns true.
    private boolean checkOverdraft(double amt, String account){
        if (account.equals(CHECKING)){
            if (checkBalance - amt >= 0){
                return true;
            } else {
                checkBalance += OVERDRAFT;
                System.out.println("OverDraft!");
                return false;
            }
        } else if(account.equals(SAVING)){
            if (savingBalance - amt >= 0){
                return true;
            } else {
                savingBalance += OVERDRAFT;
                System.out.println("OverDraft!");
                return false;
            }
        }
        return false;
    }

    // Requires: nothing
    // Modifies: nothing
    // Effects: prints every deposit made from the customer
    //do not modify
    public void displayDeposits(){
        for(Deposit d : deposits){
            System.out.println(d);
        }
    }
    // Requires: nothing
    // Modifies: nothing
    // Effects: prints every withdrawal made from the customer
    //do not modify
    public void displayWithdraws(){
        for(Withdraw w : withdraws){
            System.out.println(w);
        }
    }

    // Getters created for testing

    // Requires: nothing
    // Modifies: nothing
    // Effects: returns check balance
    public double getCheckBalance() {
        return checkBalance;
    }

    // Requires: nothing
    // Modifies: nothing
    // Effects: returns savings balance
    public double getSavingBalance() {
        return savingBalance;
    }

    // Requires: nothing
    // Modifies: nothing
    // Effects: returns name
    public String getName() {
        return name;
    }

    // Requires: nothing
    // Modifies: nothing
    // Effects: returns account number
    public int getAccountNumber() {
        return accountNumber;
    }
}
