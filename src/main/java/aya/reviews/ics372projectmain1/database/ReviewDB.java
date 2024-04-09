package aya.reviews.ics372projectmain1.database;

import aya.reviews.ics372projectmain1.datamodels.Review;

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
        Review review = this.reviewMap.get(reviewID);
        if(review == null){
            return super.get(reviewID);
        }else{
            return review;
        }
    }

    public void deleteReview(String reviewID){
        this.reviewMap.remove(reviewID);
        super.delete(reviewID);
    }

    public boolean updateasReview(String reviewID, Review review){
        if(this.reviewMap.containsKey(reviewID)){
            this.reviewMap.remove(reviewID);
            this.reviewMap.put(reviewID, review);
            super.delete(reviewID);
            super.put(review);
            return true;
        }
        return false;
    }


    @Override
    public String buildGetQuery() {
        return "GET QUERY FROM REVIEWDB";
    }

    @Override
    public String buildDeleteQuery() {
        return "DELETE QUERY FROM REVIEWDB";
    }

    @Override
    public String buildUpdateQuery() {
        return "UPDATE QUERY FROM REVIEWDB";
    }
}
