package lab5.controll;

import lab5.exception.WrongTrackListFormat;

import java.io.FileNotFoundException;

/**
 * Created by Алексей on 14.04.2017.
 */
public interface IAlbumTask {
    static AlbumTask create(IInput input) throws FileNotFoundException, WrongTrackListFormat {
        return new AlbumTask(input);
    }

    String getTrackList();

    String getAlbumDuration();

    String getTracksByGenres();

    String searchByDuration(String duration);
}
