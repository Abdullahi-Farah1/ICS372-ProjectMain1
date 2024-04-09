package aya.reviews.ics372projectmain1;

import aya.reviews.ics372projectmain1.database.MovieDB;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


import aya.reviews.ics372projectmain1.datamodels.Movie;
public class MainApp extends Application {
    private static Stage stg;
    @Override
    public void start(Stage stage) throws IOException {
        MovieDB movieDB = new MovieDB();
        Movie m =  new Movie("a", "a", 2);
        movieDB.putMovie(m);

        //        stg = stage;
//
//        Parent root = FXMLLoader.load(getClass().getResource("scene.fxml"));
//        Scene scene = new Scene(root, 600, 400);
//        stage.setTitle("AYA Reviews");
//        stage.setScene(scene);
//        stage.show();
    }

    public void changeScene(String fxml) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource(fxml));
        Scene scen = new Scene(pane, 900, 700);
        stg.setScene(scen);
    }

    public static void main(String[] args) {
        launch();
    }
}