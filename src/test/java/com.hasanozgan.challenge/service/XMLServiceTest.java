package com.hasanozgan.challenge.service;

import com.hasanozgan.challenge.service.parser.CSVParserService;
import com.hasanozgan.challenge.service.parser.XMLParserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.net.URL;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: hasanozgan
 * Date: 9/28/13
 * Time: 10:14 AM
 * To change this template use File | Settings | File Templates.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class XMLServiceTest {

    @Test
    public void testReadFile() throws Exception {
        URL url = Thread.currentThread().getContextClassLoader().getResource("person-data.xml");
        XMLParserService xmlParserService = new XMLParserService(url.getPath());

        assertEquals(xmlParserService.createPeople().size(), 5);
    }

    @Test(expected = IOException.class)
    public void testFileNotFound() throws Exception {
        XMLParserService xmlParserService = new XMLParserService("~filenotfound~");

        xmlParserService.createPeople();
    }
}
