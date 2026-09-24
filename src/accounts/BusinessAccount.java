package accounts;

import people.AccountOwner;

public class BusinessAccount extends BankAccount {

    private static final float SUB_FEE = 0.1f;

    public BusinessAccount(String uuid, String accountNumber, AccountOwner owner) {
        super(uuid, accountNumber, owner);
    }

    public BusinessAccount(AccountOwner owner) {
        super(owner);
    }

    public BusinessAccount(AccountOwner owner, double balance) {
        super(owner, balance);
    }

    @Override
    public void sub(double amount) {
        amount = amount + amount + SUB_FEE;
        super.sub(amount);
    }
}
