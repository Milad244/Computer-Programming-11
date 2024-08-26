package DataAbstractionAssignment.src;
import java.util.Date;

public class Main {
    public static void main(String args[]){
        Customer Milad = new Customer("Milad", 1, 5000, 5000);
        Milad.deposit(10000, new Date(), Customer.CHECKING);
        Milad.deposit(10000, new Date(), Customer.SAVING);
        Milad.withdraw(14000, new Date(), Customer.CHECKING);
        Milad.withdraw(14000, new Date(), Customer.SAVING);
        Milad.displayDeposits();
        Milad.displayWithdraws();
    }
}