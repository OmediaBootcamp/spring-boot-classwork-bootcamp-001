package dev.omedia.model;

import dev.omedia.domain.Person;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Past;
import java.time.LocalDate;

public class PersonModel extends OwnerModel<Person> {

    public PersonModel() {
        this(new Person());
    }

    protected PersonModel(Person owner) {
        super(owner, OwnerType.PERSON);
    }

    public String getPersonalNo() {
        return owner.getPersonalNo();
    }

    public LocalDate getBirthDate() {
        return owner.getBirthDate();
    }

    public void setPersonalNo(@Digits(integer = 11, fraction = 0) String personalNo) {
        owner.setPersonalNo(personalNo);
    }

    public void setBirthDate(@Past LocalDate birthDate) {
        owner.setBirthDate(birthDate);
    }
}
