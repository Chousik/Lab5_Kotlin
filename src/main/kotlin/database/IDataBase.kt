package org.chousik.database

import org.chousik.collection.MusicBand
import java.util.*


interface IDataBase<T> {

    fun saveData(collection: LinkedList<T>)


    fun loadData(): LinkedList<T>


    fun checkFileExist(): Boolean
}