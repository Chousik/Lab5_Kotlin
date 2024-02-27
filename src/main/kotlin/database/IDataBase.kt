package org.chousik.database

import org.chousik.collection.MusicBand
import java.io.IOException
import java.util.*

/**
 * Интерфейс для работы с базой данных
 *
 * @param <T> тип данных
</T> */
interface IDataBase<T> {
    /**
     * Метод для сохранения данных
     *
     * @param collection коллекция
     * @throws IOException если произошла ошибка ввода/вывода
     */
    @Throws(IOException::class)
    fun saveData(collection: LinkedList<T>?)

    /**
     * Метод для загрузки данных
     *
     * @return коллекция
     * @throws IOException если произошла ошибка ввода/вывода
     */
    @Throws(IOException::class)
    fun loadData(): LinkedList<MusicBand>

    /**
     * Метод для проверки существования файла
     *
     * @return true, если файл существует, иначе false
     */
    fun checkFileExist(): Boolean
}