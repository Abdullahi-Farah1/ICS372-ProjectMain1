package aya.reviews.ics372projectmain1.view;

import aya.reviews.ics372projectmain1.MainApp;
import aya.reviews.ics372projectmain1.control.UserControl;
import aya.reviews.ics372projectmain1.datamodels.Movie;
import aya.reviews.ics372projectmain1.datamodels.Review;
import aya.reviews.ics372projectmain1.datamodels.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;

public class ReviewControllerUI {
    @FXML
    private TextArea reviewInput;
    @FXML
    private TextField ratingInput;

    public void reviewAndRate() throws IOException {
        Movie currentMovie = MainApp.getReviewController().getCurrentMovie();
        User currentUser = MainApp.getUserController().getCurrentUser();

        String reviewText = reviewInput.getText();
        int rating = Integer.parseInt(ratingInput.getText());
        Review review = new Review();
        review.setReviewDescription(reviewText);
        review.setStarRating(rating);
        review.setMediaID(currentMovie.getMediaID());
        review.setReviewID(String.valueOf((reviewText + currentMovie.getName()).hashCode()));
        review.setUserID(String.valueOf(currentUser.getUserID()));
        MainApp.reviewController.submitReview(review);
        MainApp.changeScene("afterLogin.fxml");
    }

    public void cancelButton(ActionEvent event) throws IOException {
        MainApp.changeScene("afterLogin.fxml");
    }

}
