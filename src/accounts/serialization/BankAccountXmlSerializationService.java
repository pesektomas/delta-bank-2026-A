package accounts.serialization;

import accounts.BankAccount;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import java.util.List;

@Singleton
public class BankAccountXmlSerializationService implements BankAccountSerialization {

    @Inject
    BankAccountSerializeFactory bankAccountSerializeFactory;

    @Override
    public String serializeAll(List<BankAccount> bankAccounts) {

        StringBuilder builder = new StringBuilder();
        builder.append("<root>\n");
        builder.append("<accountList>\n");

        for(BankAccount bankAccount : bankAccounts) {
            builder.append(serialize(bankAccount));
        }

        builder.append("</accountList>\n");
        builder.append("<root>\n");

        return builder.toString();
    }

    @Override
    public String serialize(BankAccount bankAccount) {

        BankAccountSerialize bankAccountSerialize = bankAccountSerializeFactory.createBankAccountSerialize(bankAccount);

        // TODO make json string
        StringBuilder builder = new StringBuilder();

        builder.append("<bankAccount>\n");
        builder.append("<number>");
        builder.append(bankAccountSerialize.bankAccountNumber);
        builder.append("</number>\n");
        builder.append("</bankAccount>\n");


        return builder.toString();
    }

}

