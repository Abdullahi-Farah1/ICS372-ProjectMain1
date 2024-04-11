package aya.reviews.ics372projectmain1.database;
import aya.reviews.ics372projectmain1.datamodels.Movie;
import aya.reviews.ics372projectmain1.datamodels.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class AbstractDB<T> implements DBOperations<T> {
    /*
     * This is the template method.
     * */
    private final String URL = "jdbc:sqlite:database.sqlite";
    private void InsertDB(String query){
        try {
            Connection connection = DriverManager.getConnection(URL);
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);

            statement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public abstract String buildGetQuery();
    public abstract String buildPutQuery(T item);

    public abstract String buildDeleteQuery();
    public abstract String buildUpdateQuery();
    @Override
    public void put(T item){
        String query = this.buildPutQuery(item);
        this.InsertDB(query);
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
