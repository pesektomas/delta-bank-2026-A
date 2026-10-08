package accounts.serialization;

import accounts.BankAccount;

import java.util.List;

public class BankAccountJsonSerializationService {

    BankAccountSerializeFactory bankAccountSerializeFactory = new BankAccountSerializeFactory();

    public String serializeAll(List<BankAccount> bankAccounts) {

        StringBuilder builder = new StringBuilder();
        builder.append("[");

        for(BankAccount bankAccount : bankAccounts) {
            builder.append(serialize(bankAccount));

            // TODO if is not last item
            builder.append(",");
        }

        builder.append("]");

        return builder.toString();
    }

    public String serialize(BankAccount bankAccount) {

        BankAccountSerialize bankAccountSerialize = bankAccountSerializeFactory.createBankAccountSerialize(bankAccount);

        // TODO make json string
        StringBuilder builder = new StringBuilder();

        builder.append("{");
        builder.append("\"accountNumber\":");

        builder.append("\"");
        builder.append(bankAccountSerialize.bankAccountNumber);
        builder.append("\"");

        builder.append("}");


        return builder.toString();
    }

}
