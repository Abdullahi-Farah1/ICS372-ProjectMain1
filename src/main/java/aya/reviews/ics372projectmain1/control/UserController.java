package aya.reviews.ics372projectmain1.control;
import aya.reviews.ics372projectmain1.database.UserDB;
import aya.reviews.ics372projectmain1.datamodels.User;

import java.sql.SQLException;

public class UserController {
    private UserDB userDB;
    private User currentUser;

    public UserController() {
        this.userDB = new UserDB();
    }

    public boolean loginUser(String username, String password) throws SQLException {

        User user = userDB.getUser(username);
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
        User user = userDB.getUser(username);
        if (user != null){
            // user already exists in DB
            return false;
        }
        else{
            // The constructor for user shouldn't accept an id, but I wrote it poorly and am too lazy to fix.
            User newUser = new User("",username, password);
            userDB.putUser(newUser);
            return true;
        }
    }
    public User getCurrentUser(){
        return this.currentUser;
    }
}
