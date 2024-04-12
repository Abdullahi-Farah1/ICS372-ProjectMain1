package aya.reviews.ics372projectmain1.database;

import aya.reviews.ics372projectmain1.datamodels.Movie;

import javax.xml.transform.Result;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MovieDB extends AbstractDB<Movie>{
    private final Map<String, Movie> movieMap;
    public MovieDB(){
        this.movieMap = new HashMap<>();
    }

    public void putMovie(Movie movie){

        super.put("FIX MOVIE QUERY IN MOVIEDB");
    }
    public Movie getMovie(String mediaID){
        ResultSet res = super.get(mediaID);
        Movie m = new Movie();
        return m;

//        return super.get(mediaID);
    }

    public ArrayList<Movie> getAllMovies() throws SQLException {
        String query = "SELECT * FROM Media";
        ArrayList<Movie> mediaList = new ArrayList<>();
        ResultSet resultSet = super.get(query);
        while (resultSet.next()) {
            String name = resultSet.getString("title");
            String description = resultSet.getString("description");
            int id = resultSet.getInt("media_id");
            Movie media = new Movie(name, description, id);
            mediaList.add(media);
        }
        System.out.println(mediaList.size());
        System.out.println(mediaList.size());
        System.out.println(mediaList.size());

        return mediaList;
    }

    public String buildPutQuery(){
        return "PUT FROM MOVIE";
    }
    public String buildGetQuery(){
        return "GET FROM MOVIE";
    }
}
