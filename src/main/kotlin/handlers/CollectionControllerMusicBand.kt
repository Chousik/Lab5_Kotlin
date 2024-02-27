package org.chousik.handlers

import org.chousik.collection.MusicBand
import org.chousik.collection.Person
import org.chousik.collection.builder.BuilderMusicBand
import org.chousik.database.IDataBase
import org.chousik.exception.ArgumentError
import org.chousik.exception.ScriptExecutionError
import java.io.IOException
import java.time.LocalDateTime
import java.util.*
import java.util.function.Predicate

class CollectionControllerMusicBand(dataBase: IDataBase<MusicBand?>, linkedList: LinkedList<MusicBand?>) :
    ICollectionController<MusicBand?> {
    override var collection: LinkedList<MusicBand?>
    private val dataBase: IDataBase<MusicBand?> = dataBase

    /**
     * Метод для получения времени инициализации коллекции
     *
     * @return время инициализации
     */
    override var lastInitTime: LocalDateTime = LocalDateTime.now()
        private set

    init {
        this.collection = linkedList
    }

    /**
     * Метод для добавления элемента в коллекцию
     *
     * @param musicBand элемент
     */
    override fun add(musicBand: MusicBand) {
        collection.add(musicBand)
    }

    override val collectionType: String
        /**
         * Метод для получения типа коллекции
         *
         * @return тип коллекции
         */
        get() = collection.javaClass.name

    /**
     * Метод для получения коллекции
     *
     * @return коллекция
     */
    fun getCollection(): LinkedList<MusicBand?> {
        return collection
    }

    /**
     * Метод для получения размера коллекции
     *
     * @return размер коллекции
     */
    override fun size(): Int {
        return collection.size
    }

    /**
     * Метод для получения элементов коллекции по количеству альбомов
     *
     * @param integer количество альбомов
     * @return элементы коллекции
     */
    override fun getElementsByAlbomCount(integer: Int?): String? {
        if (collection.isEmpty()) {
            return "Пустая колеекция!"
        }
        val result: String = java.lang.String.join(
            "\n",
            collection.stream().filter(Predicate<MusicBand?> { x: MusicBand? -> x!!.getAlbumsCount() == integer?.toLong() })
                .map<Any>(MusicBand::toString).toList()
        )
        if (result.isEmpty()) {
            return "Нет таких групп"
        }
        return result
    }

    override val elements: String
        /**
         * Метод для получения элементов коллекции
         *
         * @return элементы коллекции
         */
        get() {
            if (collection.isEmpty()) {
                return "Пустая колеекция!"
            }
            return java.lang.String.join("\n", collection.stream().map<Any>(MusicBand::toString).toList())
        }

    /**
     * Метод для обновления элементов коллекции
     *
     * @param id идентификатор элемента
     * @throws ArgumentError        если аргумент неверный
     * @throws ScriptExecutionError если произошла ошибка выполнения скрипта
     */
    @Throws(ArgumentError::class, ScriptExecutionError::class)
    fun updateElements(id: Int) {
        try {
            val musicBand: MusicBand =
                collection.stream().filter(Predicate<MusicBand?> { x: MusicBand? -> x!!.getId() == id }).findFirst()
                    .get()
            BuilderMusicBand().reBuild(musicBand)
        } catch (e: NoSuchElementException) {
            throw ArgumentError("Группы с таким айди не сущетсвует.")
        }
    }

    /**
     * Метод для удаления элементов коллекции
     *
     * @param index индекс элемента
     * @throws ArgumentError если аргумент неверный
     */
    @Throws(ArgumentError::class)
    fun removeElements(index: Int) {
        if (index > collection.size - 1 || index < 0) {
            throw ArgumentError("Неверное id: " + index + ". Длина коллекции: " + collection.size)
        }
        val musicBand: MusicBand? = collection[index]
        collection.remove(musicBand)
    }

    /**
     * Метод для очистки коллекции
     */
    override fun clear() {
        collection.clear()
        lastInitTime = LocalDateTime.now()
    }

    /**
     * Перемешивает коллекцию
     */
    override fun shuffle() {
        Collections.shuffle(collection)
    }

    /**
     * Переворачивает коллекцию
     */
    override fun reorder() {
        Collections.reverse(collection)
    }

    /**
     * Удаляет элементы коллекции по переданному айди
     *
     * @param id
     * @throws ArgumentError
     */
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

    /**
     * Удаляет элементы коллекции по переданному лидеру
     *
     * @param person
     * @throws ArgumentError
     */
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

    /**
     * Возвращает количество элементов, значение поля numberOfParticipants которых равно заданному
     *
     * @param longs
     * @return
     */
    fun countNumberOfParticipants(longs: Long): Int {
        return collection.stream()
            .filter(Predicate<MusicBand?> { x: MusicBand? -> x!!.getNumberOfParticipants() == longs }).toList().size
    }

    /**
     * Метод для загрузки данных
     */
    override fun loadData() {
        try {
            collection = dataBase.loadData()!!
            lastInitTime = LocalDateTime.now()
        } catch (e: IOException) {
            if (dataBase.checkFileExist()) {
                println("Ошибка доступа к файлу для загрузки")
            } else {
                println("Файл для загрузки не найден")
            }
        }
    }

    /**
     * Метод для сохранения данных
     *
     * @return
     */
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