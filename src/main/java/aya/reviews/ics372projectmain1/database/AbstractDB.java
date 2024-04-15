package aya.reviews.ics372projectmain1.database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class AbstractDB<T> implements DBOperations<T> {
    /*
     * This is the template method.
     * */

    private static final String URL = "jdbc:sqlite:database.sqlite";

    private void insertDB(String query){
        System.out.println("Putting to DB using query: " + query);
        try {
            Statement statement = connect().createStatement();
            statement.executeUpdate(query);
//            connection.close();
//            statement.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    private ResultSet getDB(String query) {
        try{
            ResultSet res;
//            Connection connection = DriverManager.getConnection(URL);
            Statement statement = connect().createStatement();
            res = statement.executeQuery(query);

            System.out.println("Query successfully executed");
            return res;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void put(String query){
        this.insertDB(query);
    }
    @Override
    public ResultSet get(String query){
        System.out.println("Getting from Database using query: " + query);
        return this.getDB(query);
    }

    private static Connection c = null;
    public static Connection connect() throws Exception {

        if (c == null) {
            c = (Connection) DriverManager.getConnection(URL);
        } else {
            c.close();
            c = (Connection) DriverManager.getConnection(URL);
        }
        return c;
    }

}
