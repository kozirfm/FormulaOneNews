package ru.kozirfm.network_api.services

import kotlinx.coroutines.Deferred
import ru.kozirfm.network_api.entity.ServerResponse

interface LoginRemoteService {
    fun signInAsync(): Deferred<ServerResponse<*>>
    fun signUpAsync(): Deferred<ServerResponse<*>>
}