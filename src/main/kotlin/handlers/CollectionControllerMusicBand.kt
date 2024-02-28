package org.chousik.handlers

import org.chousik.collection.MusicBand
import org.chousik.collection.Person
import org.chousik.collection.builder.BuilderMusicBand
import org.chousik.database.AltJsonDB
import org.chousik.exception.ArgumentError
import org.chousik.exception.ScriptExecutionError
import java.io.IOException
import java.time.LocalDateTime
import java.util.*
import java.util.function.Predicate
import java.util.function.Function

class CollectionControllerMusicBand(dataBase: AltJsonDB, linkedList: LinkedList<MusicBand>) :
    ICollectionController<MusicBand?> {
    override var collection: LinkedList<MusicBand?>
    private val dataBase: AltJsonDB = dataBase

    override var lastInitTime: LocalDateTime = LocalDateTime.now()
        private set

    init {
        collection = linkedList.filterNotNullTo(LinkedList())
    }


    override fun add(musicBand: MusicBand) {
        collection.add(musicBand)
    }

    override val collectionType: String
        get() = collection.javaClass.name

    override fun size(): Int {
        return collection.size
    }

    override fun getElementsByAlbomCount(integer: Int?): String? {
        if (collection.isEmpty()) {
            return "Пустая колеекция!"
        }
        val result: String = collection.stream().filter(Predicate<MusicBand?> { x: MusicBand? -> x!!.getAlbumsCount() == integer?.toLong() })
                .map<Any>(Function { value: MusicBand? -> value.toString() }).toList().joinToString("\n")
        if (result.isEmpty()) {
            return "Нет таких групп"
        }
        return result
    }

    override val elements: String

        get() {
            if (collection.isEmpty()) {
                return "Пустая колеекция!"
            }
            return collection.stream().map<Any>(Function { value: MusicBand? -> value.toString() }).toList().joinToString("\n")
        }


    @Throws(ArgumentError::class, ScriptExecutionError::class)
    override fun updateElements(id: Int?) {
        try {
            val musicBand: MusicBand =
                collection.stream().filter(Predicate<MusicBand?> { x: MusicBand? -> x!!.getId() == id }).findFirst()
                    .get()
            BuilderMusicBand().reBuild(musicBand)
        } catch (e: NoSuchElementException) {
            throw ArgumentError("Группы с таким айди не сущетсвует.")
        }
    }


    @Throws(ArgumentError::class)
    override fun removeElements(index: Int?) {
        if (index!! > collection.size - 1 || index < 0) {
            throw ArgumentError("Неверное id: " + index + ". Длина коллекции: " + collection.size)
        }
        val musicBand: MusicBand? = collection[index]
        collection.remove(musicBand)
    }


    override fun clear() {
        collection.clear()
        lastInitTime = LocalDateTime.now()
    }


    override fun shuffle() {
        Collections.shuffle(collection)
    }


    override fun reorder() {
        Collections.reverse(collection)
    }


    @Throws(ArgumentError::class)
    override fun removeElementByID(id: Int?) {
        try {
            val musicBand: MusicBand =
                collection.stream().filter(Predicate<MusicBand?> { x: MusicBand? -> x!!.getId() == id }).findFirst()
                    .get()
            collection.remove(musicBand)
        } catch (e: NoSuchElementException) {
            throw ArgumentError("Группы с таким айди не сущетсвует.")
        }
    }


    @Throws(ArgumentError::class)
    override fun removeByFrontMan(person: Person?) {
        try {
            val musicBand: MusicBand = collection.stream().filter(Predicate<MusicBand?> { x: MusicBand? ->
                x?.getFrontMan()!!.equals(person)
            }).findFirst().get()
            collection.remove(musicBand)
        } catch (e: NoSuchElementException) {
            throw ArgumentError("Группы с таким лидером не сущетсвует.")
        }
    }


    override fun countNumberOfParticipants(longs: Long?): Int {
        return collection.stream()
            .filter(Predicate<MusicBand?> { x: MusicBand? -> x!!.getNumberOfParticipants() == longs }).toList().size
    }


    override fun loadData() {
        try {
            collection = dataBase.loadData().filterNotNullTo(LinkedList())
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