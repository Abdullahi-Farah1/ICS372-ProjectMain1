package aya.reviews.ics372projectmain1.database;

import aya.reviews.ics372projectmain1.datamodels.TVShow;

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
        TVShow mov = this.showMap.get(mediaID);
        if (mov == null){
            return super.get(mediaID);
        }else{
            return mov;
        }
    }

    public void deleteTVShow(String mediaID){
        this.showMap.remove(mediaID);
        super.delete(mediaID);
    }

    public boolean updateTVShow(String mediaID, TVShow newTVShow){
        if (this.showMap.containsKey(mediaID)) {
            this.showMap.put(mediaID, newTVShow);
            super.delete(mediaID);
            super.put(newTVShow);
            return true;
        }
        return false;
    }
    @Override
    public String buildPutQuery(TVShow show){
        return "PUT FROM TV";
    }
    @Override
    public String buildGetQuery() {
        return "GET FROM TV";
    }

    @Override
    public String buildDeleteQuery() {
        return "DELETE FROM TV";
    }

}
