package org.example.collection;

import java.time.ZonedDateTime;

public class MusicBand implements Comparable<MusicBand>{
    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.ZonedDateTime creationDate = java.time.ZonedDateTime.now(); //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private long numberOfParticipants; //Значение поля должно быть больше 0
    private long albumsCount; //Значение поля должно быть больше 0
    private MusicGenre genre; //Поле не может быть null
    private Person frontMan; //Поле может быть null
    public MusicBand(){}
    public MusicBand(String name, Coordinates coordinates, long l1, long l2, MusicGenre genre, Person person) {
        this.id = (int) (Math.random() * 30000);
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

    public Coordinates getCoordinates() {
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
    public void update(MusicBand musicBand){
        this.name = musicBand.name;
        this.genre = musicBand.genre;
        this.albumsCount = musicBand.albumsCount;
        this.frontMan = musicBand.frontMan;
        this.numberOfParticipants = musicBand.numberOfParticipants;
        this.coordinates = musicBand.coordinates;
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
