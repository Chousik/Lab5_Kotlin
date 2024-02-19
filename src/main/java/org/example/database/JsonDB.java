package org.example.database;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.example.collection.MusicBand;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

public class JsonDB implements InterfaceDataBase<MusicBand>{
    String fileName;
    public JsonDB(String FileName){
        this.fileName = FileName;
    }
    @Override
    public void SaveData(LinkedList<MusicBand> collection) throws IOException {
        File file = new File(fileName);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.writeValue(file, collection);
    }

    @Override
    public LinkedList<MusicBand> LoadData() throws IOException {
        File file = new File(fileName);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        LinkedList<MusicBand> data = objectMapper.readValue(file, new TypeReference<>() {});
        return data;
    }
}
