package aya.reviews.ics372projectmain1.database;

import aya.reviews.ics372projectmain1.datamodels.Movie;
import aya.reviews.ics372projectmain1.datamodels.Review;

import javax.xml.transform.Result;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        String query = String.format("INSERT INTO Reviews(user_id, media_id, rating, review_text) VALUES (%s,%s,%s,'%s')",userID, mediaID, rating, reviewText);
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

    public ArrayList<Review> getReviewsForMedia(String id) throws SQLException {
        String query = String.format("SELECT * FROM Reviews WHERE media_id = '%s';", id);
        ResultSet resultSet = super.get(query);

        ArrayList<Review> reviewList = new ArrayList<>();

        while (resultSet.next()) {
            String reviewID = resultSet.getString("review_id");
            String userID = resultSet.getString("user_id");
            String mediaID = resultSet.getString("media_id");
            String rating = resultSet.getString("rating");
            String reviewText = resultSet.getString("review_text");


            Review review = new Review(userID, Integer.valueOf(rating), reviewText, mediaID, reviewID);
            reviewList.add(review);

        }
        resultSet.close();
        return reviewList;

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

}
