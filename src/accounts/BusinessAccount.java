package accounts;

import people.Owner;

public class BusinessAccount extends BankAccount {

    public BusinessAccount(Owner owner) {
        super(owner);
    }

    public BusinessAccount(Owner owner, double balance) {
        super(owner, balance);
    }

}
