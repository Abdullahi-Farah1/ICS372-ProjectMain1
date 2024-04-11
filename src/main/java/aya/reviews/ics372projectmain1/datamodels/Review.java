package aya.reviews.ics372projectmain1.datamodels;


public class Review {
    public Review(String userID, int starRating, String reviewDescription, String mediaID){
        this.userID = userID;
        this.starRating = starRating;
        this.reviewDescription = reviewDescription;
        // bad way to compute hash but whatever
        this.reviewID = String.valueOf((userID + reviewDescription + mediaID).hashCode());
        this.mediaID = mediaID;


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
