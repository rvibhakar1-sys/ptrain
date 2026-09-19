import java.util.Scanner;
abstract class BankAccount {
    private String name;
    private int accountNumber;
    private int pin;              
    private double balance;
    BankAccount(String name, int accountNumber, int pin,
                double balance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = balance;
    }
    public boolean verifyPin(int enteredPin) {
        return this.pin == enteredPin;
    }
    public String getName() {
        return name;
    }
    public int getAccountNumber() {
        return accountNumber;
    }
    public double getBalance() {
        return balance;
    }
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful!");
        } else {
            System.out.println("Invalid amount!");
        }
    }
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount!");
        } else if (amount > balance) {
            System.out.println("Insufficient balance!");
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful!");
        }
    }
    abstract void displayAccountType();
}
class SavingsAccount extends BankAccount {
    SavingsAccount(String name, int accNo, int pin,
                   double balance) {
        super(name, accNo, pin, balance);
    }
    void displayAccountType() {
        System.out.println("Account Type: Savings Account");
    }
}
class CurrentAccount extends BankAccount {

    CurrentAccount(String name, int accNo, int pin,
                   double balance) {
        super(name, accNo, pin, balance);
    }
    void displayAccountType() {
        System.out.println("Account Type: Current Account");
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("===== JAVA BANK APPLICATION =====");
        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        System.out.print("Enter account number: ");
        int accNo = sc.nextInt();
        System.out.print("Create 4-digit PIN: ");
        int pin = sc.nextInt();
        System.out.print("Enter initial deposit: ");
        double balance = sc.nextDouble();
        System.out.println("\nChoose Account Type:");
        System.out.println("1. Savings Account");
        System.out.println("2. Current Account");
        int choice = sc.nextInt();
        BankAccount account;
        if (choice == 1) {
            account = new SavingsAccount(
                name, accNo, pin, balance);
        } else if (choice == 2) {
            account = new CurrentAccount(
                name, accNo, pin, balance);
        } else {
            System.out.println("Invalid account type!");
            sc.close();
            return;
        }
        System.out.print("\nEnter PIN to login: ");
        int enteredPin = sc.nextInt();
        if (!account.verifyPin(enteredPin)) {
            System.out.println("Incorrect PIN!");
            sc.close();
            return;
        }
        System.out.println("\nLogin successful!");
        System.out.println("Welcome, " + account.getName());
        account.displayAccountType();

        int option;

        do {
            System.out.println("\n===== BANK MENU =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            option = sc.nextInt();
            switch (option) {
                case 1:
                    System.out.println(
                        "Balance: Rs. " + account.getBalance());
                    break;
                case 2:
                    System.out.print("Enter deposit amount: ");
                    double deposit = sc.nextDouble();
                    account.deposit(deposit);
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: ");
                    double withdraw = sc.nextDouble();
                    account.withdraw(withdraw);
                    break;
                case 4:
                    System.out.println("Thank you for banking!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (option != 4);
        sc.close();
    }
}