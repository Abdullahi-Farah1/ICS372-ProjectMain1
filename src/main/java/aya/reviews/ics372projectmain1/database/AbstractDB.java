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
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private ResultSet GetDB(String query) {
        ResultSet resultSet = null;
        Statement statement = null;
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            if (!resultSet.isBeforeFirst()) {
                System.out.println("No user found with username 'austin'.");
                return null;
            } else if (resultSet.isClosed())
                System.out.println("ResultSet is closed...?");
            return resultSet;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public abstract String buildGetQuery(String itemID);
    public abstract String buildPutQuery(T item);

    @Override
    public void put(T item){
        String query = this.buildPutQuery(item);
        this.InsertDB(query);
        System.out.println("Putting to DB using query, " + query);
    }
    @Override
    public ResultSet get(String itemID){
        String query = this.buildGetQuery(itemID);
        ResultSet results = this.GetDB(query);
        System.out.println("Putting to DB using query, " + query);
        return results;
    }
}
