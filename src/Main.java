import com.google.inject.Guice;
import com.google.inject.Injector;
import di.BankModule;

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
        Injector injector = Guice.createInjector(new BankModule());
        App app = injector.getInstance(App.class);
        app.run();

        // App app = new App();
        // app.run();

    }
}