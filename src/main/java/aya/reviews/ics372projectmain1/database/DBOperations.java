package aya.reviews.ics372projectmain1.database;

public interface DBOperations<T> {
    void put(T item);
    T get(Integer id);
    void delete(Integer id);
}