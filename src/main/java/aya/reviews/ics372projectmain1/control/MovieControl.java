package aya.reviews.ics372projectmain1.control;

import aya.reviews.ics372projectmain1.database.MovieDB;
import aya.reviews.ics372projectmain1.datamodels.Movie;
import aya.reviews.ics372projectmain1.datamodels.Review;

import java.sql.SQLException;
import java.util.ArrayList;

public class MovieControl {
    private final MovieDB movieDB;
    public MovieControl(){
        this.movieDB = new MovieDB();
    }
    public ArrayList<Movie> getAllMovies() throws SQLException {
        return this.movieDB.getAllMovies();
    }

    public Movie getMovie(String movieName) throws SQLException {
        return this.movieDB.getMovie(movieName);
    }
}
