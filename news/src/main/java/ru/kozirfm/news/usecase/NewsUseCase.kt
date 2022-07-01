package ru.kozirfm.news.usecase

import ru.kozirfm.network_api.utils.ResponseState

interface NewsUseCase {
    suspend fun getNews(): ResponseState?
}