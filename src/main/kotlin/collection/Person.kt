package org.chousik.collection

import java.util.*
class Person(
    private var name: String,
    private var passportID: String,
    private var hairColor: Color,
    private var nationality: Country,
    private var location: Location
) : Comparable<Person> {

    override fun compareTo(other: Person): Int {
        return nationality.ordinal - other.nationality.ordinal
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false
        val person = other as Person
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