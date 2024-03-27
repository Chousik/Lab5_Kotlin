package collection

import java.io.Serializable


class MusicBand (
    var name: String, var coordinates: Coordinates, var numberOfParticipants: Long,
    var albumsCount: Long, var genre: MusicGenre, var frontMan: Person
) : Comparable<MusicBand>, Serializable {
    var id = (Math.random() * 666666).toInt()

    override fun toString(): String {
        return (("MusicBand{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinates=" + coordinates.toString()) +
                ", numberOfParticipants=" + numberOfParticipants +
                ", albumsCount=" + albumsCount +
                ", genre=" + genre.toString()) +
                ", frontMan=" + frontMan.toString() +
                '}'
    }

    override fun compareTo(other: MusicBand): Int {
        return (this.id - other.id)
    }
}