package accounts.factories;

import accounts.*;
import accounts.services.AccountNumberGenerator;
import notifiers.EmailNotifier;
import notifiers.Notifier;
import people.Owner;

import java.util.UUID;

public class BankAccountFactory {

    private Notifier notifier;
    private AccountNumberGenerator accountNumberGenerator;

    public BankAccountFactory(Notifier notifier, AccountNumberGenerator accountNumberGenerator) {
        this.notifier = notifier;
        this.accountNumberGenerator = accountNumberGenerator;
    }

    public BankAccount createCurrentAccount(Owner owner, double balance) {
        CurrentAccount currentAccount = new CurrentAccount(owner, balance);
        this.initBankAccount(currentAccount);

        return currentAccount;
    }

    public BankAccount createStudentAccount(Owner owner, double balance, String school) {
        StudentAccount studentAccount = new StudentAccount(owner, balance, school);
        this.initBankAccount(studentAccount);

        return studentAccount;
    }

    public BankAccount createSavingAccount(Owner owner, double balance) {
        SavingAccount savingAccount = new SavingAccount(owner, balance);
        this.initBankAccount(savingAccount);

        return savingAccount;
    }

    public BankAccount createBusinessAccount(Owner owner, double balance) {
        BusinessAccount businessAccount = new BusinessAccount(owner, balance);
        this.initBankAccount(businessAccount);

        return businessAccount;
    }

    private void initBankAccount(BankAccount bankAccount) {
        bankAccount.setUuid(UUID.randomUUID().toString());
        bankAccount.setAccountNumber(this.accountNumberGenerator.generate());
    }
}
