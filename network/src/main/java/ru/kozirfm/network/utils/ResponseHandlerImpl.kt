package ru.kozirfm.network.utils

import kotlinx.coroutines.Deferred
import ru.kozirfm.network_api.entity.ServerResponse
import ru.kozirfm.network_api.utils.ResponseError
import ru.kozirfm.network_api.utils.ResponseHandler
import ru.kozirfm.network_api.utils.ResponseState
import ru.kozirfm.network_api.utils.ResponseSuccess

@Suppress("UNCHECKED_CAST")
class ResponseHandlerImpl : ResponseHandler {

    override suspend fun <T, R> handleResponse(
        deferred: Deferred<ServerResponse<*>>,
        body: (T) -> R
    ): ResponseState {
        return getResponseState(deferred, body)
    }

    override suspend fun <T> handleResponse(deferred: Deferred<ServerResponse<*>>): ResponseState {
        return getResponseState<T, Nothing>(deferred)
    }

    private suspend fun <T, R> getResponseState(
        deferred: Deferred<ServerResponse<*>>,
        body: ((T) -> R)? = null
    ): ResponseState {
        val response = deferred.await()
        return if (response.state == STATE_OK) {
            ResponseSuccess(body?.invoke(response.result as T) ?: response.result as T)
        } else {
            ResponseError(response.code, response.message)
        }
    }

    private companion object {
        const val STATE_OK = "OK"
    }

}