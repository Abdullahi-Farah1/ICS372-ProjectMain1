package aya.reviews.ics372projectmain1.datamodels;


import aya.reviews.ics372projectmain1.database.AbstractDB;

public class Movie extends Media {
    private int runtime;

    public Movie(String name, String description, int runtime){
        super(name, description);
        setRuntime(runtime);
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public static String buildPutQuery(){
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
