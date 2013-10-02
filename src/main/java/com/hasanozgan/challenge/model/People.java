package com.hasanozgan.challenge.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: hasanozgan
 * Date: 10/2/13
 * Time: 8:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class People extends HashMap<Integer, Person> {

    public void addPerson(String name, String lastName, String phone) {
        Person person = new Person(name, lastName, phone);

        if (containsKey(person.hashCode())) {
            get(person.hashCode()).getPhones().add(phone);
        }
        else {
            put(person.hashCode(), person);
        }
    }
}
