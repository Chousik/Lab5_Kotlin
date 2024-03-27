package commands

import response.CommandResponse
import response.ResponseStatus


abstract class ACommand(private val nameValue: String, private val info: String,protected var successfullyInfo: String = "") {
    val name: String
        get() {
            return nameValue
        }
    fun execute(arg: Any?): CommandResponse{
        try {
            doIt(arg)
            return CommandResponse(ResponseStatus.Successfully, successfullyInfo)
        }catch (e: Exception){
            return CommandResponse(ResponseStatus.ExecutionError, e.toString())
        }
    }
    abstract fun doIt(arg: Any?)

    override fun toString(): String {
        return "${this.nameValue}: ${this.info}"
    }
}