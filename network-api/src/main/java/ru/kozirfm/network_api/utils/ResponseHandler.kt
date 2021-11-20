package ru.kozirfm.network_api.utils

import kotlinx.coroutines.Deferred
import ru.kozirfm.network_api.entity.ServerResponse

interface ResponseHandler {

    @Suppress("UNCHECKED_CAST")
    suspend fun <T, R> handleResponse(deferred: Deferred<ServerResponse<*>>, body: (T) -> R): ResponseState

    suspend fun <T> handleResponse(deferred: Deferred<ServerResponse<*>>): ResponseState

}