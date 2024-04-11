package aya.reviews.ics372projectmain1.control;

import aya.reviews.ics372projectmain1.database.ReviewDB;
import aya.reviews.ics372projectmain1.datamodels.Review;
import aya.reviews.ics372projectmain1.datamodels.User;

import java.util.ArrayList;

public class ReviewControl {
    private final ReviewDB reviewDB;
    public ReviewControl(){
        this.reviewDB = new ReviewDB();
    }

    public void submitReview(Review review, User user){
        this.reviewDB.putReview(review);
        user.addSingleReview(review);
    }
    public ArrayList<Review> getMediaReviews(String mediaID){
        return this.reviewDB.getReviewsForMedia(mediaID);
    }

    public ArrayList<Review> getUserReviews(String userID){
        return this.reviewDB.getReviewsForUser(userID);
    }
}
