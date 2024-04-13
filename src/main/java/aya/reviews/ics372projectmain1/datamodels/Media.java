
package aya.reviews.ics372projectmain1.datamodels;
import aya.reviews.ics372projectmain1.database.AbstractDB;
import java.util.ArrayList;

abstract class Media{

    private String name;
    private String description;
    private String mediaID;
    public Media(String name, String description, String mediaID){
        setName(name);
        setDescription(description);
        setMediaID(mediaID);
    }
    public Media(){
        System.out.println("Default Constructor");
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMediaID() {
        return mediaID;
    }

    public void setMediaID(String mediaID) {
        this.mediaID = mediaID;
    }
}