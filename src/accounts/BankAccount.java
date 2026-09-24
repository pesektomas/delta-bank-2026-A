package accounts;

import notifiers.ConsoleNotifier;
import notifiers.EmailNotifier;
import notifiers.Notifier;
import people.AccountOwner;

// kod banky  2010

public abstract class BankAccount {

    private String uuid;

    private String accountNumber; // 2102405518

    private AccountOwner owner;

    protected double balance;

    protected Notifier notifier = new EmailNotifier();

    public BankAccount(String uuid, String accountNumber, AccountOwner owner) {}

    public BankAccount(AccountOwner owner) {
        this.owner = owner;
        this.balance = 0;
    }

    public BankAccount(AccountOwner owner, double balance) {
        this.owner = owner;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void sub(double amount) {
        this.notifier.notify("Sub amount is " + amount);

        double newBalance = balance - amount;

        if (newBalance < 0) {
            throw new RuntimeException("Balance is negative");
        }

        this.balance = newBalance;
    }

    public void add(double amount) {
        System.out.println("Add amount is " + amount);

        this.balance = this.balance + amount;
    }
}
