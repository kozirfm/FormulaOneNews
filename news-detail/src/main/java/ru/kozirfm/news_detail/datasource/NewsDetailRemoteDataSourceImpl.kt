package ru.kozirfm.news_detail.datasource

import ru.kozirfm.network_api.services.NewsDetailRemoteService
import ru.kozirfm.network_api.utils.ResponseHandler
import ru.kozirfm.network_api.utils.ResponseState
import ru.kozirfm.news_api.mapper.ToInNewsMapper
import ru.kozirfm.utils.json.decodeFromString
import javax.inject.Inject

class NewsDetailRemoteDataSourceImpl @Inject constructor(
    private val api: NewsDetailRemoteService,
    private val responseHandler: ResponseHandler
) : NewsDetailRemoteDataSource {
    override suspend fun getNewsById(id: Long): ResponseState {
        return responseHandler.handleResponse(api.getNewsByIdAsync(id)) { result ->
            ToInNewsMapper.map(result.decodeFromString())
        }
    }
}