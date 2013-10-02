package com.hasanozgan.challenge.service.parser;

import com.hasanozgan.challenge.model.People;
import com.hasanozgan.challenge.model.Person;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: hasan.ozgan
 * Date: 9/27/13
 * Time: 10:05 AM
 * To change this template use File | Settings | File Templates.
 */
public class CSVParserService implements ParserService {
    private String filePath;

    public CSVParserService(String filePath) {
        this.filePath = filePath;
    }

    private Set<String> readFile() throws IOException {
        Set<String> lines = new HashSet<String>();
        String line = "";

        BufferedReader br = new BufferedReader(new FileReader(filePath));
        while ((line = br.readLine()) != null) {
            lines.add(line);
        }

        br.close();

        return lines;
    }

    @Override
    public People createPeople() throws IOException {
        Set<String> lines = readFile();
        People people = new People();

        for (String line : lines) {
            String[] fields = line.split(",");
            if (fields.length == 3) {
                people.addPerson(fields[0], fields[1], fields[2]);
            }
        }

        return people;
    }
}
