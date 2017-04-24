package lab8.controller;

import lab5.model.Track;
import lab6.TrackList;
import lab8.MenuItems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Алексей on 24.04.2017.
 */
public class Main {
    public static final String defaultFilePath = "lab8";

    public static void main(String[] args) {
        System.out.println("File working task");
        MenuItems item = menu();
        IFileTask fileTask = IFileTask.create(defaultFilePath);
        String resultStatus = null;
        switch (item){
            case READ_STRINGS:
                resultStatus = fileTask.readStrings();
                break;
            case WRITE_STRINGS:
                resultStatus = fileTask.writeStrings();
                break;
            case READ_COLLECTION:
                resultStatus = fileTask.readCollection();
                break;
            case WRITE_COLLECTION:
                resultStatus = fileTask.writeCollection();
                break;
            case READ_OBJECTS_ARRAY:
                resultStatus = fileTask.readObjectsArray();
                break;
            case WRITE_OBJECTS_ARRAY:
                resultStatus = fileTask.writeObjectsArray();
                break;
        }
        String[] parsedStrings = fileTask.getParsedStrings();
        Track[] tracks = fileTask.getParsedTracks();
        TrackList<Track> trackList = fileTask.getTrackList();
        String output = fileTask.getFormattedString(parsedStrings, tracks, trackList);
        System.out.println(resultStatus);
        System.out.println("Result:\n" + output);
    }

    private static MenuItems menu() {
        System.out.println("1-read strings\n2-write strings\n3-read collection\n" +
                "4-write collection\n5-read objects array\n6-write objects array");
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        try (BufferedReader reader = new BufferedReader(inputStreamReader)){
            int choice = Integer.parseInt(reader.readLine());
            MenuItems item = MenuItems.values()[choice+1];
            return item;
        } catch (IOException e) {
            System.out.println("Error occurred: input error");
            System.exit(-1);
        }
        return null;
    }
}
