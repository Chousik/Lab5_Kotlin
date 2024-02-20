package org.chousik.handlers;

import org.chousik.collection.Person;
import org.chousik.exception.ArgumentError;
import org.chousik.exception.ScriptExecutionError;

import java.time.LocalDateTime;
import java.util.LinkedList;

/**
 * Интерфейс для контроллера коллекции
 *
 * @param <T> тип данных
 */
public interface ICollectionController<T extends Comparable> {
    /**
     * Метод для добавления элемента в коллекцию
     *
     * @param t элемент
     */
    void add(T t);

    /**
     * Метод для получения времени инициализации коллекции
     *
     * @return время инициализации
     */
    LocalDateTime getLastInitTime();

    /**
     * Метод для получения типа коллекции
     *
     * @return тип коллекции
     */
    String getCollectionType();

    /**
     * Метод для получения коллекции
     *
     * @return коллекция
     */
    public LinkedList<T> getCollection();

    /**
     * Метод для получения размера коллекции
     *
     * @return размер коллекции
     */
    int size();

    /**
     * Метод для получения элементов коллекции
     *
     * @return элементы коллекции
     */
    String getElements();

    /**
     * Метод для получения элементов коллекции по количеству альбомов
     *
     * @param integer количество альбомов
     * @return элементы коллекции
     */
    String getElementsByAlbomCount(Integer integer);

    /**
     * Метод для обновления элементов коллекции
     *
     * @param id идентификатор элемента
     * @throws ArgumentError        если аргумент неверный
     * @throws ScriptExecutionError если произошла ошибка выполнения скрипта
     */
    void updateElements(Integer id) throws ArgumentError, ScriptExecutionError;

    /**
     * Метод для удаления элементов коллекции
     *
     * @param index индекс элемента
     * @throws ArgumentError если аргумент неверный
     */
    void removeElements(Integer index) throws ArgumentError;

    /**
     * Метод для очистки коллекции
     */
    void clear();

    /**
     * Метод для удаления элемента по идентификатору
     *
     * @param id идентификатор элемента
     * @throws ArgumentError если аргумент неверный
     */
    void removeElementByID(Integer id) throws ArgumentError;

    /**
     * Метод для перемешивания коллекции
     */
    void shuffle();

    /**
     * Метод для реверса коллекции
     */
    void reorder();

    /**
     * Метод для удаления элемента по полю frontMan
     *
     * @param person объект класса Person
     * @throws ArgumentError если аргумент неверный
     */
    void removeByFrontMan(Person person) throws ArgumentError;

    /**
     * Метод для получения количества участников
     *
     * @param longs количество участников
     * @return количество участников
     */
    int countNumberOfParticipants(Long longs);

    /**
     * Метод для получения среднего количества участников
     *
     * @return среднее количество участников
     */
    void loadData();

    /**
     * Метод для сохранения данных
     *
     * @return
     */
    boolean saveData();
    /**
     * Метод для получения элемента по идентификатору
     * @param id идентификатор элемента
     * @return элемент
     */
}
