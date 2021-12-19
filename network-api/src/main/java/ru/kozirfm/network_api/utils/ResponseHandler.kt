package ru.kozirfm.network_api.utils

import ru.kozirfm.network_api.entity.ServerResponse

interface ResponseHandler {

    fun <T, R> handleResponse(response: ServerResponse<T>, body: (T) -> R): ResponseState
    fun <T> handleResponse(response: ServerResponse<T>): ResponseState

}