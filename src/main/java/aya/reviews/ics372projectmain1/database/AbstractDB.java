package aya.reviews.ics372projectmain1.database;
import aya.reviews.ics372projectmain1.datamodels.Movie
public abstract class AbstractDB<T> implements DBOperations<T> {
    /*
     * This is the template method.
     * */
    public static String buildPutQuery() {
        return null;
    }

    public abstract String buildGetQuery();
    public abstract String buildDeleteQuery();
    public abstract String buildUpdateQuery();

    public void put(T item){
        String query = Movie.buildPutQuery();
        System.out.println("Putting to DB using query, " + query);
    }
    public T get(String id){
        String query = this.buildGetQuery();
        System.out.println("Putting to DB using query, " + query);
        return null;
    }
    public void delete(String id){
        String query = this.buildDeleteQuery();
        System.out.println("Deleting from DB using query, " + query);
    }
    public void update(String id, T newItem){
        String query = this.buildUpdateQuery();
        System.out.println("Updating DB using query, " + query);
    }
}
