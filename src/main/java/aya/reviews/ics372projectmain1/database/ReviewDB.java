package aya.reviews.ics372projectmain1.database;

import aya.reviews.ics372projectmain1.datamodels.Review;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ReviewDB extends AbstractDB<Review>{
    public ReviewDB(){

    }

    public void putReview(Review review){
        String userID = review.getUserID();
        String reviewID = review.getReviewID();
        String mediaID = review.getMediaID();
        int rating = review.getStarRating();
        String reviewText = review.getReviewDescription();
        String query = String.format("INSERT INTO Reviews(user_id, media_id, rating, review_text, review_id) VALUES (%s,%s,%s,%s,'%s')",userID, mediaID, rating, reviewText,reviewID);
        super.put(query);
    }

    public Review getReview(String reviewID){
        Review r =  new Review();
        ResultSet s =  super.get(reviewID);
        return r;
    }


    public ArrayList<Review> getAllReviews(){
        return new ArrayList<>();
    }

    public ArrayList<Review> getReviewsForMedia(String id){
        ArrayList<Review> reviews = this.getAllReviews();
        ArrayList<Review> res = new ArrayList<Review>();
        for (Review r : reviews){
            if(r.getMediaID().equals(id)){
                res.add(r);
            }
        }
        return  res;
    }
    public ArrayList<Review> getReviewsForUser(String userID) {
        ArrayList<Review> reviews = this.getAllReviews();
        ArrayList<Review> res = new ArrayList<Review>();
        for (Review r : reviews){
            if(r.getUserID().equals(userID)){
                res.add(r);
            }
        }
        return  res;
    }


    @Override
    public String buildGetQuery() {
        return "GET QUERY FROM REVIEWDB";
    }
}
