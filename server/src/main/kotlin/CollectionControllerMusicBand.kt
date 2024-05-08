
import collection.MusicBand
import collection.Person
import collection.builder.BuilderMusicBand
import database.IDataBase
import database.SqlDB
import exeption.ArgumentError
import scanners.MainScanner
import java.io.IOException
import java.time.LocalDateTime
import java.util.*
import java.util.stream.Collectors

class CollectionControllerMusicBand(
    private val dataBase: IDataBase<MusicBand>,
    private val sqlDB: SqlDB,
    linkedList: LinkedList<MusicBand>,
) :
    ICollectionController<MusicBand> {
    override var collection: LinkedList<MusicBand>

    override var lastInitTime: LocalDateTime = LocalDateTime.now()
        private set

    init {
        collection = linkedList.filterNotNullTo(sqlDB.load())
    }

    override fun add(t: MusicBand, id: Int) {
        val band = sqlDB.addBand(t, id)
        collection.add(band)
    }

    override val collectionType: String
        get() = collection.javaClass.name

    override fun size(): Int {
        return collection.size
    }

    override fun getElementsByAlbumCount(integer: Int): String {
        if (collection.isEmpty()) {
            return "Пустая колеекция!"
        }
        val result: String =
            collection.stream().filter { x: MusicBand -> x.albumsCount == integer.toLong() }
                .map<Any> { value: MusicBand? -> value.toString() }.toList().joinToString("\n")
        if (result.isEmpty()) {
            return "Нет таких групп"
        }
        return result
    }

    override val elements: String

        get() {
            if (collection.isEmpty()) {
                return "Пустая коллекция!"
            }
            return collection.stream().map<Any>
            { value: MusicBand? -> value.toString() }.toList().joinToString("\n")
        }

    override fun updateElements(
        id: Int,
        userId: Int,
        musicBandNew: MusicBand,
    ) {
        sqlDB.updateById(id, userId, musicBandNew)
        val musicBand: MusicBand =
            collection.stream().filter { x: MusicBand -> x.id == id }.findFirst()
                .get()
        BuilderMusicBand(MainScanner()).reBuild(musicBand, musicBandNew)
    }

    override fun removeElements(index: Int, userId: Int) {
        if (index > collection.size - 1 || index < 0) {
            throw ArgumentError("Неверное id: " + index + ". Длина коллекции: " + collection.size)
        }
        val id = collection[index].id
        sqlDB.removeById(id, userId)
        val musicBand: MusicBand = collection[index]
        collection.remove(musicBand)
    }

    override fun clear(id: Int) {
        val result = sqlDB.clear(id)
        System.out.println(result)
        collection = collection.stream().filter { x -> x.id !in result }.collect(Collectors.toCollection { LinkedList<MusicBand>() })
        lastInitTime = LocalDateTime.now()
    }

    override fun shuffle() {
        collection.shuffle()
    }

    override fun reorder() {
        collection.reverse()
    }

    override fun removeElementByID(id: Int, userId: Int) {
        sqlDB.removeById(id, userId)
        val musicBand: MusicBand =
            collection.stream().filter { x: MusicBand -> x.id == id }.findFirst()
                .get()
        collection.remove(musicBand)
    }

    override fun removeByFrontMan(person: Person) {
        val musicBand: MusicBand =
            collection.stream().filter { x: MusicBand ->
                x.frontMan === person
            }.findFirst().get()
        collection.remove(musicBand)
    }

    override fun countNumberOfParticipants(longs: Long): Int {
        return collection.stream()
            .filter { x: MusicBand -> x.numberOfParticipants == longs }.toList().size
    }

    override fun loadData() {
        try {
            collection = dataBase.loadData().filterNotNullTo(LinkedList<MusicBand>())
            lastInitTime = LocalDateTime.now()
        } catch (e: IOException) {
            if (dataBase.checkFileExist()) {
                println("Ошибка доступа к файлу для загрузки")
            } else {
                println("Файл для загрузки не найден")
            }
        }
    }

    override fun saveData(): Boolean {
        ServerUDP.logger.info("Данные сохранены.")
        try {
            dataBase.saveData(collection)
            return true
        } catch (e: IOException) {
            if (dataBase.checkFileExist()) {
                println("Ошибка доступа к файлу для сохранения")
            } else {
                println("Файл для сохранения не найден")
            }
            return false
        }
    }
}
