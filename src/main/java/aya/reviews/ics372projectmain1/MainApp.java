package aya.reviews.ics372projectmain1;

import aya.reviews.ics372projectmain1.control.MovieControl;
import aya.reviews.ics372projectmain1.control.ReviewControl;
import aya.reviews.ics372projectmain1.control.UserControl;
import aya.reviews.ics372projectmain1.datamodels.Review;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import aya.reviews.ics372projectmain1.datamodels.Movie;
public class MainApp extends Application {
    private static Stage stg;
    public static UserControl userController;
    public static ReviewControl reviewController;
    public static MovieControl movieControl;
    public static Movie currentMovie;

    private static ArrayList<Movie> movieCache;
    private static int pointer = 0;
    public static List<Movie> forwardThreeMovies(){
        try {
            List<Movie> movies = movieCache.subList(pointer, pointer + 3);
            pointer += 3;
            return movies;
        }catch(IndexOutOfBoundsException e){
            System.out.println("No more movies in cache");
            pointer -= 3;
            return null;
        }
    }
    public static List<Movie> backwardThreeMovies(){
        try {
            List<Movie> movies = movieCache.subList(pointer, pointer + 3);
            pointer -= 3;
            return movies;
        }catch(IndexOutOfBoundsException e){
            System.out.println("No more movies in cache");
            pointer += 3;
            return null;
        }
    }

    public static ArrayList<Review> getReviewsForMovie(String movieName) throws SQLException {
        Movie movie = movieControl.getMovie(movieName);
        String id = movie.getMediaID();
        return reviewController.getMediaReviews(id);
    }

    @Override
    public void start(Stage stage) throws IOException, SQLException {
        userController = new UserControl();
        reviewController =  new ReviewControl();
        movieControl = new MovieControl();
        movieCache = movieControl.getAllMovies();

        stg = stage;

        Parent root = FXMLLoader.load(getClass().getResource("scene.fxml"));
        Scene scene = new Scene(root, 1000, 600);
        stage.setTitle("AYA Reviews");
        stage.setScene(scene);
        stage.show();
    }

    public static void changeScene(String fxml) throws IOException {
        Parent pane = FXMLLoader.load(MainApp.class.getResource(fxml));
        stg.getScene().setRoot(pane);
    }

    public static UserControl getUserController() {
        return userController;
    }

    public static ReviewControl getReviewController() {
        return reviewController;
    }

    public static  MovieControl getMovieController(){return  movieControl;}

    public static ArrayList<Movie> getAllMovies(){
        return movieCache;
    }

    public static void main(String[] args) {
        launch();
    }
}