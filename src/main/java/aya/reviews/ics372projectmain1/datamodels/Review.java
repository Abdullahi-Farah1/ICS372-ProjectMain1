package aya.reviews.ics372projectmain1.datamodels;


public class Review {
    public Review(String userID, int starRating, String reviewDescription, String mediaID, String reviewID){
        this.userID = userID;
        this.starRating = starRating;
        this.reviewDescription = reviewDescription;
        this.mediaID = mediaID;
        this.reviewID = reviewID;

    };
    public String getUserID() {
        return userID;
    }
    public int getStarRating() {
        return starRating;
    }
    public String getReviewDescription() {
        return reviewDescription;
    }
    public String getMediaID() {
        return mediaID;
    }
    public String getReviewID() {
        return reviewID;
    }

    private final String userID;
    private final int starRating;
    private final String reviewDescription;
    private final String mediaID;
    private final String reviewID;
}
