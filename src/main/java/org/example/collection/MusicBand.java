package org.example.collection;

import java.time.ZonedDateTime;
/**
 * Класс музыкальная группа
 */
public class MusicBand implements Comparable<MusicBand>{
    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Сoordinates coordinates; //Поле не может быть null
    private java.time.ZonedDateTime creationDate = java.time.ZonedDateTime.now(); //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private long numberOfParticipants; //Значение поля должно быть больше 0
    private long albumsCount; //Значение поля должно быть больше 0
    private MusicGenre genre; //Поле не может быть null
    private Person frontMan; //Поле может быть null
    public MusicBand(){}
    public MusicBand(String name, Сoordinates coordinates, long l1, long l2, MusicGenre genre, Person person) {
        this.id = (int) (Math.random() * 666666);
        this.name = name;
        this.coordinates = coordinates;
        this.numberOfParticipants = l1;
        this.albumsCount = l2;
        this.genre = genre;
        this.frontMan = person;

    }
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Сoordinates getCoordinates() {
        return coordinates;
    }

    public long getAlbumsCount() {
        return albumsCount;
    }

    public long getNumberOfParticipants() {
        return numberOfParticipants;
    }

    public MusicGenre getGenre() {
        return genre;
    }

    public ZonedDateTime getCreationDate() {
        return creationDate;
    }

    public Person getFrontMan() {
        return frontMan;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCoordinates(Сoordinates coordinates) {
        this.coordinates = coordinates;
    }

    public void setCreationDate(ZonedDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public void setFrontMan(Person frontMan) {
        this.frontMan = frontMan;
    }

    public void setAlbumsCount(long albumsCount) {
        this.albumsCount = albumsCount;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setGenre(MusicGenre genre) {
        this.genre = genre;
    }

    public void setNumberOfParticipants(long numberOfParticipants) {
        this.numberOfParticipants = numberOfParticipants;
    }
    @Override
    public String toString() {
        return "MusicBand{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinates=" + coordinates.toString() +
                ", creationDate=" + creationDate +
                ", numberOfParticipants=" + numberOfParticipants +
                ", albumsCount=" + albumsCount +
                ", genre=" + genre.toString() +
                ", frontMan=" + frontMan.toString() +
                '}';
    }

    @Override
    public int compareTo(MusicBand o) {
        return (this.id-o.getId());
    }
}
