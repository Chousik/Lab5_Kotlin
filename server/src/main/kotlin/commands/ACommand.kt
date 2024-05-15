package commands

import response.CommandResponse
import response.ResponseStatus

abstract class ACommand(private val nameValue: String, private val info: String, protected var successfullyInfo: String = "") {
    val name: String
        get() {
            return nameValue
        }

    fun execute(
        arg: Any?,
        id: Int,
    ): CommandResponse {
        try {
            doIt(arg, id)
            return CommandResponse(ResponseStatus.Successfully, successfullyInfo)
        } catch (e: Exception) {
            return CommandResponse(ResponseStatus.ExecutionError, e.toString())
        }
    }

    abstract fun doIt(
        arg: Any?,
        id: Int,
    )

    override fun toString(): String {
        return "${this.nameValue}: ${this.info}"
    }
}
