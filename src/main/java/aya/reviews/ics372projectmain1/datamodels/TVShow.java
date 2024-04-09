package aya.reviews.ics372projectmain1.datamodels;

class TVShow extends Media{

    private int numSeasons;

    public TVShow(String name, String description, int numSeasons){
        super(name, description);
        setNumSeasons(numSeasons);
    }
    public int getNumSeasons() {
        return numSeasons;
    }

    public void setNumSeasons(int numSeasons) {
        this.numSeasons = numSeasons;
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