package org.example.database;

import java.io.IOException;
import java.util.LinkedList;
/**
 * Интерфейс для работы с базой данных
 * @param <T> тип данных
 */
public interface IDataBase<T> {
    /**
     * Метод для сохранения данных
     * @param collection коллекция
     * @throws IOException если произошла ошибка ввода/вывода
     */
    void saveData(LinkedList<T> collection) throws IOException;
    /**
     * Метод для загрузки данных
     * @return коллекция
     * @throws IOException если произошла ошибка ввода/вывода
     */
    LinkedList<T> loadData() throws IOException;
}
