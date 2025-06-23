import javax.swing.JOptionPane;

class Account {

    private String accountNumber;
    private String name;
    private double balance;

    public Account(String accountNumber, String name, double initialBalance) {
        this.accountNumber = accountNumber;
        this.name = name;
        if (initialBalance > 0.0) {
            this.balance = initialBalance;
        } else {
            this.balance = 0;
        }
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            JOptionPane.showMessageDialog(null, "Insufficient funds in your account.");
        } else if (amount > 0) {
            balance -= amount;
        }
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getName() {
        return name;
    }
}

public class AccountTest {

    public static void main(String[] args) {

        Account me = new Account("1234567890", "Kittiphat Phengnamkham", 100);

        System.out.println("Account Number: " + me.getAccountNumber());
        System.out.println("Account Holder: " + me.getName());
        System.out.println("Initial Balance: " + me.getBalance());

        me.deposit(300);
        System.out.println("\nAfter deposit of 300:");
        System.out.println("Current Balance: " + me.getBalance());

        me.withdraw(500);
        System.out.println("\nAfter attempting to withdraw 500:");
        System.out.println("Current Balance: " + me.getBalance());

        me.withdraw(200);
        System.out.println("\nAfter withdrawing 200:");
        System.out.println("Current Balance: " + me.getBalance());
    }
}
