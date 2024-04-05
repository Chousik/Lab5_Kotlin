package request

import commands.CommandType
import java.io.Serializable

data class Request(val type: CommandType, val argument: Any?) : Serializable
