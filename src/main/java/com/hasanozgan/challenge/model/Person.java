package com.hasanozgan.challenge.model;

import com.google.code.morphia.annotations.*;
import com.google.code.morphia.utils.IndexDirection;
import org.bson.types.ObjectId;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: hasan.ozgan
 * Date: 9/25/13
 * Time: 3:32 PM
 * To change this template use File | Settings | File Templates.
 */

@Entity("person")
@Indexes(@Index(name = "nameAndlastName", value = "name, lastName", unique = true, dropDups = true))
public class Person {

    @Id
    ObjectId id;

    @Property("name")
    String name;

    @Property("lastName")
    String lastName;

    Set<String> phones;

    public Person() {
    }

    public Person(String name, String lastName, String phones) {
        this.name = name;
        this.lastName = lastName;
        this.phones = new HashSet<String>(Arrays.asList(phones.split(":")));
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

    public Set<String> getPhones() {
        return phones;
    }

    public void setPhones(Set<String> phones) {
        this.phones = phones;
    }

    @Override
    public int hashCode() {
        int result = (name != null ? name.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);

        return result;
    }
}
