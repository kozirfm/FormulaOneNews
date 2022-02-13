package ru.kozirfm.news.datasource

import ru.kozirfm.network_api.utils.ResponseState

interface NewsRemoteDataSource {
    suspend fun getNews(): ResponseState
}