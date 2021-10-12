package ru.kozirfm.news.datasourse

import ru.kozirfm.news_api.entities.OutNews

interface NewsDataSourceLocal {
    fun getNews(): List<OutNews>
}