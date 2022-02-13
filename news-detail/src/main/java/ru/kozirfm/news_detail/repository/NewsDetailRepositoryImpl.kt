package ru.kozirfm.news_detail.repository

import ru.kozirfm.network_api.utils.ResponseState
import ru.kozirfm.news_detail.datasource.NewsDetailRemoteDataSource
import javax.inject.Inject

class NewsDetailRepositoryImpl @Inject constructor(
    private val remoteDataSource: NewsDetailRemoteDataSource
) : NewsDetailRepository {
    override suspend fun getNewsById(id: Long): ResponseState {
        return remoteDataSource.getNewsById(id)
    }
}