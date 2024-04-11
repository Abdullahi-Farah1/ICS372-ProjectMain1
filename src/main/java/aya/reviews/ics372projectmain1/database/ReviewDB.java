package aya.reviews.ics372projectmain1.database;

import aya.reviews.ics372projectmain1.datamodels.Review;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ReviewDB extends AbstractDB<Review>{
    private final Map<String, Review> reviewMap;
    public ReviewDB(){
        this.reviewMap = new HashMap<>();
    }

    public void putReview(Review review){
        this.reviewMap.put(review.getReviewID(), review);
        super.put(review);
    }

    public Review getReview(String reviewID){
        ResultSet results = super.get(reviewID);
        return new Review("", -1, "", "");
    }


    public ArrayList<Review> getAllReviews(){
        return (ArrayList<Review>)(this.reviewMap.values());
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
    public String buildPutQuery(Review review) {
        return String.format("INSERT INTO Reviews (user_id, media_id, rating, review_text)\n" +
                "VALUES (%s, %s, %s, '%s');\n",
                Integer.valueOf(review.getUserID()),
                Integer.valueOf(review.getMediaID()),
                review.getStarRating(),
                review.getReviewDescription());
    }
    @Override
    public String buildGetQuery(String reviewID) {
        return "GET QUERY FROM REVIEWDB";
    }

}
