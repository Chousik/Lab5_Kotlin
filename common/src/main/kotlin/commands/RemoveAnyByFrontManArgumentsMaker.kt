package commands

import collection.Person
import collection.builder.BuilderPerson
import java.util.*

class RemoveAnyByFrontManArguments: MakerArguments<Person>(CommandType.RemoveAnyByFrontMan.countArguments) {
    override fun make(arguments: Array<String>, scanner: Scanner): Person {
        validCounts(arguments.size)
        return BuilderPerson(scanner).build()
    }
}