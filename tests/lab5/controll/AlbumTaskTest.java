package lab5.controll;

import lab5.exception.WrongTrackListFormat;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by Алексей on 07.06.2017.
 */
public class AlbumTaskTest {

    static IInput input;
    static IAlbumTask albumTask;

    @BeforeClass
    public void setUpStatic(){
        try {
            input = IInput.create(null);
            albumTask = IAlbumTask.create(input);
        } catch (WrongTrackListFormat |
                IOException |
                IllegalAccessException |
                InstantiationException wrongTrackListFormat) {
            wrongTrackListFormat.printStackTrace();
        }
    }

    @Test
    public void getTrackList() throws Exception {
        String trackList = albumTask.getTrackList();
        Assert.assertEquals(Integer.valueOf(4), (Integer) trackList.split("\n").length);
    }

    @Test
    public void getAlbumDuration() throws Exception {
        String duration = albumTask.getAlbumDuration();
        Assert.assertEquals("00:11:18", duration);
    }


}