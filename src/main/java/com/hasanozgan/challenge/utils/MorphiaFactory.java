package com.hasanozgan.challenge.utils;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.Morphia;
import com.google.code.morphia.logging.MorphiaLoggerFactory;
import com.hasanozgan.challenge.model.Person;
import com.mongodb.Mongo;
import com.mongodb.MongoURI;


import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: hasan.ozgan
 * Date: 9/25/13
 * Time: 4:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class MorphiaFactory
{
    private String  uri;

    public Morphia getMorphiaInstance() {

        MorphiaLoggerFactory.reset();
        MorphiaLoggerFactory.registerLogger(SilentLogrFactory.class);

        Morphia morphia = new Morphia();

        // map all persistent classes in here!
        morphia.map(Person.class);

        return morphia;
    }

    public Datastore getDataStore() throws UnknownHostException {
        Logger.getLogger( "org.mongodb" ).setLevel(Level.OFF);

        Morphia morphia = getMorphiaInstance();
        MongoURI mongoClientURI = new MongoURI(uri);
        Mongo mongoClient = new Mongo(mongoClientURI);

        return morphia.createDatastore(mongoClient, mongoClientURI.getDatabase());
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
}
