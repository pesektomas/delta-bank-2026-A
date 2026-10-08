package accounts;

import people.Owner;

public class StudentAccount extends BankAccount
{
    private String school;

    public StudentAccount(Owner owner, double balance, String school) {
        super(owner, balance);

        this.school = school;
    }

    public StudentAccount(Owner owner, String school) {
        this(owner, 0, school);
    }

    public String getSchool()
    {
        return this.school;
    }
}
