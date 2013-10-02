package com.hasanozgan.challenge.service;

import com.hasanozgan.challenge.service.parser.CSVParserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.net.URL;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: hasanozgan
 * Date: 9/28/13
 * Time: 10:14 AM
 * To change this template use File | Settings | File Templates.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class CSVServiceTest {
    /*
    @Autowired
    CSVParserService csvParserService;

    @Test
    public void testReadFile() throws Exception {
        URL url = Thread.currentThread().getContextClassLoader().getResource("person-data.csv");

        assertEquals(csvParserService.readFile(url.getPath()).size(), 5);
    }

    @Test(expected = IOException.class)
    public void testFileNotFound() throws Exception {
        csvParserService.readFile("~filenotfound~");
    } */
}
