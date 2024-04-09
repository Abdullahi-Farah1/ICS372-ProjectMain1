package aya.reviews.ics372projectmain1.database;

import aya.reviews.ics372projectmain1.datamodels.TVShow;
import aya.reviews.ics372projectmain1.datamodels.User;

import java.util.HashMap;
import java.util.Map;

public class UserDB extends AbstractDB<User> {
    private final Map<Integer, User> userMap;
    public UserDB(){
        this.userMap = new HashMap<>();
    }

    public void putUser(User user){
        this.userMap.put(user.getUserID(), user);
        super.put(user);
    }

    public User getUser(Integer userID){
        User user = this.userMap.get(userID);
        if(user == null){
            return super.get(userID);
        }
        else{
            return user;
        }
    }
    public void deleteUser(Integer userID){
        this.userMap.remove(userID);
        super.delete(userID);
    }

    public boolean updateUser(Integer userID, User newUser){
        if(this.userMap.containsKey(userID)){
            this.userMap.remove(userID);
            this.userMap.put(userID, newUser);
            super.delete(userID);
            super.put(newUser);
            return true;
        }
        return false;
    }
    @Override
    public String buildGetQuery() {
        return "GET QUERY FROM USERDB";
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
