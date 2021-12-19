package ru.kozirfm.network_api.services

import kotlinx.coroutines.Deferred

interface LoginRemoteService {
    fun signInAsync(body: String): Deferred<String>
    fun signUpAsync(body: String): Deferred<String>
}