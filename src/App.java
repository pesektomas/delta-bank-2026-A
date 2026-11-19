import accounts.BankAccount;
import accounts.InterestPoint;
import accounts.StudentAccount;
import accounts.serialization.BankAccountSerialization;
import creditCards.CreditCard;
import di.Container;
import people.Owner;

public class App {

    public void run(Container container) {

        Owner owner = container.ownerService.createOwner("Tomas", "Pesek");

        System.out.println("ORIGINAL");
        BankAccount bankAccount = container.accountService.createCurrentAccount(owner, 1000);
        System.out.println("---");

        System.out.println("LOGGING");
        BankAccount savingAccount = container.accountServiceWithLogin.createSavingAccount(owner, 1000);
        System.out.println("---");

        System.out.println("LOGGING WITH TIME");
        BankAccount businessAccount = container.accountServiceWithTimeLogin.createBusinessAccount(owner, 1000);
        System.out.println("---");

        System.out.println("LOGGING AND LOGGING WITH TIME");
        BankAccount studentAccount = container.accountServiceWithLoginAndTimeLogin.createStudentAccount(owner, 100, "Delta");
        System.out.println("---");

        for (BankAccount account : container.accountService.getAccounts()) {
            if (account instanceof InterestPoint) {
                ((InterestPoint)account).calculateInterest();
            }
        }


        for (BankAccount account : container.accountService.getAccounts()) {

            if (account instanceof StudentAccount) {
                StudentAccount overrideAccount = (StudentAccount) account;
                System.out.println("school: " + overrideAccount.getSchool());
            }
        }

        //Serialization bankAccountJsonSerializationService = new BankAccountJsonSerializationService();

        BankAccountSerialization bankAccountJsonSerializationService = container.bankAccountJsonSerializationService;
        BankAccountSerialization bankAccountXmlSerializationService = container.bankAccountXmlSerializationService;

        String json = bankAccountJsonSerializationService.serialize(bankAccount);
        System.out.println(json);
        String allAccountJson = bankAccountJsonSerializationService.serializeAll(container.accountService.getAccounts());
        System.out.println(allAccountJson);

        String xml = bankAccountXmlSerializationService.serialize(bankAccount);
        System.out.println(xml);
        String allAccountXml = bankAccountXmlSerializationService.serializeAll(container.accountService.getAccounts());
        System.out.println(allAccountXml);


        try {
            container.transferService.withdraw(bankAccount, 500);
            container.transferService.addToBalance(bankAccount,300);
            container.transferService.addToBalance(bankAccount,100);
            System.out.println("balance: " + bankAccount.getBalance());


            CreditCard creditCard = container.creditCardFactory.createCreditCard(owner, 500);
            container.transferService.addToBalance(creditCard,1000);
            container.transferService.withdraw(creditCard,100);


            container.transferService.withdraw(bankAccount, 500);
            container.transferService.withdraw(bankAccount,500);
            container.transferService.withdraw(bankAccount,500);

            System.out.println("balance: " + bankAccount.getBalance());
        } catch (RuntimeException e) {
            System.out.println("error: " + e.getMessage());
        }
    }

}
