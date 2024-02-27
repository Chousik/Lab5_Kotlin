package org.chousik.database

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import org.chousik.collection.MusicBand
import java.io.*
import java.util.*

/**
 * Класс для работы с базой данных в формате json
 */
class AltJsonDB(private val fileName: String) : IDataBase<MusicBand?> {
    /**
     * Метод для сохранения данных через FileWriter
     *
     * @param collection коллекция
     * @throws IOException если произошла ошибка ввода/вывода
     */
    @Throws(IOException::class)
    override fun saveData(collection: LinkedList<MusicBand?>?) {
        val file = File(fileName)
        val objectMapper: ObjectMapper = ObjectMapper()
        val jsonData: String = objectMapper.writeValueAsString(collection)
        val writer = FileWriter(file)
        writer.write(jsonData)
        writer.flush()
        writer.close()
    }

    /**
     * Метод для загрузки данных через InputStreamReader
     *
     * @return коллекция
     * @throws IOException если произошла ошибка ввода/вывода
     */
    @Throws(IOException::class)
    override fun loadData(): LinkedList<MusicBand> {
        val file = File(fileName)
        if (Scanner(file).hasNext()) {
            val objectMapper: ObjectMapper = ObjectMapper()
            var jsonData = ""
            val reader = BufferedReader(InputStreamReader(FileInputStream(file)))
            jsonData = reader.readLine()
            reader.close()
            val data = objectMapper.readValue(jsonData, object : TypeReference<LinkedList<MusicBand>>() {})
            return data
        }
        return LinkedList<MusicBand>()
    }

    /**
     * Метод для проверки существования файла
     *
     * @return true, если файл существует, иначе false
     */
    override fun checkFileExist(): Boolean {
        val file = File(fileName)
        return file.exists()
    }
}