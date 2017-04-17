package lab6;

import lab5.model.Track;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Алексей on 17.04.2017.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Collection of Tracks");
        TrackList<Track> trackList = new TrackList<Track>();
        for(Track track = menu(); track != null; track = menu()){
            trackList.add(track);
        }
        for(Track track : trackList){
            String[] strings = track.getClass().getName().split("\\.");
            System.out.println(strings[strings.length-1] + " : "
                    + track.getName() + " -> " + track.getDuration());
        }
    }
    private static Track menu(){
        System.out.println("1-add track\n2-show tracks");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String text = reader.readLine();
            int ans = Integer.parseInt(text);
            switch (ans){
                case 1:
                {
                    String result;
                    System.out.print("Enter genre:");
                    result = reader.readLine().replace(" ", "");
                    Class cl = Class.forName("lab5.model.implementation." + result);
                    Track tmp = (Track) cl.newInstance();
                    System.out.print("Enter name:");
                    result = reader.readLine() + ";";
                    System.out.println("Enter duration(XX:YY:ZZ):");
                    result += reader.readLine();
                    String[] strings = result.split(";");
                    tmp.setTrack(strings[0], strings[1]);
                    return  tmp;
                }
                case 2:
                    return null;
            }
        }catch (IOException e){
            System.out.println("Error occurred: wrong input");
            System.exit(-1);
        }catch (NumberFormatException e){
            System.out.println("Error occurred: wrong menu type input");
            System.exit(-1);
        } catch (ClassNotFoundException e) {
            System.out.println("Error occurred: wrong genre");
            System.out.println(-1);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }

}
