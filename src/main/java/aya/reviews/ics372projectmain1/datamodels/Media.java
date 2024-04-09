
package aya.reviews.ics372projectmain1.datamodels;
import aya.reviews.ics372projectmain1.database.AbstractDB;
import java.util.ArrayList;

abstract class Media{
    private ArrayList<Review> reviews;
    private String name;
    private String description;
    private String mediaID;
    public Media(String name, String description){
        setName(name);
        setDescription(description);
    }
    public Media(){
        System.out.println("Default Constructor");
    }
    public float getAverageStarRating(){
        float avg = 0;
        int len = this.reviews.size();
        for (Review r : this.reviews){
            avg += r.getStarRating();
        }
        return  (avg/len);
    }
    public ArrayList<Review> getReviews() {
        return reviews;
    }
    public void setReviews(ArrayList<Review> reviews) {
        this.reviews = reviews;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMediaID() {
        return mediaID;
    }

    public void setMediaID(String mediaID) {
        this.mediaID = mediaID;
    }
}