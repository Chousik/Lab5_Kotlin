package response

import java.io.Serializable

data class CommandResponse(val status: ResponseStatus, val message: String): Serializable {
}