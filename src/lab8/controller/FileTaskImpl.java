package lab8.controller;

import lab5.model.Track;
import lab6.TrackList;
import lab8.exceptions.NoObjectsPresentException;
import lab8.exceptions.WrongStringTypeException;
import lab8.utils.FileIOUtils;
import lab8.utils.StringParsingUtils;

import java.io.IOException;

/**
 * Created by Алексей on 24.04.2017.
 */
public class FileTaskImpl implements IFileTask{

    private FileIOUtils ioUtils;
    private StringParsingUtils parsingUtils;

    private String[] parsedStrings;
    private Track[] parsedTracks;
    private TrackList<Track> trackList;

    public FileTaskImpl(String defaultFilePath) {
        ioUtils = new FileIOUtils(defaultFilePath);
        parsingUtils = new StringParsingUtils();
        parsedStrings = null;
        parsedTracks = null;
        trackList = null;
    }

    @Override
    public String readStrings() {
        try{
            String[] lines = ioUtils.readStrings();
            parsedStrings = parsingUtils.parseStrings(lines, Track.class) ? lines : new String[0];
            return "Reading strings was successful";
        }catch (WrongStringTypeException e){
            System.out.println("Error occurred: wrong format of strings in file");
            System.exit(-1);
        } catch (IOException e) {
            System.out.println("Error occurred: reading from file error");
            System.exit(-1);
        }
        return null;
    }

    @Override
    public String writeStrings() {
        try{
            ioUtils.writeStrings(parsedStrings);
            return "Writing strings is successful";
        }catch (NoObjectsPresentException e){
            System.out.println("Error occurred: empty strings array");
            System.exit(-1);
        } catch (IOException e) {
            System.out.println("Error occurred: writing to file error");
            System.exit(-1);
        }
        return null;
    }

    @Override
    public String readCollection() {
        try {
            String[] lines = ioUtils.readStrings();
            trackList = parsingUtils.parseTrackList(lines);
            return "Reading a collection is successful";
        }catch (WrongStringTypeException e){
            System.out.println("Error occurred: wrong format of strings in file");
            System.exit(-1);
        } catch (IOException e) {
            System.out.println("Error occurred: reading from file error");
            System.exit(-1);
        }
        return null;
    }

    @Override
    public String writeCollection() {
        try{
            ioUtils.writeCollection(trackList);
            return "Writing strings is successful";
        }catch (NoObjectsPresentException e){
            System.out.println("Error occurred: empty trackList collection");
            System.exit(-1);
        } catch (IOException e) {
            System.out.println("Error occurred: writing to file error");
            System.exit(-1);
        }
        return null;
    }

    @Override
    public String readObjectsArray() {
        try {
            String[] lines = ioUtils.readStrings();
            parsedTracks = parsingUtils.parseObjectsArray(lines);
            return "Reading a collection is successful";
        }catch (WrongStringTypeException e){
            System.out.println("Error occurred: wrong format of strings in file");
            System.exit(-1);
        } catch (IOException e) {
            System.out.println("Error occurred: reading from file error");
            System.exit(-1);
        }
        return null;
    }

    @Override
    public String writeObjectsArray() {
        try{
            ioUtils.writeObjectsArray(trackList);
            return "Writing strings is successful";
        }catch (NoObjectsPresentException e){
            System.out.println("Error occurred: empty tracks array");
            System.exit(-1);
        } catch (IOException e) {
            System.out.println("Error occurred: writing to file error");
            System.exit(-1);
        }
        return null;
    }

    @Override
    public String[] getParsedStrings() {
        return parsedStrings;
    }

    @Override
    public Track[] getParsedTracks() {
        return parsedTracks;
    }

    @Override
    public TrackList<Track> getTrackList() {
        return trackList;
    }

    @Override
    public String getFormattedString(String[] parsedStrings, Track[] tracks, TrackList<Track> trackList) {
        return parsingUtils.format(parsedStrings, tracks, trackList);
    }
}
