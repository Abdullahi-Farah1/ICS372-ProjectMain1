package aya.reviews.ics372projectmain1.datamodels;


public class Movie extends Media{
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
}