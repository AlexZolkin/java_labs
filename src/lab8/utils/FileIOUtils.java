package lab8.utils;

import lab5.model.Track;
import lab6.TrackList;
import lab8.exceptions.NoObjectsPresentException;

import java.io.IOException;
import java.lang.reflect.Field;

/**
 * Created by Алексей on 24.04.2017.
 */
public class FileIOUtils {
    private String filePath;

    public FileIOUtils(String filePath) {
        this.filePath = filePath;
    }

    public String[] readStrings() throws IOException{
        String[] lines
    }

    public void writeStrings(String[] parsedStrings) throws NoObjectsPresentException, IOException{

    }

    public void writeCollection(TrackList<Track> trackList) throws NoObjectsPresentException, IOException{

    }

    public void writeObjectsArray(TrackList<Track> trackList) throws NoObjectsPresentException, IOException{

    }
}
