package ru.kozirfm.network_api.utils

import kotlinx.coroutines.Deferred
import retrofit2.Response

interface ResponseHandler {

    @Suppress("UNCHECKED_CAST")
    suspend fun <T, R> handleResponse(deferred: Deferred<Response<*>>, body: (T) -> R): ResponseState

}