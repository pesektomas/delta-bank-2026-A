package accounts;

import people.AccountOwner;

public class SavingAccount extends BankAccount implements InterestPoint {

    private static final float INTEREST = 0.5f;
    private static final float BONUS_FEE = 0.5f;

    public SavingAccount(String uuid, String accountNumber, AccountOwner owner) {
        super(uuid, accountNumber, owner);
    }

    public SavingAccount(AccountOwner owner) {
        super(owner);
    }

    public SavingAccount(AccountOwner owner, double balance) {
        super(owner, balance);
    }

    @Override
    public void add(double amount) {
        double newBalance = this.balance + amount + (amount * BONUS_FEE);
        this.balance = newBalance;
    }

    @Override
    public void calculateInterest() {
        double interest = this.balance * INTEREST;

        this.add(interest);
    }
}
