package aya.reviews.ics372projectmain1.database;
public abstract class AbstractDB<T> implements DBOperations<T> {
    public void put(T item){
        System.out.println("putting to DB");
    }
    public T get(String id){
        System.out.println("getting to DB");
        return null;
    }
    public void delete(String id){
        System.out.println("deleting to DB");
    }
    public void update(String id, T newItem){
        System.out.println("updating to DB");
    }
}
