package ru.kozirfm.news.datasourse

import ru.kozirfm.news.entity.OutNews

interface NewsLocalDataSource {
    fun getNews(): List<OutNews>
}