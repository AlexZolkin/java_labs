package lab6;

import lab5.model.Track;
import lab5.model.implementation.Pop;
import lab5.model.implementation.Rap;
import lab5.model.implementation.Rock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Алексей on 07.06.2017.
 */
public class TrackListTest {

    TrackList<Track> trackList;

    @Before
    public void setUp(){
        trackList = new TrackList<>();
        trackList.add(new Rap());
        trackList.add(new Rock());
        trackList.add(new Pop());
    }

    @Test
    public void size() throws Exception {
        Assert.assertEquals(3, trackList.size());
    }

    @Test
    public void isEmpty() throws Exception {
        Assert.assertEquals(false, trackList.isEmpty());
    }

    @Test
    public void contains() throws Exception {
        Track tmpTrack = trackList.get(0);
        Assert.assertEquals(true, trackList.contains(tmpTrack));
    }


    @Test
    public void remove() throws Exception {
        Track tmpTrack = trackList.get(0);
        trackList.remove(tmpTrack);
        Assert.assertEquals(2, trackList.size());
    }

    @Test
    public void clear() throws Exception {
        trackList.clear();
        Assert.assertEquals(0, trackList.size());
    }

    @Test
    public void indexOf() throws Exception {
        Track tmpTrack = trackList.get(0);
        Assert.assertEquals(0, trackList.indexOf(tmpTrack));
    }

    @Test
    public void lastIndexOf() throws Exception {
        Track tmpTrack = trackList.get(0);
        Assert.assertEquals(0, trackList.indexOf(tmpTrack));
    }

}