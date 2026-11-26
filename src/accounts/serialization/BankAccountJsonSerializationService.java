package accounts.serialization;

import accounts.BankAccount;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import java.util.List;

@Singleton
public class BankAccountJsonSerializationService implements BankAccountSerialization {

    @Inject
    BankAccountSerializeFactory bankAccountSerializeFactory;

    @Override
    public String serializeAll(List<BankAccount> bankAccounts) {

        StringBuilder builder = new StringBuilder();
        builder.append("[\n");

        for (int i = 0; i < bankAccounts.size(); i++) {
            builder.append(serialize(bankAccounts.get(i)));
            if (i < bankAccounts.size() - 1) {
                builder.append(",\n");
            }
        }

        builder.append("]");

        return builder.toString();
    }

    @Override
    public String serialize(BankAccount bankAccount) {

        BankAccountSerialize bankAccountSerialize = bankAccountSerializeFactory.createBankAccountSerialize(bankAccount);

        // TODO make json string
        StringBuilder builder = new StringBuilder();

        builder.append("{\n");
        builder.append("\"accountNumber\": ");

        builder.append("\"");
        builder.append(bankAccountSerialize.bankAccountNumber);
        builder.append("\"\n");

        builder.append("}");


        return builder.toString();
    }
}
