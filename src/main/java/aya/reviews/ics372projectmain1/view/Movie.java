package aya.reviews.ics372projectmain1.view;

import aya.reviews.ics372projectmain1.MainApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;

import java.io.IOException;
import java.util.Optional;

public class Movie {
    @FXML
    private Button tvshow1;
    @FXML
    private Button review1;

    @FXML
    private Button rate1;

    @FXML
    private Button review2;

    @FXML
    private Button rate2;

    @FXML
    private Button review3;

    @FXML
    private Button rate3;


    @FXML
    private void handleReviewButtonClick() throws IOException {
        MainApp m = new MainApp();
        m.changeScene("review.fxml");
    }
    @FXML
    private void handleRateButtonClick() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Rate Movie");
        dialog.setHeaderText(null);
        dialog.setContentText("Please rate the movie (1 to 10):");

        Optional<String> result = dialog.showAndWait();
        result.ifPresent(rating -> {
            try {
                int ratingValue = Integer.parseInt(rating);
                if (ratingValue >= 1 && ratingValue <= 10) {
                    // Process the rating, e.g., save it to a database or display it

                    System.out.println("Rating submitted: " + ratingValue);
                } else {
                    // Show error message for invalid rating
                    System.out.println("Invalid rating. Please enter a number between 1 and 10.");
                }
            } catch (NumberFormatException e) {

                // Show error message for non-numeric input
                System.out.println("Invalid rating. Please enter a number between 1 and 10.");
            }
        });
    }

    public void nextPage(ActionEvent event) throws IOException {
        MainApp s = new MainApp();
        s.changeScene("tvshow.fxml");

    }


}
