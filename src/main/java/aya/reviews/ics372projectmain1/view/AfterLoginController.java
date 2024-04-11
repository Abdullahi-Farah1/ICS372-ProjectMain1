package aya.reviews.ics372projectmain1.view;

import aya.reviews.ics372projectmain1.MainApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.Optional;

public class AfterLoginController {
    @FXML
    private Button review1;
    @FXML
    private Button review2;
    @FXML
    private Button review3;

    private AfterLoginController movie1;
    private AfterLoginController movie2;
    private AfterLoginController movie3;

    @FXML
    private Text title1;
    @FXML
    private Text title2;
    @FXML
    private Text title3;
    @FXML
    private TextArea description1;
    @FXML
    private TextArea description2;
    @FXML
    private TextArea description3;

    @FXML
    private Button searchButton;
    @FXML
    private TextField searchField;

    private void handleReview(AfterLoginController m) throws IOException {
        MainApp.changeScene("review.fxml");
    }

    public void nextPage(ActionEvent event) throws IOException {;
        MainApp.changeScene("tvshow.fxml");
    }

    public void reviewClick1(ActionEvent actionEvent) throws IOException {
        System.out.println("reviewclick1");
        this.title1.setText("click");
        this.description1.setText("click");
        this.handleReview(this.movie1);
    }

    public void reviewClick2(ActionEvent actionEvent) throws IOException {
        System.out.println("reviewclick2");
        this.title2.setText("click");
        this.description2.setText("click");
        this.handleReview(this.movie2);
    }

    public void reviewClick3(ActionEvent actionEvent) throws IOException {
        System.out.println("reviewclick3");
        this.title3.setText("click");
        this.description3.setText("click");
        this.handleReview(this.movie3);
    }

    public void nextPageHandler(ActionEvent actionEvent) {
        System.out.println("nextPageHandler");
    }

    public void searchHandler(ActionEvent actionEvent) {
        searchField.setText("Click");

    }
}
