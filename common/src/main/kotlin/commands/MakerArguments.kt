package commands

import exeption.ArgumentCountError
import scanners.MyScanners

abstract class MakerArguments<T>(private val countArguments: Int){
    abstract fun make(arguments: Array<String>, scanner: MyScanners) : T
    fun validCounts(count: Int){
        if (countArguments!=count){
            throw ArgumentCountError(countArguments, count)
        }
    }
}