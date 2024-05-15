
import collection.MusicBand
import collection.Person
import java.time.LocalDateTime
import java.util.LinkedList

interface ICollectionController<T : Comparable<*>> {
    val lastInitTime: LocalDateTime?

    val collectionType: String

    val collection: LinkedList<T>

    fun size(): Int

    val elements: String

    fun getElementsByAlbumCount(integer: Int): String

    fun removeElements(
        index: Int,
        userId: Int,
    )

    fun clear(id: Int)

    fun removeElementByID(
        id: Int,
        userId: Int,
    )

    fun shuffle()

    fun reorder()

    fun removeByFrontMan(
        person: Person,
        userId: Int,
    )

    fun countNumberOfParticipants(longs: Long): Int

    fun loadData()

    fun saveData(): Boolean

    fun updateElements(
        id: Int,
        userId: Int,
        musicBandNew: MusicBand,
    )

    fun add(
        t: MusicBand,
        id: Int,
    )
}
