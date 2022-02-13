package ru.kozirfm.news_detail.usecase

import ru.kozirfm.network_api.utils.ResponseState
import ru.kozirfm.news_detail.repository.NewsDetailRepository
import javax.inject.Inject

class NewsDetailUseCaseImpl @Inject constructor(
    private val repository: NewsDetailRepository
) : NewsDetailUseCase {
    override suspend fun getNewsById(id: Long): ResponseState {
        return repository.getNewsById(id)
    }
}