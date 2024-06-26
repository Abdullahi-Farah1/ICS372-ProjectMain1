package aya.reviews.ics372projectmain1.database;

import aya.reviews.ics372projectmain1.datamodels.TVShow;
import aya.reviews.ics372projectmain1.datamodels.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class UserDB extends AbstractDB<User> {

    public UserDB(){

    }

    public void putUser(String name, String password){
        String query = String.format("INSERT INTO Users(displayName, password) VALUES ('%s', '%s')", name, password);
        super.put(query);
    }
    public User getUserByName(String username) throws SQLException {
        String query = String.format("SELECT * FROM Users WHERE displayName = '%s'", username);
        ResultSet res = super.get(query);

        String name = "empty";
        String password = "empty";
        int id = -1;

        while (res.next()) {

            name = res.getString("displayName");
            password = res.getString("password");
            id = res.getInt("user_id");
        }
        res.close();

        return new User(name, password, id);
    }
    public User getUserByID(String userID) throws SQLException {
        String query = String.format("SELECT * FROM Users WHERE user_id = '%s'", userID);
        ResultSet res = super.get(query);

        String name = "empty";
        String password = "empty";
        int id = -1;

        while (res.next()) {

            name = res.getString("displayName");
            password = res.getString("password");
            id = res.getInt("user_id");
        }
        res.close();
        
        return new User(name, password, id);
    }
}
