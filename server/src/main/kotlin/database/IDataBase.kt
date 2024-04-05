package database

import java.util.LinkedList

interface IDataBase<T> {
    fun saveData(collection: LinkedList<T>)

    fun loadData(): LinkedList<T>

    fun checkFileExist(): Boolean
}
