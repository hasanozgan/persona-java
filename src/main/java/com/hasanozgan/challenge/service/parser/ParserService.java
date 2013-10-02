package com.hasanozgan.challenge.service.parser;

import com.hasanozgan.challenge.model.People;

import java.io.IOException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: hasanozgan
 * Date: 10/2/13
 * Time: 7:34 PM
 * To change this template use File | Settings | File Templates.
 */
public interface ParserService {
    public People createPeople() throws IOException;
}
