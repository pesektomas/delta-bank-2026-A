package people.factories;

import com.google.inject.Singleton;
import people.Owner;

@Singleton
public class OwnerFactory {

    public Owner createAccountOwner(String name, String lastName) {
        return new Owner(name, lastName);
    }

}
