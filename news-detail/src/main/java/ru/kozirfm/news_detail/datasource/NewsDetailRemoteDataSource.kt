package ru.kozirfm.news_detail.datasource

import ru.kozirfm.network_api.utils.ResponseState

interface NewsDetailRemoteDataSource {
    suspend fun getNewsById(id: Long): ResponseState
}