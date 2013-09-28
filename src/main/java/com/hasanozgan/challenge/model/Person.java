package com.hasanozgan.challenge.model;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;
import org.bson.types.ObjectId;

import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: hasan.ozgan
 * Date: 9/25/13
 * Time: 3:32 PM
 * To change this template use File | Settings | File Templates.
 */

@Entity("person")
public class Person {

    @Id
    ObjectId id;

    String name;

    String lastName;

    List<String> phones;

    public Person() {
    }

    public Person(String name, String lastName, String phones) {
        this.name = name;
        this.lastName = lastName;
        this.phones = Arrays.asList(phones.split(":"));
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<String> getPhones() {
        return phones;
    }

    public void setPhones(List<String> phones) {
        this.phones = phones;
    }
}
