import accounts.BankAccount;
import accounts.InterestPoint;
import accounts.StudentAccount;
import accounts.serialization.BankAccountJsonSerializationService;
import accounts.serialization.BankAccountSerialization;
import accounts.serialization.BankAccountXmlSerializationService;
import accounts.services.AccountService;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import creditCards.CreditCard;
import creditCards.CreditCardFactory;
import people.Owner;
import people.services.OwnerService;
import transfers.TransferService;

@Singleton
public class App {

    @Inject
    private OwnerService ownerService;

    @Inject
    private AccountService accountService;

    @Inject
    private BankAccountJsonSerializationService bankAccountJsonSerializationService;

    @Inject
    private BankAccountXmlSerializationService bankAccountXmlSerializationService;

    @Inject
    private CreditCardFactory creditCardFactory;

    @Inject
    private TransferService transferService;

    public void run() {

        Owner owner = this.ownerService.createOwner("Tomas", "Pesek");

        System.out.println("ORIGINAL");
        BankAccount bankAccount = this.accountService.createCurrentAccount(owner, 1000);
        System.out.println("---");

        System.out.println("LOGGING");
        BankAccount savingAccount = this.accountService.createSavingAccount(owner, 1000);
        System.out.println("---");

        System.out.println("LOGGING WITH TIME");
        BankAccount businessAccount = this.accountService.createBusinessAccount(owner, 1000);
        System.out.println("---");

        System.out.println("LOGGING AND LOGGING WITH TIME");
        BankAccount studentAccount = this.accountService.createStudentAccount(owner, 100, "Delta");
        System.out.println("---");

        for (BankAccount account : this.accountService.getAccounts()) {
            if (account instanceof InterestPoint) {
                ((InterestPoint)account).calculateInterest();
            }
        }


        for (BankAccount account : this.accountService.getAccounts()) {

            if (account instanceof StudentAccount) {
                StudentAccount overrideAccount = (StudentAccount) account;
                System.out.println("school: " + overrideAccount.getSchool());
            }
        }

        //Serialization bankAccountJsonSerializationService = new BankAccountJsonSerializationService();

        BankAccountSerialization bankAccountJsonSerializationService = this.bankAccountJsonSerializationService;
        BankAccountSerialization bankAccountXmlSerializationService = this.bankAccountXmlSerializationService;

        String json = bankAccountJsonSerializationService.serialize(bankAccount);
        System.out.println(json);
        String allAccountJson = bankAccountJsonSerializationService.serializeAll(this.accountService.getAccounts());
        System.out.println(allAccountJson);

        String xml = bankAccountXmlSerializationService.serialize(bankAccount);
        System.out.println(xml);
        String allAccountXml = bankAccountXmlSerializationService.serializeAll(this.accountService.getAccounts());
        System.out.println(allAccountXml);


        try {
            this.transferService.withdraw(bankAccount, 500);
            this.transferService.addToBalance(bankAccount,300);
            this.transferService.addToBalance(bankAccount,100);
            System.out.println("balance: " + bankAccount.getBalance());


            CreditCard creditCard = this.creditCardFactory.createCreditCard(owner, 500);
            this.transferService.addToBalance(creditCard,1000);
            this.transferService.withdraw(creditCard,100);


            this.transferService.withdraw(bankAccount, 500);
            this.transferService.withdraw(bankAccount,500);
            this.transferService.withdraw(bankAccount,500);

            System.out.println("balance: " + bankAccount.getBalance());
        } catch (RuntimeException e) {
            System.out.println("error: " + e.getMessage());
        }
    }

}
