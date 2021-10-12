package ru.kozirfm.news.datasourse

import ru.kozirfm.news_api.entities.OutNews
import javax.inject.Inject

class NewsDataSourceLocalImpl @Inject constructor() : NewsDataSourceLocal {

    override fun getNews(): List<OutNews> {
        return emptyList()
    }

}