package commands

import java.util.*

class RemoveAtcountArguments: MakerArguments<Int>(CommandType.RemoveAt.countArguments) {
    override fun make(arguments: Array<String>, scanner: Scanner): Int {
        validCounts(arguments.size)
        return arguments[0].toInt()
    }
}