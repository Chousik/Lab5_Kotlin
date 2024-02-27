package org.chousik.collection

import lombok.Getter
import lombok.Setter
import java.util.*

/**
 * Класс персона
 */
@Getter
@Setter
class Person : Comparable<Person?> {
    private var name: String? = null //Поле не может быть null, Строка не может быть пустой
    private var passportID: String? =
        null //Строка не может быть пустой, Длина строки должна быть не меньше 6, Поле не может быть null
    private var hairColor: Color? = null //Поле не может быть null
    private var nationality: Country? = null //Поле может быть null
    private var location: Location? = null //Поле не может быть null

    constructor()

    constructor(name: String?, PassportID: String?, color: Color?, country: Country?, location: Location?) {
        this.name = name
        this.passportID = PassportID
        this.location = location
        this.hairColor = color
        this.nationality = country
    }

    override fun compareTo(o: Person?): Int {
        return nationality!!.ordinal - o?.nationality!!.ordinal
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false
        val person = o as Person
        return name == person.name && passportID == person.passportID && hairColor == person.hairColor && nationality == person.nationality && location == person.location
    }

    override fun hashCode(): Int {
        return Objects.hash(name, passportID, hairColor, nationality, location)
    }

    override fun toString(): String {
        return "Person{" +
                "name='" + name + '\'' +
                ", passportID='" + passportID + '\'' +
                ", hairColor=" + hairColor.toString() +
                ", nationality=" + nationality.toString() +
                ", location=" + location.toString() +
                '}'
    }
}