package com.hasanozgan.challenge.dao;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.DatastoreImpl;
import com.google.code.morphia.Morphia;
import com.google.code.morphia.dao.BasicDAO;
import com.google.code.morphia.mapping.Mapper;
import com.google.code.morphia.query.Query;
import com.google.code.morphia.query.QueryResults;
import com.hasanozgan.challenge.model.Person;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.WriteResult;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: hasan.ozgan
 * Date: 9/25/13
 * Time: 4:17 PM
 * To change this template use File | Settings | File Templates.
 */

public class PersonDAO extends BaseDAO<Person, ObjectId> {

    protected PersonDAO(Datastore datastore) {
        super(datastore);
    }

    @Override
    public void saveAll(Collection<Person> dataList) throws Exception {
        for (Person record : dataList) {
            DBObject person = new BasicDBObject("name", record.getName());
            person.put("lastName", record.getLastName());

            //DBObject phones = new BasicDBObject("$pushAll", new BasicDBObject("phones", record.getPhones()));
            DBObject phones = new BasicDBObject("$set", new BasicDBObject("phones", record.getPhones()));

            getCollection().update(person, phones, true, true);
        }
    }

    public QueryResults<Person> findByName(String name) {
        Query q = getDatastore().createQuery(Person.class).field("name").containsIgnoreCase(name);
        return find(q);
    }
}
