package lab5.controll;

import lab5.exception.WrongTrackListFormat;
import lab5.model.Track;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Алексей on 14.04.2017.
 */
public class AlbumTask implements IAlbumTask{
    private List<Track> tracks;
    public AlbumTask(IInput input) throws WrongTrackListFormat, FileNotFoundException{
        this.tracks = input.getTracks();
    }

    @Override
    public String getTrackList() {
        StringBuilder result = new StringBuilder();
        Class tmp;
        for(Track track : this.tracks){
            tmp = track.getClass();
            String trackType = tmp.getName().split("\\.")[3];
            result.append(trackType + " : " + track.getName() +
                    " -> Duration : " + track.getDuration() + "\n");
        }
        return result.toString();
    }

    @Override
    public String getAlbumDuration() {
        int duration = 0;
        for(Track track : this.tracks){
            duration += DurationConvert(track.getDuration());
        }
        return DurationConvert(duration);
    }

    @Override
    public String getTracksByGenres() {
        StringBuilder result = new StringBuilder();
        Map<String, List<Track>> trackMap = new HashMap<>();
        for (Track track : this.tracks){
            Class cl = track.getClass();
            String[] strings = cl.getName().split("\\.");
            String trackType = strings[strings.length - 1];
            if(trackMap.containsKey(trackType)){
                trackMap.get(trackType).add(track);
            }else{
                List<Track> tmpList = new ArrayList<>();
                tmpList.add(track);
                trackMap.put(trackType, tmpList);
            }
        }
        for(String trackType : trackMap.keySet()){
            result.append("\n" + trackType + ":\n");
            for(Track list : trackMap.get(trackType)){
                result.append(list.getName() + "\n");
            }
        }
        return result.toString();
    }

    @Override
    public String searchByDuration(String duration) {
        String[] limits = duration.split("-");
        Class cl;
        StringBuilder result = new StringBuilder();
        int begLimit = DurationConvert(limits[0]);
        int endLimit = DurationConvert(limits[1]);
        for(Track track : this.tracks){
            int curDur = DurationConvert(track.getDuration());
            if(curDur >= begLimit && curDur <= endLimit){
                cl = track.getClass();
                String[] strings = cl.getName().split("\\.");
                result.append("\n" + strings[strings.length - 1] + ":" + track.getName());
            }
        }
        return result.toString();
    }
    private int DurationConvert(String duration){
        String[] durations = duration.split(":");
        int durationSec = 0;
        durationSec += Integer.parseInt(durations[2]);
        durationSec += Integer.parseInt(durations[1]) * 60;
        durations[0] = durations[0].replace(" ", "");
        if(!durations[0].equals("00"))
            durationSec += Integer.parseInt(durations[0]) * 3600;
        return durationSec;
    }
    private String DurationConvert(int duration){
        StringBuilder result = new StringBuilder();
        int durationHour = duration / 3600;
        duration -= durationHour * 3600;
        int durationMin = duration / 60;
        duration -= durationMin * 60;
        int durationSec = duration;
        if(durationHour < 10)
            result.append("0" + durationHour + ":");
        else
            result.append(durationHour + ":");
        if(durationMin < 10)
            result.append("0" + durationMin + ":");
        else
            result.append(durationMin + ":");
        if(durationSec < 10)
            result.append("0" + durationSec);
        else
            result.append(durationSec);
        return result.toString();
    }
}
