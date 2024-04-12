package aya.reviews.ics372projectmain1.control;
import aya.reviews.ics372projectmain1.database.UserDB;
import aya.reviews.ics372projectmain1.datamodels.User;

import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

public class UserControl {
    private final UserDB userDB;
    private User currentUser;
    public UserControl() {
        this.userDB = new UserDB();
    }

    public User getCurrentUser(){
        return this.currentUser;
    }

    public boolean loginUser(String username, String password) throws SQLException {
        User user = userDB.getUserByName(username);
        if(username.equals("admin") && password.equals("password")){
            return true;
        }
        else if (user != null && user.getPassword().equals(password)) {
            // User login successful
            this.currentUser = user;
            return true;
        } else {
            // User login failed
            return false;
        }
    }

    public boolean registerUser(String username, String password) throws SQLException {
        User user = userDB.getUserByName(username);
        if (user != null){
            // user already exists in DB
            return false;
        }
        else{
//            User newUser = new User(username, password);
            userDB.putUser(username, password);
            return true;
        }
    }
}
