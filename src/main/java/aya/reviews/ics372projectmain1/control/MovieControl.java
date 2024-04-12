package aya.reviews.ics372projectmain1.control;

import aya.reviews.ics372projectmain1.database.MovieDB;
import aya.reviews.ics372projectmain1.datamodels.Movie;

import java.util.ArrayList;

public class MovieControl {
    private final MovieDB movieDB;
    public MovieControl(MovieDB db){
        this.movieDB = db;
    }
    public ArrayList<Movie> getAllMovies(){
        return this.movieDB.getAllMovies();
    }
}
