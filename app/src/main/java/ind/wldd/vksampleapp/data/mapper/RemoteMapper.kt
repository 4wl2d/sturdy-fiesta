package ind.wldd.vksampleapp.data.mapper

import ind.wldd.vksampleapp.domain.models.ApiError
import ind.wldd.vksampleapp.domain.models.NetworkError
import retrofit2.HttpException
import java.io.IOException

fun Throwable.toNetworkError(): NetworkError {
    val error = when(this) {
        is IOException -> ApiError.NetworkError
        is HttpException -> ApiError.UnknownResponse
        else -> ApiError.UnknownError
    }
    return NetworkError(
        error = error,
        throwable = this
    )
}