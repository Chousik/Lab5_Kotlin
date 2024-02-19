package org.example.database;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.collection.MusicBand;

import java.io.IOException;
import java.util.LinkedList;

public interface InterfaceDataBase<T> {
    void SaveData(LinkedList<T> collection) throws IOException;
    LinkedList<T> LoadData() throws IOException;
}
