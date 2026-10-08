package accounts.serialization;

import accounts.BankAccount;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class BankAccountGsonSerializationService implements BankAccountSerialization {

    BankAccountSerializeFactory bankAccountSerializeFactory = new BankAccountSerializeFactory();
    Gson gson = new Gson();

    @Override
    public String serializeAll(List<BankAccount> bankAccounts) {

        List<BankAccountSerialize> bankAccountsSerialize = new ArrayList<>();
        for (BankAccount bankAccount : bankAccounts) {
            bankAccountsSerialize.add(bankAccountSerializeFactory.createBankAccountSerialize(bankAccount));
        }

        return gson.toJson(bankAccountsSerialize);
    }

    @Override
    public String serialize(BankAccount bankAccount) {

        BankAccountSerialize bankAccountSerialize = bankAccountSerializeFactory.createBankAccountSerialize(bankAccount);

        return gson.toJson(bankAccountSerialize);
    }
}
