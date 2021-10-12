package ru.kozirfm.news.datasourse

import ru.kozirfm.network_api.utils.ResponseState

interface NewsDataSourceRemote {
    suspend fun getNews(): ResponseState
}