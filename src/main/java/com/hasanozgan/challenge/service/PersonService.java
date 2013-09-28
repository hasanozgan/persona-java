package com.hasanozgan.challenge.service;

import com.google.code.morphia.query.Query;
import com.google.code.morphia.query.QueryResults;
import com.hasanozgan.challenge.dao.PersonDAO;
import com.hasanozgan.challenge.model.Person;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: hasan.ozgan
 * Date: 9/26/13
 * Time: 2:57 PM
 * To change this template use File | Settings | File Templates.
 */
@Component
public class PersonService {

    @Autowired
    PersonDAO personDAO;

    public List<Person> findByName(String name) {

        QueryResults<Person> persons = personDAO.findByName(name);

        return persons.asList();
    }

    public boolean importPeople(List<Person> people) {
        try {
            personDAO.saveAll(people);

            return true;
        }
        catch (Exception ex) {
        }

        return false;
    }

    public List<Person> toPersonList(List<String> csvLines) {
        List<Person> people = new ArrayList<Person>();
        for (String line : csvLines) {
            String[] fields = line.split(",");

            if (fields.length == 3) {
                people.add(new Person(fields[0], fields[1], fields[2]));
            }
        }
        return people;
    }
}
