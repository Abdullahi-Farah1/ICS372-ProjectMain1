package aya.reviews.ics372projectmain1.database;

import aya.reviews.ics372projectmain1.datamodels.TVShow;

import java.util.HashMap;
import java.util.Map;


public abstract class TVShowDB extends AbstractDB<TVShow>{

    public TVShowDB(){
    }

    public void putTVShow(TVShow show){
        super.put("FIX SHOW QUERY IN TVSHOWDB");
    }
    public TVShow getTVShow(String mediaID){

//        return super.get(mediaID);
        return new TVShow();
    }

    @Override
    public String buildPutQuery(){
        return "PUT FROM TV";
    }
    @Override
    public String buildGetQuery() {
        return "GET FROM TV";
    }
}
