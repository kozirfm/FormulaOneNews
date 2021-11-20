package ru.kozirfm.news.repository

import ru.kozirfm.network_api.utils.ResponseState
import ru.kozirfm.news.datasourse.NewsLocalDataSource
import ru.kozirfm.news.datasourse.NewsRemoteDataSource
import javax.inject.Inject

class NewsRepositoryImpl
@Inject
constructor(
    private val remoteDataSource: NewsRemoteDataSource,
    private val localDataSource: NewsLocalDataSource
) : NewsRepository {
    override suspend fun getData(): ResponseState {
        return remoteDataSource.getNews()
    }
}