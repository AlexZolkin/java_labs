package lab5.run;

import lab5.controll.IAlbumTask;
import lab5.controll.IInput;
import lab5.controll.Input;
import lab5.exception.WrongTrackListFormat;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Алексей on 11.04.2017.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Songs hierarchy");
        System.out.println("Enter path to the file with data or use 'default' to use standard file: ");
        try {
            Input input = IInput.create(readPath());
            IAlbumTask albumTask = IAlbumTask.create(input);
            System.out.println("Track list:");
            System.out.println(albumTask.getTrackList());
            System.out.println("Album duration: " + albumTask.getAlbumDuration());
            System.out.println("Tracks, divided by genres:" + albumTask.getTracksByGenres());
            String duration = readDuration();
            System.out.println("Tracks with duration given: " + albumTask.searchByDuration(duration));
        }catch (FileNotFoundException e){
            System.out.println("Error occurred: file not found");
            System.exit(-1);
        } catch (WrongTrackListFormat e) {
            System.out.println("Error occurred: wrong track list format");
            System.exit(-1);
        } catch (IOException e) {
            System.out.println("Error occurred: input error");
            System.exit(-1);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
    private static String readPath(){
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String path = reader.readLine();
            return path.equals("default") ? null : path;
        }catch (IOException e){
            System.out.println("Error occurred: input error");
            System.exit(-1);
        }
        return null;
    }
    private static String readDuration(){
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Search tracks with duration from: ");
            String from = reader.readLine();
            System.out.print("Search tracks with duration up to: ");
            String to = reader.readLine();
            return from + "-" + to;
        }catch (IOException e){
            System.out.println("Error occurred: input error");
            System.exit(-1);
        }
        return null;
    }
}
