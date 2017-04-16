package lab5.controll;

import lab5.exception.WrongTrackListFormat;
import lab5.model.Track;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Алексей on 14.04.2017.
 */
public class Input implements IInput{
    private List<Track> trackList;
    public Input(String path) throws IOException, WrongTrackListFormat,
            InstantiationException, IllegalAccessException {
        if(path == null)
            path = "src/lab5/run/trackList.txt";
        File file = new File(path);
        if (!file.exists())
            throw new FileNotFoundException();
        BufferedReader reader = new BufferedReader(new FileReader(file.getAbsoluteFile()));
        this.trackList = new ArrayList<>();
        for (; ; ) {
            String track = reader.readLine();
            if (track == null)
                break;
            this.trackList.add(createTrack(track));
        }
    }

    @Override
    public List<Track> getTracks() {
        return this.trackList;
    }

    private Track createTrack(String track) throws WrongTrackListFormat,
            IllegalAccessException, InstantiationException {
        String[] info = track.split(";");
        Class cl;
        try {
            cl = Class.forName("lab5.model.implementation." + info[0]);
        } catch (ClassNotFoundException e) {
            throw new WrongTrackListFormat();
        }
        if(!cl.getSuperclass().equals(Track.class))
            throw new WrongTrackListFormat();
        Track tmpTrack = (Track) cl.newInstance();
        tmpTrack.setTrack(info[1], info[2]);
        return tmpTrack;
    }
}
