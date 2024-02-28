package org.chousik.collection


class MusicBand(name: String, coordinates: Coordinates, numberOfParticipants: Long, albumsCount: Long, genre: MusicGenre, person: Person) : Comparable<MusicBand> {
    private var id = (Math.random() * 666666).toInt()
        get() = field
        set(value) {
            field = value
        }
    private var name = name
        get() = field
        set(value) {
            field = value
        }
    private var coordinates = coordinates
        get() = field
        set(value) {
            field = value
        }
    private var numberOfParticipants= numberOfParticipants
        get() = field
        set(value) {
            field = value
        }
    private var albumsCount= albumsCount
        get() = field
        set(value) {
            field = value
        }
    private var genre = genre
        get() = field
        set(value) {
            field = value
        }
    private var frontMan = person
        get() = field
        set(value) {
            field = value
        }

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