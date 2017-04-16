package lab5.model;

/**
 * Created by Алексей on 14.04.2017.
 */
public abstract class Track {
    private String name;
    private String duration;

    public Track(){

    }

    public String getName() {
        return name;
    }

    public String getDuration() {
        return duration;
    }

    public void setTrack(String name, String duration){
        this.name = name;
        this.duration = duration;
    }

}
