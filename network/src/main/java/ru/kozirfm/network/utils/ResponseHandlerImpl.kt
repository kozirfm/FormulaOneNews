package ru.kozirfm.network.utils

import kotlinx.coroutines.Deferred
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import ru.kozirfm.network_api.entity.ServerResponse
import ru.kozirfm.network_api.utils.ResponseError
import ru.kozirfm.network_api.utils.ResponseHandler
import ru.kozirfm.network_api.utils.ResponseState
import ru.kozirfm.network_api.utils.ResponseSuccess


class ResponseHandlerImpl : ResponseHandler {

    override suspend fun <T> handleResponse(
        response: Deferred<String>,
        body: (String) -> T
    ): ResponseState {
        return getResponseState(response, body)
    }

    private suspend fun <T> getResponseState(
        deferred: Deferred<String>,
        body: (String) -> T
    ): ResponseState {
        val json = deferred.await()
        val jsonConfig = Json { ignoreUnknownKeys = true }
        val response = jsonConfig.decodeFromString<ServerResponse>(json)
        return if (response.state == STATE_OK) {
            ResponseSuccess(body.invoke(response.result))
        } else {
            ResponseError(response.code, response.message)
        }
    }

    private companion object {
        const val STATE_OK = "OK"
    }

}