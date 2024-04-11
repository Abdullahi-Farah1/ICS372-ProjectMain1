package aya.reviews.ics372projectmain1.view;

import aya.reviews.ics372projectmain1.MainApp;
import aya.reviews.ics372projectmain1.datamodels.Review;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;

public class ReviewController {
    @FXML
    private TextArea reviewInput;
    @FXML
    private TextField ratingInput;

    public void reviewAndRate() throws IOException {
        String reviewText = reviewInput.getText();
        int rating = Integer.parseInt(ratingInput.getText());
        Review review = new Review();
        review.setReviewDescription(reviewText);
        review.setStarRating(rating);
        review.setReviewID("FIX REVIEW ID");
        review.setMediaID("FIX MEDIA ID");
        review.setUserID("FIX USER ID");
        MainApp.reviewController.submitReview(review);
        MainApp.changeScene("afterLogin.fxml");
    }

    public void cancelButton(ActionEvent event) throws IOException {
        MainApp.changeScene("afterLogin.fxml");
    }

}
