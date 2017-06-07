package lab8.utils;

import lab5.model.Track;
import lab6.TrackList;
import lab8.exceptions.WrongStringTypeException;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Алексей on 24.04.2017.
 */
public class StringParsingUtils {

    public boolean parseStrings(String[] lines, Class cls) throws WrongStringTypeException{
        Field[] fieldsArr = cls.getDeclaredFields();
        List<String> fieldNames = new ArrayList<>();
        for (Field field : fieldsArr){
            fieldNames.add(field.getName());
        }
        for(String line : lines){
            String[] parts = line.split(";");
            try {
                Class tmpClass = Class.forName("lab5.model.implementation." + parts[0]);
                if(tmpClass.getSuperclass() != cls || fieldsArr.length != parts.length - 1)
                    throw new WrongStringTypeException();
                if(parts.length > 1)
                    for(int i=1;i< parts.length;i++){
                        if(!fieldNames.contains(parts[i]))
                            throw new WrongStringTypeException();
                    }
            } catch (ClassNotFoundException e) {
                throw new WrongStringTypeException();
            }
        }
        return true;
    }

    public TrackList<Track> parseTrackList(String[] lines) throws WrongStringTypeException{
        return null;
    }

    public Track[] parseObjectsArray(String[] lines) throws WrongStringTypeException{
        return null;
    }

    public String format(String[] parsedStrings, Track[] tracks, TrackList<Track> trackList) {
        return null;
    }
}
