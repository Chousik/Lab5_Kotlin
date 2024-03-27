package commands

import scanners.MyScanners
import java.util.*

class CountByNumbersOfParticipantsArgumentsMaker: MakerArguments<Long>(1) {
    override fun make(arguments: Array<String>, scanner: MyScanners): Long {
        validCounts(arguments.size)
        return arguments[0].toLong()
    }
}