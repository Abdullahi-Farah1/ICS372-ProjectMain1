package aya.reviews.ics372projectmain1.view;

import aya.reviews.ics372projectmain1.MainApp;
import aya.reviews.ics372projectmain1.datamodels.Movie;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
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

    private int computeFontSizeForTitle(int titleLength){
        // this is an unhinged way to implement variable font size.
        double a = 100;
        double b = 0;   // lower val -> bigger size
        double c = -50;
        double x = titleLength;
        double y = a / (Math.log10(x + b)) + c;
        return (int) y;
    }


    private void setFont(int size, Text t){
        Font f = new Font(size);
        t.setFont(f);
    }
    public void updateTitles(){
        int titleLength = movie1.getName().length();
        System.out.println("Title: "+movie1.getName());
        int fontSize = computeFontSizeForTitle(titleLength);
        System.out.println("len: " + titleLength);
        System.out.println("Size: " + fontSize);
        setFont(fontSize, title1);
        title1.setText(movie1.getName());

        description1.setText(movie1.getDescription());

        titleLength = movie2.getName().length();
        fontSize = computeFontSizeForTitle(titleLength);
        setFont(fontSize, title2);
        title2.setText(movie2.getName());
        description2.setText(movie2.getDescription());

        titleLength = movie3.getName().length();
        fontSize = computeFontSizeForTitle(titleLength);
        setFont(fontSize, title3);
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
