package com.hasanozgan.challenge.service;

import com.hasanozgan.challenge.model.Person;
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
 * Date: 9/27/13
 * Time: 10:05 AM
 * To change this template use File | Settings | File Templates.
 */
@Component
public class CSVService {
    public List<String> readFile(String csvFile) throws IOException {
        List<String> lines = new ArrayList<String>();
        String line = "";

        BufferedReader br = new BufferedReader(new FileReader(csvFile));
        while ((line = br.readLine()) != null) {
            lines.add(line);
        }

        br.close();

        return lines;
    }
}
