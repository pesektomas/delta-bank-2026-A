package accounts.serialization;

import accounts.BankAccount;

import java.util.List;

public interface BankAccountSerialization {

    public String serializeAll(List<BankAccount> bankAccounts);

    public String serialize(BankAccount bankAccount);

}
