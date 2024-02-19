package org.example.database;

import java.io.IOException;
import java.util.LinkedList;

public interface IDataBase<T> {
    void saveData(LinkedList<T> collection) throws IOException;
    LinkedList<T> loadData() throws IOException;
}
