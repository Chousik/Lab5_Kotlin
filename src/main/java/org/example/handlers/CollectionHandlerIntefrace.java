package org.example.handlers;

import org.example.collection.Person;
import org.example.exception.IncorrectArguments;
import org.example.exception.ScriptRunErorr;

import java.time.LocalDateTime;
import java.util.LinkedList;

public interface CollectionHandlerIntefrace<T extends Comparable> {

    void add(T t);
    LocalDateTime getLastInitTime();
    String getCollectionType();
    public LinkedList<T> getCollection();
    int size();
    String getElements();
    String getElementsByAlbomCount(Integer integer);
    void updateElements(Integer id) throws IncorrectArguments, ScriptRunErorr;
    void RemoveElements(Integer index) throws IncorrectArguments;
    void Clear();
    void RemoveElementByID(Integer id) throws IncorrectArguments;
    void Shuffle();
    void Reorder();
    void RemoveByFrontMan(Person person) throws IncorrectArguments;
    int CountNumberOfParticipants(Long longs);
    void LoadData();
    void SaveData();
}
