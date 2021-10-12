package ru.kozirfm.news.repository

import ru.kozirfm.network_api.utils.ResponseState
import ru.kozirfm.news.datasourse.NewsDataSourceLocal
import ru.kozirfm.news.datasourse.NewsDataSourceRemote
import javax.inject.Inject

class NewsRepositoryImpl
@Inject
constructor(
    private val remoteDataSource: NewsDataSourceRemote,
    private val localDataSource: NewsDataSourceLocal
) : NewsRepository {
    override suspend fun getData(): ResponseState {
        return remoteDataSource.getNews()
    }
}