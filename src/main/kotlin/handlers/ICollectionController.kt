package org.chousik.handlers

import org.chousik.collection.MusicBand
import org.chousik.collection.Person
import org.chousik.exception.ArgumentError
import org.chousik.exception.ScriptExecutionError
import java.time.LocalDateTime
import java.util.*

/**
 * Интерфейс для контроллера коллекции
 *
 * @param <T> тип данных
</T> */
interface ICollectionController<T : Comparable<*>?> {
    /**
     * Метод для добавления элемента в коллекцию
     *
     * @param t элемент
     */
    fun add(t: MusicBand)

    /**
     * Метод для получения времени инициализации коллекции
     *
     * @return время инициализации
     */
    val lastInitTime: LocalDateTime?

    /**
     * Метод для получения типа коллекции
     *
     * @return тип коллекции
     */
    val collectionType: String?

    /**
     * Метод для получения коллекции
     *
     * @return коллекция
     */
    val collection: LinkedList<T>?

    /**
     * Метод для получения размера коллекции
     *
     * @return размер коллекции
     */
    fun size(): Int

    /**
     * Метод для получения элементов коллекции
     *
     * @return элементы коллекции
     */
    val elements: String?

    /**
     * Метод для получения элементов коллекции по количеству альбомов
     *
     * @param integer количество альбомов
     * @return элементы коллекции
     */
    fun getElementsByAlbomCount(integer: Int?): String?

    /**
     * Метод для обновления элементов коллекции
     *
     * @param id идентификатор элемента
     * @throws ArgumentError        если аргумент неверный
     * @throws ScriptExecutionError если произошла ошибка выполнения скрипта
     */
    @Throws(ArgumentError::class, ScriptExecutionError::class)
    fun updateElements(id: Int?)

    /**
     * Метод для удаления элементов коллекции
     *
     * @param index индекс элемента
     * @throws ArgumentError если аргумент неверный
     */
    @Throws(ArgumentError::class)
    fun removeElements(index: Int?)

    /**
     * Метод для очистки коллекции
     */
    fun clear()

    /**
     * Метод для удаления элемента по идентификатору
     *
     * @param id идентификатор элемента
     * @throws ArgumentError если аргумент неверный
     */
    @Throws(ArgumentError::class)
    fun removeElementByID(id: Int?)

    /**
     * Метод для перемешивания коллекции
     */
    fun shuffle()

    /**
     * Метод для реверса коллекции
     */
    fun reorder()

    /**
     * Метод для удаления элемента по полю frontMan
     *
     * @param person объект класса Person
     * @throws ArgumentError если аргумент неверный
     */
    @Throws(ArgumentError::class)
    fun removeByFrontMan(person: Person?)

    /**
     * Метод для получения количества участников
     *
     * @param longs количество участников
     * @return количество участников
     */
    fun countNumberOfParticipants(longs: Long?): Int

    /**
     * Метод для получения среднего количества участников
     *
     * @return среднее количество участников
     */
    fun loadData()

    /**
     * Метод для сохранения данных
     *
     * @return
     */
    fun saveData(): Boolean
    /**
     * Метод для получения элемента по идентификатору
     * @param id идентификатор элемента
     * @return элемент
     */
}