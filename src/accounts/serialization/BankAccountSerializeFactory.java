package accounts.serialization;

import accounts.BankAccount;
import com.google.inject.Singleton;

@Singleton
public class BankAccountSerializeFactory {

    public BankAccountSerialize createBankAccountSerialize(BankAccount bankAccount) {
        BankAccountSerialize bankAccountSerialize = new BankAccountSerialize();

        bankAccountSerialize.bankAccountNumber = bankAccount.getAccountNumber();

        return bankAccountSerialize;
    }

}
