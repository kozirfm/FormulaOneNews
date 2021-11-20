package ru.kozirfm.news.datasourse

import ru.kozirfm.news.entity.OutNews
import javax.inject.Inject

class NewsLocalDataSourceImpl @Inject constructor() : NewsLocalDataSource {

    override fun getNews(): List<OutNews> {
        return emptyList()
    }

}