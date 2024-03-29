package org.chousik.handlers

import org.chousik.collection.MusicBand
import org.chousik.collection.Person
import java.time.LocalDateTime
import java.util.*

interface ICollectionController<T : Comparable<*>> {

    fun add(t: MusicBand)

    val lastInitTime: LocalDateTime?

    val collectionType: String

    val collection: LinkedList<T>

    fun size(): Int

    val elements: String

    fun getElementsByAlbumCount(integer: Int): String

    fun updateElements(id: Int)

    fun removeElements(index: Int)

    fun clear()

    fun removeElementByID(id: Int)

    fun shuffle()

    fun reorder()

    fun removeByFrontMan(person: Person)

    fun countNumberOfParticipants(longs: Long): Int

    fun loadData()

    fun saveData(): Boolean
}