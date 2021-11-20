package ru.kozirfm.news.datasourse

import ru.kozirfm.network_api.utils.ResponseState

interface NewsRemoteDataSource {
    suspend fun getNews(): ResponseState
}