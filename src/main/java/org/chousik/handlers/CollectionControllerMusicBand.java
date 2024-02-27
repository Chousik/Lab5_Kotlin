package org.chousik.handlers;

import org.chousik.collection.MusicBand;
import org.chousik.collection.Person;
import org.chousik.collection.builder.BuilderMusicBand;
import org.chousik.database.IDataBase;
import org.chousik.exception.ArgumentError;
import org.chousik.exception.ScriptExecutionError;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class CollectionControllerMusicBand implements ICollectionController<MusicBand> {
    private LinkedList<MusicBand> collection;
    final private IDataBase<MusicBand> dataBase;
    private LocalDateTime lastInitTime = LocalDateTime.now();

    public CollectionControllerMusicBand(IDataBase<MusicBand> dataBase, LinkedList<MusicBand> linkedList) {
        this.dataBase = dataBase;
        this.collection = linkedList;
    }

    /**
     * Метод для добавления элемента в коллекцию
     *
     * @param musicBand элемент
     */
    @Override
    public void add(MusicBand musicBand) {
        collection.add(musicBand);
    }

    /**
     * Метод для получения времени инициализации коллекции
     *
     * @return время инициализации
     */
    @Override
    public LocalDateTime getLastInitTime() {
        return lastInitTime;
    }

    /**
     * Метод для получения типа коллекции
     *
     * @return тип коллекции
     */

    @Override
    public String getCollectionType() {
        return collection.getClass().getName();
    }

    /**
     * Метод для получения коллекции
     *
     * @return коллекция
     */

    @Override
    public LinkedList<MusicBand> getCollection() {
        return collection;
    }

    /**
     * Метод для получения размера коллекции
     *
     * @return размер коллекции
     */

    @Override
    public int size() {
        return collection.size();
    }

    /**
     * Метод для получения элементов коллекции по количеству альбомов
     *
     * @param integer количество альбомов
     * @return элементы коллекции
     */

    @Override
    public String getElementsByAlbomCount(Integer integer) {
        if (collection.isEmpty()) {
            return "Пустая колеекция!";
        }
        String result = String.join("\n", collection.stream().filter(x -> x.getAlbumsCount() == integer).map(MusicBand::toString).toList());
        if (result.isEmpty()) {
            return "Нет таких групп";
        }
        return result;
    }

    /**
     * Метод для получения элементов коллекции
     *
     * @return элементы коллекции
     */
    @Override
    public String getElements() {
        if (collection.isEmpty()) {
            return "Пустая колеекция!";
        }
        return String.join("\n", collection.stream().map(MusicBand::toString).toList());
    }

    /**
     * Метод для обновления элементов коллекции
     *
     * @param id идентификатор элемента
     * @throws ArgumentError        если аргумент неверный
     * @throws ScriptExecutionError если произошла ошибка выполнения скрипта
     */
    @Override
    public void updateElements(Integer id) throws ArgumentError, ScriptExecutionError {
        try {
            MusicBand musicBand = collection.stream().filter(x -> x.getId() == id).findFirst().get();
            new BuilderMusicBand().reBuild(musicBand);
        } catch (NoSuchElementException e) {
            throw new ArgumentError("Группы с таким айди не сущетсвует.");
        }
    }

    /**
     * Метод для удаления элементов коллекции
     *
     * @param index индекс элемента
     * @throws ArgumentError если аргумент неверный
     */
    @Override
    public void removeElements(Integer index) throws ArgumentError {
        if (index > collection.size() - 1 || index < 0) {
            throw new ArgumentError("Неверное id: " + index + ". Длина коллекции: " + collection.size());
        }
        MusicBand musicBand = collection.get(index);
        collection.remove(musicBand);
    }

    /**
     * Метод для очистки коллекции
     */
    @Override
    public void clear() {
        collection.clear();
        lastInitTime = LocalDateTime.now();
    }

    /**
     * Перемешивает коллекцию
     */
    @Override
    public void shuffle() {
        Collections.shuffle(collection);
    }

    /**
     * Переворачивает коллекцию
     */
    @Override
    public void reorder() {
        java.util.Collections.reverse(collection);
    }

    /**
     * Удаляет элементы коллекции по переданному айди
     *
     * @param id
     * @throws ArgumentError
     */
    @Override
    public void removeElementByID(Integer id) throws ArgumentError {
        try {
            MusicBand musicBand = collection.stream().filter(x -> x.getId() == id).findFirst().get();
            collection.remove(musicBand);
        } catch (NoSuchElementException e) {
            throw new ArgumentError("Группы с таким айди не сущетсвует.");
        }
    }

    /**
     * Удаляет элементы коллекции по переданному лидеру
     *
     * @param person
     * @throws ArgumentError
     */
    @Override
    public void removeByFrontMan(Person person) throws ArgumentError {
        try {
            MusicBand musicBand = collection.stream().filter(x -> x.getFrontMan().equals(person)).findFirst().get();
            collection.remove(musicBand);
        } catch (NoSuchElementException e) {
            throw new ArgumentError("Группы с таким лидером не сущетсвует.");
        }
    }

    /**
     * Возвращает количество элементов, значение поля numberOfParticipants которых равно заданному
     *
     * @param longs
     * @return
     */
    @Override
    public int countNumberOfParticipants(Long longs) {
        return collection.stream().filter(x -> x.getNumberOfParticipants() == longs).toList().size();
    }

    /**
     * Метод для загрузки данных
     */
    @Override
    public void loadData() {
        try {
            collection = dataBase.loadData();
            lastInitTime = LocalDateTime.now();
        } catch (IOException e) {
            if (dataBase.checkFileExist()) {
                System.out.println("Ошибка доступа к файлу для загрузки");
            } else {
                System.out.println("Файл для загрузки не найден");
            }
        }
    }

    /**
     * Метод для сохранения данных
     *
     * @return
     */
    @Override
    public boolean saveData() {
        try {
            dataBase.saveData(collection);
            return true;
        } catch (IOException e) {
            if (dataBase.checkFileExist()) {
                System.out.println("Ошибка доступа к файлу для сохранения");
            } else{
                System.out.println("Файл для сохранения не найден");
            }
            return false;
        }
    }
}
