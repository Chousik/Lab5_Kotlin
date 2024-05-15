package collection

import java.io.Serializable

data class Person(
    var name: String,
    var passportID: String,
    var hairColor: Color?,
    var nationality: Country?,
    var location: Location,
) : Comparable<Person>, Serializable {
    override fun compareTo(other: Person): Int {
        return nationality!!.ordinal - other.nationality!!.ordinal
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
