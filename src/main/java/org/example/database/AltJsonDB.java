package org.example.database;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.example.collection.MusicBand;

import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Класс для работы с базой данных в формате json
 */
public class AltJsonDB implements IDataBase<MusicBand> {
    private String fileName;

    public AltJsonDB(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Метод для сохранения данных через FileWriter
     *
     * @param collection коллекция
     * @throws IOException если произошла ошибка ввода/вывода
     */
    @Override
    public void saveData(LinkedList<MusicBand> collection) throws IOException {
        File file = new File(fileName);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        String jsonData = objectMapper.writeValueAsString(collection);
        FileWriter writer = new FileWriter(file);
        writer.write(jsonData);
        writer.flush();
        writer.close();
    }

    /**
     * Метод для загрузки данных через InputStreamReader
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
            String jsonData = "";
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            jsonData = reader.readLine();
            reader.close();
            LinkedList<MusicBand> data = objectMapper.readValue(jsonData, new TypeReference<>() {
            });
            return data;
        }
        return new LinkedList<>();
    }

}
