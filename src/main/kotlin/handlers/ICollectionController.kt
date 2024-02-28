package org.chousik.handlers

import org.chousik.collection.MusicBand
import org.chousik.collection.Person
import org.chousik.exception.ArgumentError
import org.chousik.exception.ScriptExecutionError
import java.time.LocalDateTime
import java.util.*

interface ICollectionController<T : Comparable<*>?> {

    fun add(t: MusicBand)

    val lastInitTime: LocalDateTime?

    val collectionType: String?

    val collection: LinkedList<T>?

    fun size(): Int

    val elements: String?

    fun getElementsByAlbomCount(integer: Int?): String?

    @Throws(ArgumentError::class, ScriptExecutionError::class)
    fun updateElements(id: Int?)

    @Throws(ArgumentError::class)
    fun removeElements(index: Int?)

    fun clear()

    @Throws(ArgumentError::class)
    fun removeElementByID(id: Int?)

    fun shuffle()

    fun reorder()

    @Throws(ArgumentError::class)
    fun removeByFrontMan(person: Person?)

    fun countNumberOfParticipants(longs: Long?): Int

    fun loadData()

    fun saveData(): Boolean
}