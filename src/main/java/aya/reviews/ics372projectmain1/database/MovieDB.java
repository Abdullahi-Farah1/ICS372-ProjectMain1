package aya.reviews.ics372projectmain1.database;

import aya.reviews.ics372projectmain1.datamodels.Movie;
import aya.reviews.ics372projectmain1.datamodels.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class MovieDB extends AbstractDB<Movie>{
    private final Map<String, Movie> movieMap;
    public MovieDB(){
        this.movieMap = new HashMap<>();
    }

    public void putMovie(Movie movie){
        movieMap.put(movie.getMediaID(), movie);
        super.put(movie);
    }
    public Movie getMovie(String mediaID) throws SQLException {
        ResultSet results = super.get(mediaID);
        String id = String.valueOf(results.getInt("user_id"));
        int runtime = results.getInt("runtime");
        String description = results.getString("description");
        String name = results.getString("name");
        return new Movie(name, description, runtime);
    }


    public String buildPutQuery(Movie movie){
        return "PUT FROM MOVIE";
    }
    public String buildGetQuery(String movieID){
        return "GET FROM MOVIE";
    }
    public String buildDeleteQuery(){
        return "DELETE FROM MOVIE";
    }
    public String buildUpdateQuery(){
        return "UPDATE FROM MOVIE";
    }
}
