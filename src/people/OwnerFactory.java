package people;

public class OwnerFactory {
    public Owner createAccountOwner(String name, String lastName) {
        return new Owner(name, lastName);
    }
}
