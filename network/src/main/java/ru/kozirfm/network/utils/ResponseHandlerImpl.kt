package ru.kozirfm.network.utils

import kotlinx.coroutines.Deferred
import retrofit2.Response
import ru.kozirfm.network_api.utils.ResponseError
import ru.kozirfm.network_api.utils.ResponseHandler
import ru.kozirfm.network_api.utils.ResponseState
import ru.kozirfm.network_api.utils.ResponseSuccess

class ResponseHandlerImpl : ResponseHandler {

    @Suppress("UNCHECKED_CAST")
    override suspend fun <T, R> handleResponse(
        deferred: Deferred<Response<*>>,
        body: (T) -> R
    ): ResponseState {
        val response = deferred.await()
        return if (response.isSuccessful) {
            ResponseSuccess(body(response.body() as T))
        } else {
            ResponseError(response.code(), response.message())
        }
    }

}