package aya.reviews.ics372projectmain1.database;
import java.sql.ResultSet;
import aya.reviews.ics372projectmain1.datamodels.TVShow;
import aya.reviews.ics372projectmain1.datamodels.User;

import javax.xml.transform.Result;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class UserDB extends AbstractDB<User> {
    private final Map<String, User> userMap;
    public UserDB(){
        this.userMap = new HashMap<>();
    }

    public void putUser(User user){
        System.out.println("Putting new user to DB");
        super.put(user);
    }

    public User getUser(String userID) throws SQLException {
        ResultSet results = super.get(userID);
        if (results == null){
            return null;
        }
        System.out.println(results.toString());
        String id = String.valueOf(results.getInt("user_id"));
        String username = results.getString("displayName");
        String password = results.getString("password");
        return new User(id, username, password);

    }
    @Override
    public String buildPutQuery(User user) {
        return String.format("INSERT INTO Users (displayName, password)\n" +
                "VALUES ('%s', '%s');\n", user.getDisplayName(), user.getPassword());
    }
    @Override
    public String buildGetQuery(String displayName) {
        return String.format("SELECT * from Users WHERE displayName == '%s';", displayName);
    }

    @Override
    public String buildDeleteQuery() {
        return "DELETE QUERY FROM USERDB";
    }

    @Override
    public String buildUpdateQuery() {
        return "UPDATE QUERY FROM USERDB";
    }
}
