package org.chousik.collection

/**
 * Класс музыкальная группа
 */
class MusicBand : Comparable<MusicBand> {
    private var id = 0
    private var name: String? = null //Поле не может быть null, Строка не может быть пустой
    private var coordinates: Сoordinates? = null //Поле не может быть null
    private var numberOfParticipants: Long = 0 //Значение поля должно быть больше 0
    private var albumsCount: Long = 0 //Значение поля должно быть больше 0
    private var genre: MusicGenre? = null //Поле не может быть null
    private var frontMan: Person? = null //Поле может быть null

    constructor()
    fun getCoordinates(): Сoordinates?{
        return coordinates
    }
    fun getId(): Int{
        return id;
    }
    fun getName(): String? {
        return name;
    }
    fun getFrontMan(): Person? {
        return frontMan;
    }
    fun getNumberOfParticipants(): Long{
        return numberOfParticipants;
    }
    fun getAlbumsCount(): Long{
        return albumsCount;
    }
    fun getGenre(): MusicGenre? {
        return genre;
    }
    constructor(name: String?, coordinates: Сoordinates?, l1: Long, l2: Long, genre: MusicGenre?, person: Person?) {
        this.id = (Math.random() * 666666).toInt()
        this.name = name
        this.coordinates = coordinates
        this.numberOfParticipants = l1
        this.albumsCount = l2
        this.genre = genre
        this.frontMan = person
    }

    override fun toString(): String {
        return (("MusicBand{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinates=" + coordinates.toString()).toString() +
                ", numberOfParticipants=" + numberOfParticipants +
                ", albumsCount=" + albumsCount +
                ", genre=" + genre.toString()).toString() +
                ", frontMan=" + frontMan.toString() +
                '}'
    }

    override fun compareTo(o: MusicBand): Int {
        return (this.id - o.id)
    }

    fun setName(name: String) {
        this.name = name;
    }
    fun setCoordinates(coordinates: Сoordinates?){
        this.coordinates = coordinates;
    }
    fun setNumberOfParticipants(number: Long){
        this.numberOfParticipants = number;
    }
    fun setAlbumsCount(number: Long){
        this.albumsCount = number;
    }
    fun setGenre(genre: MusicGenre?){
        this.genre = genre;
    }
    fun setFrontMan(person: Person?){
        this.frontMan = person;
    }
}