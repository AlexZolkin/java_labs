package lab5.controll;


import lab5.exception.WrongTrackListFormat;
import lab5.model.Track;

import java.io.IOException;
import java.util.List;

/**
 * Created by Алексей on 14.04.2017.
 */
public interface IInput {
    static Input create(String path) throws WrongTrackListFormat, IOException, IllegalAccessException, InstantiationException {
        return new Input(path);
    }

    List<Track> getTracks();
}
