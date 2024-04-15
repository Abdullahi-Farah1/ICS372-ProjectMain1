package aya.reviews.ics372projectmain1.database;

import aya.reviews.ics372projectmain1.datamodels.TVShow;

import java.util.HashMap;
import java.util.Map;


public abstract class TVShowDB extends AbstractDB<TVShow>{

    public TVShowDB(){
    }

    public void putTVShow(TVShow show){
        // proof of concept
    }
    public TVShow getTVShow(String mediaID){
        // proof of concept
        return new TVShow();
    }

}
