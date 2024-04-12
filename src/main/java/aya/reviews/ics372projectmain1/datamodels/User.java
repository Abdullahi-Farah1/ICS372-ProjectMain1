package aya.reviews.ics372projectmain1.datamodels;
import java.util.ArrayList;

public class User {
    public User(String displayName, String password, int id){
        setDisplayName(displayName);
        setPassword(password);
        setUserID(id);
    }
    public User(){
        System.out.println("Default Constructor");
    }


    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Review> getReviews() {
        return reviews;
    }

    public void setReviews(ArrayList<Review> reviews) {
        this.reviews = reviews;
    }

    public void addSingleReview(Review review){
        this.reviews.add(review);
    }

    private int userID;
    private String displayName;
    private String password;
    private ArrayList<Review> reviews;

}