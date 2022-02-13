package ru.kozirfm.network_api.services

import kotlinx.coroutines.Deferred

interface NewsDetailRemoteService {
    fun getNewsByIdAsync(id: Long): Deferred<String>
}