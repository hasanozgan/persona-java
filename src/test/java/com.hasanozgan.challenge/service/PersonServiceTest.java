package com.hasanozgan.challenge.service;

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
    /*
    @Autowired
    PersonService personService;

    @Test
    public void testCSVToPersonConverter() throws Exception {
        List<String> csvList = new ArrayList<String>();
        csvList.add("Hasan,Ozgan,555-323-1111");
        csvList.add("Steve,Jobs,3123123");

        assertEquals(personService.toPersonList(csvList).size(), 2);
    }

    @Test
    public void testImportData() throws Exception {
        List<String> csvList = new ArrayList<String>();
        csvList.add("Bill,Gates,555-323-1111");
        csvList.add("Steve,Jobs,3123123");

        List<Person> people = personService.toPersonList(csvList);
        assertTrue(personService.importPeople(people));
    }

    @Test
    public void testSearchByName() throws Exception {
        List<String> csvList = new ArrayList<String>();
        csvList.add("Bill,Gates,555-323-1111");
        csvList.add("Steve,Jobs,3123123");

        List<Person> people = personService.toPersonList(csvList);
        personService.importPeople(people);

        assertTrue(personService.findByName("Bill").size() > 0);
    }
    */
}
