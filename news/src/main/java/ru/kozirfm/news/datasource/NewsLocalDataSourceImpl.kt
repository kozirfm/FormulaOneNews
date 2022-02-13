package ru.kozirfm.news.datasource

import ru.kozirfm.news_api.entity.OutNews
import javax.inject.Inject

class NewsLocalDataSourceImpl @Inject constructor() : NewsLocalDataSource {

    override fun getNews(): List<OutNews> {
        return emptyList()
    }

}