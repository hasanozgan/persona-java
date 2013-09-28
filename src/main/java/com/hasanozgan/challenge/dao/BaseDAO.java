package com.hasanozgan.challenge.dao;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.DatastoreImpl;
import com.google.code.morphia.Morphia;
import com.google.code.morphia.dao.BasicDAO;
import com.google.code.morphia.logging.MorphiaLoggerFactory;
import com.google.code.morphia.mapping.Mapper;
import com.mongodb.DBObject;
import com.mongodb.Mongo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: hasan.ozgan
 * Date: 9/25/13
 * Time: 4:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class BaseDAO<K, T> extends BasicDAO<K, T> {

    protected BaseDAO(Datastore datastore) {
        super(datastore);
    }

    public void saveAll(Collection<K> dataList) throws Exception {
        getCollection().insert(toDBObjectCollection(dataList));
    }

    public List<DBObject> toDBObjectCollection(Collection<K> records)
            throws Exception {

        Mapper mapper = ((DatastoreImpl)getDatastore()).getMapper();
        List<DBObject> dbObjects = new ArrayList<DBObject>();

        for (K record : records) {
            dbObjects.add(mapper.toDBObject(record));
        }

        return dbObjects;
    }
}
