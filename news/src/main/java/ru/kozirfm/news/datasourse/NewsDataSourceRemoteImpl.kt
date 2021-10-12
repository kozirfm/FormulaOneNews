package ru.kozirfm.news.datasourse

import ru.kozirfm.network_api.utils.ResponseState
import ru.kozirfm.network_api.services.NewsRemoteService
import ru.kozirfm.network_api.utils.ResponseHandler
import ru.kozirfm.news.mapper.ToInNewsMapper
import ru.kozirfm.news_api.entities.InNews
import ru.kozirfm.news_api.entities.OutNews
import javax.inject.Inject

class NewsDataSourceRemoteImpl @Inject constructor(
    private val api: NewsRemoteService,
    private val responseHandler: ResponseHandler
) : NewsDataSourceRemote {

    override suspend fun getNews(): ResponseState {
        return responseHandler.handleResponse<List<OutNews>, List<InNews>>(
            api.getArticlesAsync(10)
        ) { news -> news.map { ToInNewsMapper.map(it) } }
    }
}