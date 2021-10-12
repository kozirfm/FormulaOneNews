package ru.kozirfm.network_api.services

import kotlinx.coroutines.Deferred
import retrofit2.Response

interface NewsRemoteService {

    fun getArticlesAsync(count: Int): Deferred<Response<*>>

}