package ru.kozirfm.network_api.services

import kotlinx.coroutines.Deferred
import ru.kozirfm.network_api.entity.ServerResponse

interface NewsRemoteService {

    fun getArticlesAsync(count: Int): Deferred<ServerResponse<*>>

}