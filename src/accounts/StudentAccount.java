package accounts;

import people.AccountOwner;

public class StudentAccount extends BankAccount
{
    private static final int LIMIT = -5000;

    private String school;

    public StudentAccount(AccountOwner owner, String school) {
        super(owner);

        this.school = school;
    }

    public StudentAccount(AccountOwner owner, double balance) {
        super(owner, balance);
    }

    public String getSchool()
    {
        return this.school;
    }

    public void sub(double amount) {
        this.notifier.notify("Sub amount is " + amount);

        double newBalance = balance - amount;

        if (newBalance <= LIMIT) {
            throw new RuntimeException("Balance is negative");
        }

        this.balance = newBalance;
    }


}
