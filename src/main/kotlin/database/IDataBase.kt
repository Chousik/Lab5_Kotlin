package org.chousik.database

import org.chousik.collection.MusicBand
import java.io.IOException
import java.util.*


interface IDataBase<T> {

    @Throws(IOException::class)
    fun saveData(collection: LinkedList<T>?)


    @Throws(IOException::class)
    fun loadData(): LinkedList<MusicBand>


    fun checkFileExist(): Boolean
}