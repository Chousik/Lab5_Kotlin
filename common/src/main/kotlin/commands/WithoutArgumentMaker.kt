package commands

import collection.NothingObject
import scanners.MyScanners
import java.util.*

class WithoutArgumentMaker: MakerArguments<Any>(0) {
    override fun make(arguments: Array<String>, scanner: MyScanners): NothingObject {
        validCounts(arguments.size)
        return NothingObject()
    }
    companion object {
        private var maker = WithoutArgumentMaker()
        fun get(): WithoutArgumentMaker{
            return maker
        }
    }
}