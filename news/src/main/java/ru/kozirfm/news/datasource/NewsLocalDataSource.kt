package ru.kozirfm.news.datasource

import ru.kozirfm.news_api.entity.OutNews

interface NewsLocalDataSource {
    fun getNews(): List<OutNews>
}