package aya.reviews.ics372projectmain1.datamodels;


public class Review {

    public Review(){}
    public Review(String userID, int starRating, String reviewDescription, String mediaID, String reviewID){
        this.userID = userID;
        this.starRating = starRating;
        this.reviewDescription = reviewDescription;
        this.mediaID =  mediaID;
        this.reviewID = reviewID;
    }
    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public int getStarRating() {
        return starRating;
    }

    public void setStarRating(int starRating) {
        this.starRating = starRating;
    }

    public String getReviewDescription() {
        return reviewDescription;
    }

    public void setReviewDescription(String reviewDescription) {
        this.reviewDescription = reviewDescription;
    }

    public String getMediaID() {
        return mediaID;
    }

    public void setMediaID(String mediaID) {
        this.mediaID = mediaID;
    }

    public String getReviewID() {
        return reviewID;
    }

    public void setReviewID(String reviewID) {
        this.reviewID = reviewID;
    }

    private String userID;
    private int starRating;
    private String reviewDescription;
    private String mediaID;

    private String reviewID;

    @Override
    public String toString() {
        return String.format("UserID: %s, starRating: %s, reviewDesc: %s, mediaID: %s, reviewID: %s", userID, starRating, reviewDescription, mediaID, reviewID);
    }
}
