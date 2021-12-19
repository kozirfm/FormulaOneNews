package ru.kozirfm.network_api.services

import kotlinx.coroutines.Deferred

interface NewsRemoteService {

    fun getArticlesAsync(count: Int): Deferred<String>

}