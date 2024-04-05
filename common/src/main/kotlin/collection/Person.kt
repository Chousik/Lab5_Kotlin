package collection

import java.io.Serializable

data class Person(
    private var name: String,
    private var passportID: String,
    private var hairColor: Color?,
    private var nationality: Country?,
    private var location: Location,
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
