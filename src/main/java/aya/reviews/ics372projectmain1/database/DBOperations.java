package aya.reviews.ics372projectmain1.database;

public interface DBOperations<T> {
    void put(T item);
    T get(String id);
    void delete(String id);
    void update(String id, T newItem);
}