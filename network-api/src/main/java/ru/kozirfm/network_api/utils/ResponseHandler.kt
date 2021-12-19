package ru.kozirfm.network_api.utils

import kotlinx.coroutines.Deferred

interface ResponseHandler {

    suspend fun <T> handleResponse(response: Deferred<String>, body: (String) -> T): ResponseState

}