package ru.kozirfm.news_detail.repository

import ru.kozirfm.network_api.utils.ResponseState

interface NewsDetailRepository {
    suspend fun getNewsById(id: Long): ResponseState
}