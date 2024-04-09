package aya.reviews.ics372projectmain1.database;

import aya.reviews.ics372projectmain1.datamodels.Movie;

import java.util.HashMap;
import java.util.Map;

public class MovieDB extends AbstractDB<Movie>{
    private final Map<Integer, Movie> movieMap;
    public MovieDB(){
        this.movieMap = new HashMap<>();
    }

    public void putMovie(Movie movie){
        movieMap.put(movie.getMediaID(), movie);
        super.put(movie);
    }
    public Movie getMovie(Integer mediaID){
        Movie mov = movieMap.get(mediaID);
        if (mov == null){
            return super.get(mediaID);
        }else{
            return mov;
        }
    }

    public void deleteMovie(Integer mediaID){
        movieMap.remove(mediaID);
        super.delete(mediaID);
    }

    public boolean updateMovie(Integer mediaID, Movie newMovie){
        if (movieMap.containsKey(mediaID)) {
            movieMap.put(mediaID, newMovie);
            super.delete(mediaID);
            super.put(newMovie);
            return true;
        }
        return false;
    }

    public String buildPutQuery(){
        return "PUT FROM MOVIE";
    }
    public String buildGetQuery(){
        return "GET FROM MOVIE";
    }
    public String buildDeleteQuery(){
        return "DELETE FROM MOVIE";
    }
    public String buildUpdateQuery(){
        return "UPDATE FROM MOVIE";
    }
}
