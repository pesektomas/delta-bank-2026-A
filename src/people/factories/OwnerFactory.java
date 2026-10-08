package people.factories;

import people.Owner;

public class OwnerFactory {
    public Owner createAccountOwner(String name, String lastName) {
        return new Owner(name, lastName);
    }
}
