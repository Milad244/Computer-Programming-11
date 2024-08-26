package DataAbstractionAssignment.TestCases;
import DataAbstractionAssignment.src.Customer;
import org.junit.Before;
import org.junit.Test;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class DataAbstractionTest {

    Customer customerTestSet;
    Customer customerTestSet2;

    @Before
    public void setUp() {
        customerTestSet = new Customer();
        customerTestSet2 = new Customer();
    }

    @Test
    public void testDefaultCustomerConstructor() {
        // Testing if default customer params are done correctly
        assertEquals(customerTestSet.getName(), "UnNamed Customer");
        assertEquals(customerTestSet.getAccountNumber(), 1);
    }

    @Test
    public void testCustomerConstructor() {
        // Testing if the custom param constructor sets the values properly from the custom params given
        Customer customerConstructorTestSet = new Customer("Bob", 1, 500, 1000);
        assertEquals(customerConstructorTestSet.getName(), "Bob");
        assertEquals(customerConstructorTestSet.getAccountNumber(), 1);
        assertEquals(customerConstructorTestSet.getCheckBalance(), 500, 0);
        assertEquals(customerConstructorTestSet.getSavingBalance(), 1000, 0);

        // Testing if negative deposits get ignored, as they should.
        Customer negativeCustomerConstructorTestSet = new Customer("Amy", 2, -210, -996);
        assertEquals(negativeCustomerConstructorTestSet.getCheckBalance(), 0, 0);
        assertEquals(negativeCustomerConstructorTestSet.getSavingBalance(), 0, 0);
    }

    @Test
    public void testDepositAndWithdraws() {
        // Testing if the positive deposits work properly
        customerTestSet.deposit(800, new Date(), Customer.CHECKING);
        customerTestSet.deposit(600, new Date(), Customer.SAVING);
        assertEquals(customerTestSet.getCheckBalance(), 800, 0);
        assertEquals(customerTestSet.getSavingBalance(), 600, 0);

        // Testing if the positive withdraws work properly
        customerTestSet.withdraw(450, new Date(), Customer.CHECKING);
        customerTestSet.withdraw(200, new Date(), Customer.SAVING);
        assertEquals(customerTestSet.getCheckBalance(), 350, 0);
        assertEquals(customerTestSet.getSavingBalance(), 400, 0);

        // Testing if positive deposits with decimals work properly
        customerTestSet.deposit(1000.5, new Date(), Customer.CHECKING);
        customerTestSet.deposit(500.9, new Date(), Customer.SAVING);
        assertEquals(customerTestSet.getCheckBalance(), 1350.5, 0);
        assertEquals(customerTestSet.getSavingBalance(), 900.9, 0);

        // Testing if positive withdraws with decimals work properly
        customerTestSet.withdraw(1000.5, new Date(), Customer.CHECKING);
        customerTestSet.withdraw(500.9, new Date(), Customer.SAVING);
        assertEquals(customerTestSet.getCheckBalance(), 350, 0);
        assertEquals(customerTestSet.getSavingBalance(), 400, 0);

        // Testing if negative deposits get ignored, as they should.
        customerTestSet.deposit(-5243, new Date(), Customer.CHECKING);
        customerTestSet.deposit(-105.976, new Date(), Customer.SAVING);
        assertEquals(customerTestSet.getCheckBalance(), 350, 0);
        assertEquals(customerTestSet.getSavingBalance(), 400, 0);

        // Testing if negative withdraws get ignored, as they should.
        customerTestSet.withdraw(-236.3, new Date(), Customer.CHECKING);
        customerTestSet.withdraw(-62.3, new Date(), Customer.SAVING);
        assertEquals(customerTestSet.getCheckBalance(), 350, 0);
        assertEquals(customerTestSet.getSavingBalance(), 400, 0);
    }

    @Test
    public void testOverdraft() {
        // Testing overdraft fee for checking account
        customerTestSet.deposit(5000, new Date(), Customer.CHECKING);
        customerTestSet.withdraw(6000, new Date(), Customer.CHECKING);
        assertEquals(customerTestSet.getCheckBalance(), -1100, 0);

        // Testing overdraft fee for savings account
        customerTestSet.deposit(10000, new Date(), Customer.SAVING);
        customerTestSet.withdraw(12000, new Date(), Customer.SAVING);
        assertEquals(customerTestSet.getSavingBalance(), -2100, 0);

        // Testing overdraft fee with decimals for checking account
        customerTestSet2.deposit(5000.55, new Date(), Customer.CHECKING);
        customerTestSet2.withdraw(6000.35, new Date(), Customer.CHECKING);
        assertEquals(customerTestSet2.getCheckBalance(), -1099.8, 0.01);

        // Testing overdraft fee with decimals for savings account
        customerTestSet2.deposit(10000.99, new Date(), Customer.SAVING);
        customerTestSet2.withdraw(12000.4, new Date(), Customer.SAVING);
        assertEquals(customerTestSet2.getSavingBalance(), -2099.41, 0.01);
    }
}
