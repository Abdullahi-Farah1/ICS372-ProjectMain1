package aya.reviews.ics372projectmain1.database;
import aya.reviews.ics372projectmain1.datamodels.Movie;
public abstract class AbstractDB<T> implements DBOperations<T> {
    /*
     * This is the template method.
     * */
    public String buildPutQuery() {
        return null;
    }

    public abstract String buildGetQuery();
    public abstract String buildDeleteQuery();
    public abstract String buildUpdateQuery();
    @Override
    public void put(T item){
        String query = this.buildPutQuery();
        System.out.println("Putting to DB using query, " + query);
    }
    @Override
    public T get(String id){
        String query = this.buildGetQuery();
        System.out.println("Putting to DB using query, " + query);
        return null;
    }
    @Override
    public void delete(String id){
        String query = this.buildDeleteQuery();
        System.out.println("Deleting from DB using query, " + query);
    }
}
