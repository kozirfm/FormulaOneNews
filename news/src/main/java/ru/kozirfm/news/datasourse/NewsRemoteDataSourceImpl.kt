package ru.kozirfm.news.datasourse

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import ru.kozirfm.network_api.services.NewsRemoteService
import ru.kozirfm.network_api.utils.ResponseHandler
import ru.kozirfm.network_api.utils.ResponseState
import ru.kozirfm.news.entity.OutNews
import ru.kozirfm.news.mapper.ToInNewsMapper
import javax.inject.Inject

class NewsRemoteDataSourceImpl @Inject constructor(
    private val api: NewsRemoteService,
    private val responseHandler: ResponseHandler
) : NewsRemoteDataSource {

    override suspend fun getNews(): ResponseState {
        return responseHandler.handleResponse(
            api.getArticlesAsync(50)
        ) { result ->
            Json.decodeFromString<List<OutNews>>(result)
                .map { ToInNewsMapper.map(it) }
        }
    }

}