import accounts.BankAccount;
import accounts.InterestPoint;
import accounts.StudentAccount;
import accounts.decorators.AccountLoggingService;
import accounts.decorators.AccountLoggingWithTimeService;
import accounts.serialization.BankAccountGsonSerializationService;
import accounts.serialization.BankAccountXmlSerializationService;
import accounts.serialization.BankAccountSerialization;
import accounts.services.AccountService;
import accounts.services.IAccountService;
import creditCards.CreditCard;
import di.Container;
import di.ContainerFactory;
import people.Owner;
import people.factories.OwnerFactory;
import people.services.OwnerService;
import transfers.TransferService;

import java.time.LocalTime;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {


    /*
     * Ukol na 17. 9.
     *
     * Vytvořit další typy účtů a rozšířit stávající:
     *
     * Studentský účet
     *  - povolit výběr 5 000 do záporu
     *
     * Spořící účet
     *  - když přidám peníze na účet, připíše se mi i 0,5% úrok
     *
     * Podnikatelský účet
     *  - každý výběr odečte transakční poplatek 1%
     *
     */

    public static void main(String[] args) {

        ContainerFactory containerFactory = new ContainerFactory();
        Container container = containerFactory.createContainer();

        App app = new App();
        app.run(container);

    }
}