package org.example.database;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.example.collection.MusicBand;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Класс для работы с базой данных в формате json
 */
public class JsonDB implements IDataBase<MusicBand> {
    private String fileName;

    public JsonDB(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Метод для сохранения данных
     *
     * @param collection коллекция
     * @throws IOException если произошла ошибка ввода/вывода
     */
    @Override
    public void saveData(LinkedList<MusicBand> collection) throws IOException {
        File file = new File(fileName);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.writeValue(file, collection);
    }

    /**
     * Метод для загрузки данных
     *
     * @return коллекция
     * @throws IOException если произошла ошибка ввода/вывода
     */
    @Override
    public LinkedList<MusicBand> loadData() throws IOException {
        File file = new File(fileName);
        if (new Scanner(file).hasNext()) {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());
            LinkedList<MusicBand> data = objectMapper.readValue(file, new TypeReference<>() {
            });
            return data;
        }
        return new LinkedList<>();
    }
}

