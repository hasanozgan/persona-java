package com.hasanozgan.challenge.utils;

import com.hasanozgan.challenge.service.parser.CSVParserService;
import com.hasanozgan.challenge.service.parser.ParserService;
import com.hasanozgan.challenge.service.parser.XMLParserService;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: hasanozgan
 * Date: 10/2/13
 * Time: 7:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class ParserServiceFactory {

    public static ParserService createParserService(String filePath) throws IOException {
        if (filePath.contains(".xml")) {
            return new XMLParserService(filePath);
        }
        else if (filePath.contains(".csv")) {
            return new CSVParserService(filePath);
        }

        throw new IOException("File not found");
    }
}
