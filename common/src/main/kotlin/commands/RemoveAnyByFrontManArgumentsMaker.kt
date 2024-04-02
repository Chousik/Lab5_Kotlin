package commands

import collection.Person
import collection.builder.BuilderPerson
import scanners.MyScanners
class RemoveAnyByFrontManArgumentsMaker: MakerArguments<Person>(0) {
    override fun make(arguments: Array<String>, scanner: MyScanners): Person {
        validCounts(arguments.size)
        return BuilderPerson(scanner).build()
    }
}