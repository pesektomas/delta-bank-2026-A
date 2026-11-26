package people.services;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import people.Owner;
import people.factories.OwnerFactory;

import java.util.ArrayList;
import java.util.List;

@Singleton
public class OwnerService {

    @Inject
    OwnerFactory ownerFactory;

    List<Owner> owners = new ArrayList<>();

    public Owner createOwner(String firstName, String lastName) {
        Owner owner = ownerFactory.createAccountOwner(firstName, lastName);
        owners.add(owner);

        return owner;
    }

}
