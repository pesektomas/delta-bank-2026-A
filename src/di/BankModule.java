package di;

import accounts.serialization.BankAccountJsonSerializationService;
import accounts.serialization.BankAccountXmlSerializationService;
import accounts.services.AccountService;
import accounts.services.IAccountService;
import com.google.inject.AbstractModule;
import notifiers.EmailNotifier;
import notifiers.Notifier;

public class BankModule extends AbstractModule {

    @Override
    protected void configure() {
        // Rozhraní -> implementace. Chceme EmailNotifier, ConsoleNotifier stačí přepsat tady

        // bind(Notifier.class).to(EmailNotifier.class).in(Singleton.class);

        bind(Notifier.class).to(EmailNotifier.class);

        bind(IAccountService.class).to(AccountService.class);
    }
}
