package ru.kozirfm.network.utils

import ru.kozirfm.network_api.entity.ServerResponse
import ru.kozirfm.network_api.utils.ResponseError
import ru.kozirfm.network_api.utils.ResponseHandler
import ru.kozirfm.network_api.utils.ResponseState
import ru.kozirfm.network_api.utils.ResponseSuccess


class ResponseHandlerImpl : ResponseHandler {

    override fun <T, R> handleResponse(
        response: ServerResponse<T>,
        body: (T) -> R
    ): ResponseState {
        return getResponseState(response, body)
    }

    override fun <T> handleResponse(response: ServerResponse<T>): ResponseState {
        return getResponseState<T, Nothing>(response)
    }

    private fun <T, R> getResponseState(
        response: ServerResponse<T>,
        body: ((T) -> R)? = null
    ): ResponseState {
        return if (response.state == STATE_OK) {
            ResponseSuccess(body?.invoke(response.result) ?: response.result)
        } else {
            ResponseError(response.code, response.message)
        }
    }

    private companion object {
        const val STATE_OK = "OK"
    }

}