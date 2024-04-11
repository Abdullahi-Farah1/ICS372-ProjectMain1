package aya.reviews.ics372projectmain1.database;

import java.sql.ResultSet;

public interface DBOperations<T> {
    void put(T item);
    ResultSet get(String id);
}