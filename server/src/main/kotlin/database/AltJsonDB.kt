package database
import collection.MusicBand
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.File
import java.util.LinkedList

class AltJsonDB(private val fileName: String) : IDataBase<MusicBand> {
    override fun saveData(collection: LinkedList<MusicBand>) {
        val file = File(fileName)
        val gson = Gson()
        val json = gson.toJson(collection)
        file.writeText(json)
    }

    override fun loadData(): LinkedList<MusicBand> {
        val file = File(fileName)
        val gson = Gson()
        val listType = object : TypeToken<LinkedList<MusicBand>>() {}.type
        return gson.fromJson(file.readText(), listType)
    }

    override fun checkFileExist(): Boolean {
        val file = File(fileName)
        return file.exists()
    }
}
