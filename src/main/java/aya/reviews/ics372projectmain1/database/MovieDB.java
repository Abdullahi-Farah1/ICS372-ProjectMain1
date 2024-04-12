package aya.reviews.ics372projectmain1.database;

import aya.reviews.ics372projectmain1.datamodels.Movie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MovieDB extends AbstractDB<Movie>{
    private final Map<String, Movie> movieMap;
    public MovieDB(){
        this.movieMap = new HashMap<>();
    }

    public void putMovie(Movie movie){
        super.put(movie);
    }
    public Movie getMovie(String mediaID){
        return super.get(mediaID);
    }

    public ArrayList<Movie> getAllMovies(){

        super.get(query);
        return new ArrayList<>();
    }

    public String buildPutQuery(){
        return "PUT FROM MOVIE";
    }
    public String buildGetQuery(){
        return "GET FROM MOVIE";
    }
}
