package com.hasanozgan.challenge.service;

import com.google.code.morphia.query.Query;
import com.google.code.morphia.query.QueryResults;
import com.hasanozgan.challenge.dao.PersonDAO;
import com.hasanozgan.challenge.model.People;
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

    public boolean importPeople(People people) {
        try {
            personDAO.saveAll(people.values());

            return true;
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

        return false;
    }
}
