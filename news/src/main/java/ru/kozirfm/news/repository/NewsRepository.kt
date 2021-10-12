package ru.kozirfm.news.repository

import ru.kozirfm.network_api.utils.ResponseState

interface NewsRepository {
    suspend fun getData(): ResponseState
}