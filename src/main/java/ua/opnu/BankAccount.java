
package ua.opnu;

public class BankAccount {
    public double balance;
    public double transactionFee;

    public BankAccount() {
        this.balance = 0;
        this.transactionFee = 0;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            return;
        }
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= 0) {
            return false;
        }
        double total = amount + transactionFee;
        if (balance >= total) {
            balance -= total;
            return true;
        }
        return false;
    }

    public boolean transfer(BankAccount other, double amount) {
        if (other == null || amount <= 0) {
            return false;
        }
        double total = amount + transactionFee;
        if (balance >= total) {
            balance -= total;
            other.deposit(amount);
            return true;
        }
        return false;
    }
}