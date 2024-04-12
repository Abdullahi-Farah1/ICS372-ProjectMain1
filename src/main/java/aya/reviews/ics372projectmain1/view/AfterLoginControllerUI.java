package aya.reviews.ics372projectmain1.view;

import aya.reviews.ics372projectmain1.MainApp;
import aya.reviews.ics372projectmain1.datamodels.Movie;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class AfterLoginControllerUI implements Initializable {
    @FXML
    private Button review1;
    @FXML
    private Button review2;
    @FXML
    private Button review3;

    private Movie movie1;
    private Movie movie2;
    private Movie movie3;

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

    private void handleReview(Movie m) throws IOException {
        // yuck
        MainApp.reviewController.setCurrentMovie(m);
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
    public void updateTitles(){
        title1.setText(movie1.getName());
        description1.setText(movie1.getDescription());
        title2.setText(movie2.getName());
        description2.setText(movie2.getDescription());
        title3.setText(movie3.getName());
        description3.setText(movie3.getDescription());
    }
    @FXML
    private void nextPageHandler(ActionEvent actionEvent) {
        populateMovies();
    }

    @FXML
    private void searchHandler(ActionEvent actionEvent) {
        searchField.setText("Click");
    }

    private void updateMovies(){
        List<Movie> movies = MainApp.fetchThree();
        if (movies == null){
            return;
        }else{
            movie1 = movies.get(0);
            movie2 = movies.get(1);
            movie3 = movies.get(2);
        }
    }

    public void populateMovies(){
        System.out.println("Populating movies...");
        this.updateMovies();
        updateTitles();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        populateMovies();
    }
}
