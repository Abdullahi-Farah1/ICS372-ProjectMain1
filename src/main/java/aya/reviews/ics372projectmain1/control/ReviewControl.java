package aya.reviews.ics372projectmain1.control;

import aya.reviews.ics372projectmain1.database.ReviewDB;
import aya.reviews.ics372projectmain1.datamodels.Movie;
import aya.reviews.ics372projectmain1.datamodels.Review;

import java.util.ArrayList;

public class ReviewControl {
    private final ReviewDB reviewDB;
    private Movie currentMovie;
    public ReviewControl(){
        this.reviewDB = new ReviewDB();
    }

    public void submitReview(Review review){
        this.reviewDB.putReview(review);
    }
    public ArrayList<Review> getMediaReviews(String mediaID){
        return this.reviewDB.getReviewsForMedia(mediaID);
    }

    public ArrayList<Review> getUserReviews(String userID){
        return this.reviewDB.getReviewsForUser(userID);
    }

    // It sucks to use this singleton approach, but if called appropriately this _should_ be okay...
    // a production implementation should 100% not do this.
    public void setCurrentMovie(Movie m){
        this.currentMovie = m;
    }
    public Movie getCurrentMovie(){
        return this.currentMovie;
    }

}
