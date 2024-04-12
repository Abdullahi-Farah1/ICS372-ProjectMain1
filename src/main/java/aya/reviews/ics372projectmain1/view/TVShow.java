package aya.reviews.ics372projectmain1.view;

import aya.reviews.ics372projectmain1.MainApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class TVShow {
    @FXML
    private Button review5;

    @FXML
    private Button rate5;

    public void logOut(ActionEvent event) throws IOException {
        MainApp s = new MainApp();
        s.changeScene("scene.fxml");

    }

    public void toMoviePage(ActionEvent event) throws IOException {
        MainApp s = new MainApp();
        s.changeScene("afterLogin.fxml");

    }

    @FXML
    private void handleReviewButtonClick() throws IOException {
        MainApp m = new MainApp();
        m.changeScene("review.fxml");
    }
}
