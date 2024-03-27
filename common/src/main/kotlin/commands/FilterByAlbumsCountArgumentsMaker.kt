package commands

import scanners.MyScanners
import java.util.*

class FilterByAlbumsCountArgumentsMaker: MakerArguments<Int>(1) {
    override fun make(arguments: Array<String>, scanner: MyScanners): Int {
        validCounts(arguments.size)
        return arguments[0].toInt()
    }
}