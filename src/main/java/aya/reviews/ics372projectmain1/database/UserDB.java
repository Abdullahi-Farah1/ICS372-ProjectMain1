package aya.reviews.ics372projectmain1.database;

import aya.reviews.ics372projectmain1.datamodels.TVShow;
import aya.reviews.ics372projectmain1.datamodels.User;

import java.util.HashMap;
import java.util.Map;

public class UserDB extends AbstractDB<User> {
    private final Map<String, User> userMap;
    public UserDB(){
        this.userMap = new HashMap<>();
    }

    public void putUser(User user){
        this.userMap.put(user.getDisplayName(), user);
        super.put(user);
    }
    public User getUserByName(String username){
        User user = this.userMap.get(username);
        if(user == null){
            return super.get(username);
        }
        else{
            return user;
        }
    }
    public User getUser(String userID){
        User user = this.userMap.get(userID);
        if(user == null){
            return super.get(userID);
        }
        else{
            return user;
        }
    }
    public void deleteUser(String username){
        this.userMap.remove(username);
        super.delete(username);
    }

    public boolean updateUser(String userID, User newUser){
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
