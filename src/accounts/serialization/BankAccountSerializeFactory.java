package accounts.serialization;

import accounts.BankAccount;

public class BankAccountSerializeFactory {

    public BankAccountSerialize createBankAccountSerialize(BankAccount bankAccount) {
        BankAccountSerialize bankAccountSerialize = new BankAccountSerialize();

        bankAccountSerialize.bankAccountNumber = bankAccount.getAccountNumber();

        return bankAccountSerialize;
    }

}
