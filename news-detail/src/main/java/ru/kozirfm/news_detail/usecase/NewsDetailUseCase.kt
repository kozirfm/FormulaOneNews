package ru.kozirfm.news_detail.usecase

import ru.kozirfm.network_api.utils.ResponseState

interface NewsDetailUseCase {
    suspend fun getNewsById(id: Long): ResponseState
}