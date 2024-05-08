package request

import collection.AuthorizationData
import java.io.Serializable

class RequestClient(val request: Request, val authorizationData: AuthorizationData) : Serializable
