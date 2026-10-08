package people.services;

import accounts.BankAccount;
import people.Owner;
import people.factories.OwnerFactory;

import java.util.ArrayList;
import java.util.List;

public class OwnerService {

    OwnerFactory ownerFactory = new OwnerFactory();

    List<Owner> owners = new ArrayList<>();

    public Owner createOwner(String firstName, String lastName) {
        Owner owner = ownerFactory.createAccountOwner(firstName, lastName);
        owners.add(owner);

        return owner;
    }

}
