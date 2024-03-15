package org.chousik.database

import java.util.*


interface IDataBase<T> {

    fun saveData(collection: LinkedList<T>)


    fun loadData(): LinkedList<T>


    fun checkFileExist(): Boolean
}