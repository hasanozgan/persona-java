package com.hasanozgan.challenge.service;

import com.hasanozgan.challenge.model.People;
import com.hasanozgan.challenge.model.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class PersonServiceTest
{

    @Autowired
    PersonService personService;

    @Test
    public void uniquePeople() throws Exception {
        People people = new People();
        people.addPerson("hasan", "ozgan", "+90 532 502 9685");
        people.addPerson("hasan", "ozgan", "+90 532 502 1122");
        people.addPerson("steve", "jobs", "+1 555 333 1122");

        assertEquals(people.size(), 2);
    }

    @Test
    public void testSearchByName() throws Exception {
        People people = new People();
        people.addPerson("hasan", "ozgan", "+90 532 502 9685");
        people.addPerson("hasan", "ozgan", "+90 532 502 1122");
        people.addPerson("steve", "jobs", "+1 555 333 1122");

        personService.importPeople(people);

        assertTrue(personService.findByName("steve").size() > 0);
    }

}
