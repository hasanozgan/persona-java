package com.hasanozgan.challenge.builder;

import com.hasanozgan.challenge.model.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: hasanozgan
 * Date: 9/28/13
 * Time: 9:59 AM
 * To change this template use File | Settings | File Templates.
 */
public class PersonBuilder {

    private String name = "Hasan";
    private String lastName = "Ozgan";
    private List<String> phones = new ArrayList<String>();

    public PersonBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public PersonBuilder clearPhoneList() {
        this.phones.clear();
        return this;
    }

    public PersonBuilder withPhoneNumber(String phoneNumber) {
        this.phones.add(phoneNumber);
        return this;
    }

    public Person build() {
        return new Person();
    }
}
