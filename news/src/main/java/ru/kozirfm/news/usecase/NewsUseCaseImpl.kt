package ru.kozirfm.news.usecase

import ru.kozirfm.network_api.utils.ResponseState
import ru.kozirfm.news.repository.NewsRepository
import javax.inject.Inject

class NewsUseCaseImpl
@Inject
constructor(private val repository: NewsRepository) : NewsUseCase {

    override suspend fun getNews(): ResponseState {
        return repository.getData()
    }
}