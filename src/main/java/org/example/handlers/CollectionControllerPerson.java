package org.example.handlers;

import org.example.collection.MusicBand;
import org.example.collection.Person;
import org.example.collection.builder.BuilderMusicBand;
import org.example.database.IDataBase;
import org.example.exception.ArgumentError;
import org.example.exception.ScriptExecutionError;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class CollectionControllerPerson implements ICollectionController<MusicBand> {
    private LinkedList<MusicBand> collection = new LinkedList<>();
    private IDataBase dataBase;
    private LocalDateTime lastInitTime = LocalDateTime.now();
    public CollectionControllerPerson(IDataBase DB){
        this.dataBase = DB;
    }

    @Override
    public void add(MusicBand musicBand) {
        collection.add(musicBand);
    }
    @Override
    public LocalDateTime getLastInitTime() {
        return lastInitTime;
    }

    @Override
    public String getCollectionType() {
        return collection.getClass().getName();
    }

    @Override
    public LinkedList<MusicBand> getCollection() {
        return collection;
    }

    @Override
    public int size() {
        return collection.size();
    }

    @Override
    public String getElementsByAlbomCount(Integer integer) {
        if (collection.isEmpty()){return "Пустая колеекция!";}
        String result = String.join("\n", collection.stream().filter(x -> x.getAlbumsCount() == integer).map(MusicBand::toString).toList());
        if (result.isEmpty()){
            return "Нет таких групп";
        }
        return result;
    }

    @Override
    public String getElements() {
        if (collection.isEmpty()){
            return "Пустая колеекция!";
        }
        return String.join("\n", collection.stream().map(MusicBand::toString).toList());
    }
    @Override
    public void updateElements(Integer id) throws ArgumentError, ScriptExecutionError {
        try {
            MusicBand musicBand = collection.stream().filter(x -> x.getId() == id).findFirst().get();
            new BuilderMusicBand().reBuild(musicBand);
        } catch (NoSuchElementException e){
            throw new ArgumentError("Группы с таким айди не сущетсвует.");
        }
    }

    @Override
    public void removeElements(Integer index) throws ArgumentError {
        if (index > collection.size()-1 || index<0){
            throw new ArgumentError("Неверное id: " + index + ". Длина коллекции: " + collection.size());
        }
        MusicBand musicBand = collection.get(index);
        collection.remove(musicBand);
    }

    @Override
    public void clear() {
        collection.clear();
        lastInitTime = LocalDateTime.now();
    }

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
     * @param id
     * @throws ArgumentError
     */
    @Override
    public void removeElementByID(Integer id) throws ArgumentError {
        try {
            MusicBand musicBand = collection.stream().filter(x -> x.getId() == id).findFirst().get();
            collection.remove(musicBand);
        } catch (NoSuchElementException e){
            throw new ArgumentError("Группы с таким айди не сущетсвует.");
        }
    }
    /**
     * Удаляет элементы коллекции по переданному лидеру
     * @param person
     * @throws ArgumentError
     */
    @Override
    public void removeByFrontMan(Person person) throws ArgumentError {
        try {
            MusicBand musicBand = collection.stream().filter(x -> x.getFrontMan().equals(person)).findFirst().get();
            collection.remove(musicBand);
        } catch (NoSuchElementException e){
            throw new ArgumentError("Группы с таким лидером не сущетсвует.");
        }
    }

    @Override
    public int countNumberOfParticipants(Long longs) {
        return collection.stream().filter(x -> x.getNumberOfParticipants() == longs).toList().size();
    }

    @Override
    public void loadData()  {
        try {
            collection = dataBase.loadData();
        } catch (Exception e){
            System.out.println(e);
            System.out.println("Хуйня");
        }
    }

    @Override
    public void saveData() {
        try {
            dataBase.saveData(collection);
        } catch (Exception e ){
            System.out.println(e);
            System.out.println("Хуйня");
        }
    }
}
