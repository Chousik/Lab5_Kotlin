package org.chousik.collection;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

/**
 * Класс персона
 */
@Getter
@Setter
public class Person implements Comparable<Person> {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private String passportID; //Строка не может быть пустой, Длина строки должна быть не меньше 6, Поле не может быть null
    private Color hairColor; //Поле не может быть null
    private Country nationality; //Поле может быть null
    private Location location; //Поле не может быть null

    public Person() {
    }

    public Person(String name, String PassportID, Color color, Country country, Location location) {
        this.name = name;
        this.passportID = PassportID;
        this.location = location;
        this.hairColor = color;
        this.nationality = country;
    }

    @Override
    public int compareTo(Person o) {
        return this.nationality.ordinal() - o.nationality.ordinal();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) && Objects.equals(passportID, person.passportID) && hairColor == person.hairColor && nationality == person.nationality && Objects.equals(location, person.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, passportID, hairColor, nationality, location);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", passportID='" + passportID + '\'' +
                ", hairColor=" + hairColor.toString() +
                ", nationality=" + nationality.toString() +
                ", location=" + location.toString() +
                '}';
    }
}