package ind.wldd.vksampleapp.domain.models

data class NetworkError (
    val error: ApiError,
    val throwable: Throwable? = null
)

enum class ApiError(val message: String) {
    NetworkError("Network Error"),
    UnknownResponse("Unknown Response"),
    UnknownError("Unknown Error")
}