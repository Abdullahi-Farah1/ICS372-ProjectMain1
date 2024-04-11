package aya.reviews.ics372projectmain1.database;

import aya.reviews.ics372projectmain1.datamodels.TVShow;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;


public abstract class TVShowDB extends AbstractDB<TVShow>{
    private final Map<String, TVShow> showMap;
    public TVShowDB(){
        this.showMap = new HashMap<>();
    }

    public void putTVShow(TVShow show){
        this.showMap.put(show.getMediaID(), show);
        super.put(show);
    }
    public TVShow getTVShow(String mediaID){
        ResultSet results = super.get(mediaID);
        return new TVShow("", "", 2);

    }

    @Override
    public String buildPutQuery(TVShow show){
        return "PUT FROM TV";
    }
    @Override
    public String buildGetQuery(String showID) {
        return "GET FROM TV";
    }

    @Override
    public String buildDeleteQuery() {
        return "DELETE FROM TV";
    }

}
