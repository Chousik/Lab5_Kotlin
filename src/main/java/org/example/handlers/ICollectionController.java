package org.example.handlers;

import org.example.collection.Person;
import org.example.exception.ArgumentError;
import org.example.exception.ScriptExecutionError;

import java.time.LocalDateTime;
import java.util.LinkedList;

public interface ICollectionController<T extends Comparable> {

    void add(T t);
    LocalDateTime getLastInitTime();
    String getCollectionType();
    public LinkedList<T> getCollection();
    int size();
    String getElements();
    String getElementsByAlbomCount(Integer integer);
    void updateElements(Integer id) throws ArgumentError, ScriptExecutionError;
    void removeElements(Integer index) throws ArgumentError;
    void clear();
    void removeElementByID(Integer id) throws ArgumentError;
    void shuffle();
    void reorder();
    void removeByFrontMan(Person person) throws ArgumentError;
    int countNumberOfParticipants(Long longs);
    void loadData();
    void saveData();
}
