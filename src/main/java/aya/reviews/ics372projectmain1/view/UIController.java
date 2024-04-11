package aya.reviews.ics372projectmain1.view;



import aya.reviews.ics372projectmain1.MainApp;
import aya.reviews.ics372projectmain1.control.ReviewControl;
import aya.reviews.ics372projectmain1.control.UserController;
import aya.reviews.ics372projectmain1.datamodels.Review;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class UIController {
    @FXML
    private TextArea reviewInput;
    @FXML
    private TextField ratingInput;
    @FXML
    private Button button;
    @FXML
    private Label wrongLogIn;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Button register1;

    private Map<String, String> registeredUsers; // Map to store registered users
    private final UserController userController;
    private final ReviewControl reviewControl;

    public UIController() {
        this.userController = new UserController();
        this.reviewControl = new ReviewControl();

    }

    @FXML
    public void userLogIn(ActionEvent event) throws IOException, SQLException {
        checkLogIn();
    }

    @FXML
    public void registerUser(ActionEvent event) throws IOException, SQLException {
        registerUser();
    }

    private void checkLogIn() throws IOException, SQLException {

        String enteredUsername = username.getText();
        String enteredPassword = password.getText();

        if (enteredUsername.isEmpty() || enteredPassword.isEmpty()) {
            wrongLogIn.setText("Please enter both username and password.");
        } else {
            boolean res = this.userController.loginUser(enteredUsername, enteredPassword);
            if (res) {
                wrongLogIn.setText("Login successful");
                MainApp m = new MainApp();
                m.changeScene("afterLogin.fxml");
            } else {
                wrongLogIn.setText("Incorrect login");
            }
        }
    }

    private void registerUser() throws SQLException {
        String enteredUsername = username.getText();
        String enteredPassword = password.getText();

        if (enteredUsername.isEmpty() || enteredPassword.isEmpty()) {
            wrongLogIn.setText("Please enter both username and password.");
        } else {
            // registerUser should probably not implicitly register the user, but i'm lazy
            boolean res = this.userController.registerUser(enteredUsername, enteredPassword);
            if (!res) {
                wrongLogIn.setText("User already registered. Please log in.");
            }
        }
    }

    public void reviewAndRate() {
        String reviewText = reviewInput.getText();
        String ratingText = ratingInput.getText();

        // Defaulting to -1 to indicate no rating.
        int rating = -1;
        String userID = userController.getCurrentUser().getUserID();
        String mediaID = "";
        try{
            rating = Integer.parseInt(ratingInput.getText());
            if (rating < 0 || rating > 10){
                // bad input
                System.out.println("Rating is not between 0 and 10 ");
                return;
            }
        }
        catch(Exception e){
            if (!ratingText.isEmpty()) {
                // bad input but NOT empty. Reject rating input.
                System.out.println("Rating is not numeric");
                return;
            }

        }
        System.out.println("Submitting review using rating " +  rating);
        Review review = new Review(userID, rating, reviewText, mediaID);
        this.reviewControl.submitReview(review, this.userController.getCurrentUser());
    }



    public void cancelButton(ActionEvent event) throws IOException {
        MainApp s = new MainApp();
        s.changeScene("afterLogin.fxml");
    }

}
