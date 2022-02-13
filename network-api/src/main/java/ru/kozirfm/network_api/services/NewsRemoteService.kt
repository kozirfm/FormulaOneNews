package ru.kozirfm.network_api.services

import kotlinx.coroutines.Deferred

interface NewsRemoteService {
    fun getNewsAsync(count: Int): Deferred<String>
}