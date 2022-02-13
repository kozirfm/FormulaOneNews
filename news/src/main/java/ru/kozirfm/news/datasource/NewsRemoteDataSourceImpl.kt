package ru.kozirfm.news.datasource

import ru.kozirfm.network_api.services.NewsRemoteService
import ru.kozirfm.network_api.utils.ResponseHandler
import ru.kozirfm.network_api.utils.ResponseState
import ru.kozirfm.news_api.entity.OutNews
import ru.kozirfm.news_api.mapper.ToInNewsMapper
import ru.kozirfm.utils.json.decodeFromString
import javax.inject.Inject

class NewsRemoteDataSourceImpl @Inject constructor(
    private val api: NewsRemoteService,
    private val responseHandler: ResponseHandler
) : NewsRemoteDataSource {

    override suspend fun getNews(): ResponseState {
        return responseHandler.handleResponse(
            api.getNewsAsync(50)
        ) { result -> result.decodeFromString<List<OutNews>>().map { ToInNewsMapper.map(it) } }
    }

}