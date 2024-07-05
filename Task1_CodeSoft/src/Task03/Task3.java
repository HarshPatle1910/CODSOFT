
/*
							ATM INTERFACE
							
1.Create a class to represent the ATM machine.
2. Design the user interface for the ATM, including options such as withdrawing, depositing, and
checking the balance.
3. Implement methods for each option, such as withdraw(amount), deposit(amount), and
checkBalance().
4. Create a class to represent the user's bank account, which stores the account balance.
5. Connect the ATM class with the user's bank account class to access and modify the account
balance.
6. Validate user input to ensure it is within acceptable limits (e.g., sufficient balance for withdrawals).
7. Display appropriate messages to the user based on their chosen options and the success or failure
of their transactions.
*/

package Task03;

import java.util.InputMismatchException;
import java.util.Scanner;

//Class for bank account calculation.
class BankAccount {
    private double balance;
    
    public BankAccount(double balance) {
    	this.balance = balance;
    }

    public double getBalance() {
    	return balance;
    }
    
    public void setBalance(double balance){
        this.balance = balance;
    }

    public void deposit(double amount) {
    	balance += amount;
    }

    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        } else { 
        	return false;
        }
    }
}

class ATM extends BankAccount {
    public ATM(double balance) {
        super(balance);
    }
    
    void startATM() {
        Scanner sc = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("\t\tWelcome to the ATM!\n");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("\nChoose an option - ");
            try {
                choice = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.\n");
                sc.next(); //Consume invalid input
                continue;
            }
                
            switch (choice) {
            	case 1:
                    withdraw(sc);
                    break;
            	case 2:
                    deposit(sc);
                    break;
            	case 3:
                    checkBalance();
                    break;
            	case 4:
                    System.out.println("Thank you for using the ATM.");
                    return;
                default:
                    System.out.println("Invalid choice.\n");
            }
        }
    }

    //creating method for withdrawing
    void withdraw(Scanner sc) {
        System.out.println("Enter the amount to withdraw : ");
        try {
            double amt = sc.nextDouble();
            if (withdraw(amt)) {
                System.out.println("You have withdrawn amount " + amt + " Rs. successfully.");
                System.out.println("Your new balance : Rs. " + getBalance() + "\n");
            } else {
                System.out.println("Insufficient balance. Withdrawal failed.\n");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid amount.\n");
            sc.next(); // Consume invalid input
        }
    }

    //creating method for depositing
    void deposit(Scanner sc) {
        System.out.println("Enter the amount to deposit: ");
        try {
            double amt = sc.nextDouble();
            deposit(amt);
            System.out.println("You have deposited amount of " + amt + " Rs. successfully.");
            System.out.println("Your new balance : Rs. " + getBalance() + "\n");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid amount.\n");
            sc.next(); // Consume invalid input
        }
    }

    //creating method for balance inquiry
    void checkBalance() {
        System.out.println("Your current balance : Rs. " + getBalance() + "\n");
    }
}

public class Task3 {
    public static void main(String[]args) {
        ATM atm = new ATM(0.00);
        atm.startATM();
    }
}