package commands

import scanners.MyScanners

class CountByNumbersOfParticipantsArgumentsMaker : MakerArguments<Long>(1) {
    override fun make(
        arguments: Array<String>,
        scanner: MyScanners,
    ): Long {
        validCounts(arguments.size)
        return arguments[0].toLong()
    }
}
