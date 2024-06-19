package aya.reviews.ics372projectmain1.view;

import aya.reviews.ics372projectmain1.HelloApplication;
import aya.reviews.ics372projectmain1.datamodels.Movie;
import aya.reviews.ics372projectmain1.datamodels.Review;
import aya.reviews.ics372projectmain1.datamodels.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ReviewControllerUI implements Initializable {
    @FXML
    private TextArea reviewInput;
    @FXML
    private TextField ratingInput;

    @FXML
    private Label reviewMovieTitle;

    @FXML
    private Label reviewByUser;
    @FXML
    private TextArea discoverReviewText;



    private int reviewPointer = 0;

    private ArrayList<Review> currentReviewCache;
    public void reviewAndRate() throws IOException {
        Movie currentMovie = HelloApplication.getReviewController().getCurrentMovie();
        User currentUser = HelloApplication.getUserController().getCurrentUser();

        String reviewText = reviewInput.getText();
        int rating = Integer.parseInt(ratingInput.getText());
        Review review = new Review();
        review.setReviewDescription(reviewText);
        review.setStarRating(rating);
        review.setMediaID(currentMovie.getMediaID());
        review.setReviewID(String.valueOf((reviewText + currentMovie.getName()).hashCode()));
        review.setUserID(String.valueOf(currentUser.getUserID()));
        HelloApplication.reviewController.submitReview(review);
    }

    public void cancelButton(ActionEvent event) throws IOException {
        HelloApplication.changeScene("afterLogin.fxml");
    }

    public void nextReviewHandler(ActionEvent event) throws IOException{
        this.reviewPointer += 1;
        setUserReview();
    }

    public void previousReviewHandler(ActionEvent event) throws IOException{
        this.reviewPointer -= 1;
        setUserReview();
    }
    private void setUserReview(){
        try{
            // not a good way to handle this
            Review curReview = this.currentReviewCache.get(this.reviewPointer);
            this.discoverReviewText.setText(curReview.getReviewDescription());
            String userID = curReview.getUserID();
            User user = HelloApplication.getUserController().getUserByID(userID);
            String username = user.getDisplayName();
            this.reviewByUser.setText("Review by user " + username);
        }catch (IndexOutOfBoundsException e){
            return;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Movie currentMovie = HelloApplication.currentMovie;
        this.reviewMovieTitle.setText(currentMovie.getName());
        try {
            this.currentReviewCache = HelloApplication.getReviewsForMovie(currentMovie.getName());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.setUserReview();
        setUserReview();
    }
}
