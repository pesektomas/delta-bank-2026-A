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
import people.Owner;
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

        TransferService transferService = new TransferService();

        IAccountService accountService = new AccountService();
        IAccountService accountServiceWithLogin
                = new AccountLoggingService(accountService);
        IAccountService accountServiceWithTimeLogin
                = new AccountLoggingWithTimeService(accountService);
        IAccountService accountServiceWithLoginAndTimeLogin
                = new AccountLoggingService(accountServiceWithTimeLogin);

        OwnerService ownerService = new OwnerService();
        Owner owner = ownerService.createOwner("Tomas", "Pesek");

        System.out.println("ORIGINAL");
        BankAccount bankAccount = accountService.createCurrentAccount(owner, 1000);
        System.out.println("---");

        System.out.println("LOGGING");
        BankAccount savingAccount = accountServiceWithLogin.createSavingAccount(owner, 1000);
        System.out.println("---");

        System.out.println("LOGGING WITH TIME");
        BankAccount businessAccount = accountServiceWithTimeLogin.createBusinessAccount(owner, 1000);
        System.out.println("---");

        System.out.println("LOGGING AND LOGGING WITH TIME");
        BankAccount studentAccount = accountServiceWithLoginAndTimeLogin.createStudentAccount(owner, 100, "Delta");
        System.out.println("---");

        for (BankAccount account : accountService.getAccounts()) {
            if (account instanceof InterestPoint) {
                ((InterestPoint)account).calculateInterest();
            }
        }


        for (BankAccount account : accountService.getAccounts()) {

            if (account instanceof StudentAccount) {
                StudentAccount overrideAccount = (StudentAccount) account;
                System.out.println("school: " + overrideAccount.getSchool());
            }
        }

        //Serialization bankAccountJsonSerializationService = new BankAccountJsonSerializationService();
        BankAccountSerialization bankAccountJsonSerializationService = new BankAccountGsonSerializationService();
        BankAccountSerialization bankAccountXmlSerializationService = new BankAccountXmlSerializationService();

        String json = bankAccountJsonSerializationService.serialize(bankAccount);
        System.out.println(json);
        String allAccountJson = bankAccountJsonSerializationService.serializeAll(accountService.getAccounts());
        System.out.println(allAccountJson);

        String xml = bankAccountXmlSerializationService.serialize(bankAccount);
        System.out.println(xml);
        String allAccountXml = bankAccountXmlSerializationService.serializeAll(accountService.getAccounts());
        System.out.println(allAccountXml);


        try {
            transferService.withdraw(bankAccount, 500);
            transferService.addToBalance(bankAccount,300);
            transferService.addToBalance(bankAccount,100);
            System.out.println("balance: " + bankAccount.getBalance());


            CreditCard creditCard = new CreditCard(owner, 500);
            transferService.addToBalance(creditCard,1000);
            transferService.withdraw(creditCard,100);


            transferService.withdraw(bankAccount, 500);
            transferService.withdraw(bankAccount,500);
            transferService.withdraw(bankAccount,500);

            System.out.println("balance: " + bankAccount.getBalance());
        } catch (RuntimeException e) {
            System.out.println("error: " + e.getMessage());
        }
    }
}