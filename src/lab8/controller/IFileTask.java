package lab8.controller;

import lab5.model.Track;
import lab6.TrackList;

/**
 * Created by Алексей on 24.04.2017.
 */
public interface IFileTask {
    static FileTaskImpl create(String defaultFilePath) {
        return new FileTaskImpl(defaultFilePath);
    }

    String readStrings();

    String writeStrings();

    String readCollection();

    String writeCollection();

    String readObjectsArray();

    String writeObjectsArray();

    String[] getParsedStrings();

    Track[] getParsedTracks();

    TrackList<Track> getTrackList();

    String getFormattedString(String[] parsedStrings, Track[] tracks, TrackList<Track> trackList);
}
