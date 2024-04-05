import collection.MusicBand
import collection.Person
import java.time.LocalDateTime
import java.util.LinkedList

interface ICollectionController<T : Comparable<*>> {
    fun add(t: MusicBand)

    val lastInitTime: LocalDateTime?

    val collectionType: String

    val collection: LinkedList<T>

    fun size(): Int

    val elements: String

    fun getElementsByAlbumCount(integer: Int): String

    fun removeElements(index: Int)

    fun clear()

    fun removeElementByID(id: Int)

    fun shuffle()

    fun reorder()

    fun removeByFrontMan(person: Person)

    fun countNumberOfParticipants(longs: Long): Int

    fun loadData()

    fun saveData(): Boolean

    fun updateElements(
        id: Int,
        musicBandNew: MusicBand,
    )
}
