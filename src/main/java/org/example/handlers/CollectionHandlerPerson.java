package org.example.handlers;

import org.example.collection.MusicBand;
import org.example.collection.Person;
import org.example.collection.builder.BuilderMusicBand;
import org.example.database.InterfaceDataBase;
import org.example.exception.IncorrectArguments;
import org.example.exception.ScriptRunErorr;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class CollectionHandlerPerson implements CollectionHandlerIntefrace<MusicBand> {
    private LinkedList<MusicBand> collection = new LinkedList<>();
    private InterfaceDataBase DataBase;
    private LocalDateTime lastInitTime = LocalDateTime.now();
    public CollectionHandlerPerson(InterfaceDataBase DB){
        this.DataBase = DB;
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
        return String.join("\n", collection.stream().filter(x -> x.getAlbumsCount() == integer).map(MusicBand::toString).toList());
    }

    @Override
    public String getElements() {
        if (collection.isEmpty()){
            return "Пустая колеекция!";
        }
        return String.join("\n", collection.stream().map(MusicBand::toString).toList());
    }
    @Override
    public void updateElements(Integer id) throws IncorrectArguments, ScriptRunErorr {
        try {
            MusicBand musicBand = collection.stream().filter(x -> x.getId() == id).findFirst().get();
            musicBand.update(new BuilderMusicBand().build());
        } catch (NoSuchElementException e){
            throw new IncorrectArguments("Группы с таким айди не сущетсвует.");
        }
    }

    @Override
    public void RemoveElements(Integer index) throws IncorrectArguments {
        if (index > collection.size()-1 || index<0){
            throw new IncorrectArguments("Неверное id: " + index + ". Длина коллекции: " + collection.size());
        }
        System.out.println(index);
        System.out.println(collection.remove(index));
    }

    @Override
    public void Clear() {
        collection.clear();
        lastInitTime = LocalDateTime.now();
    }

    @Override
    public void Shuffle() {
        Collections.shuffle(collection);
    }
    /**
     * Переворачивает коллекцию
     */
    @Override
    public void Reorder() {
        java.util.Collections.reverse(collection);
    }
    /**
     * Удаляет элементы коллекции по переданному айди
     * @param id
     * @throws IncorrectArguments
     */
    @Override
    public void RemoveElementByID(Integer id) throws IncorrectArguments{
        try {
            MusicBand musicBand = collection.stream().filter(x -> x.getId() == id).findFirst().get();
            collection.remove(musicBand);
        } catch (NoSuchElementException e){
            throw new IncorrectArguments("Группы с таким айди не сущетсвует.");
        }
    }
    /**
     * Удаляет элементы коллекции по переданному лидеру
     * @param person
     * @throws IncorrectArguments
     */
    @Override
    public void RemoveByFrontMan(Person person) throws IncorrectArguments{
        try {
            MusicBand musicBand = collection.stream().filter(x -> x.getFrontMan() == person).findFirst().get();
            collection.remove(musicBand);
        } catch (NoSuchElementException e){
            throw new IncorrectArguments("Группы с таким лидером не сущетсвует.");
        }
    }

    @Override
    public int CountNumberOfParticipants(Long longs) {
        return collection.stream().filter(x -> x.getNumberOfParticipants() == longs).toList().size();
    }

    @Override
    public void LoadData()  {
        try {
            collection = DataBase.LoadData();
        } catch (Exception e){
            System.out.println(e);
            System.out.println("Хуйня");
        }
    }

    @Override
    public void SaveData() {
        try {
            DataBase.SaveData(collection);
        } catch (Exception e ){
            System.out.println(e);
            System.out.println("Хуйня");
        }
    }
}
