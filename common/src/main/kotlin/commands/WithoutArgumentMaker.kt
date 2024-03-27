package commands

import exeption.ArgumentCountError

class WithoutArgumentMaker: MakerArguments<Unit>(CommandType.Clear) {
    override fun make(arguments: Array<String>) {
        if (!(validCounts(arguments.size))){
            throw ArgumentCountError(CommandType.Add.countArguments, arguments.size)
        }
    }
}