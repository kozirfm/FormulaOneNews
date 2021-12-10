package ru.kozirfm.news.ui

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import ru.kozirfm.core.base.BaseViewModel
import ru.kozirfm.core.uistate.UiError
import ru.kozirfm.core.uistate.UiLoading
import ru.kozirfm.core.uistate.UiState
import ru.kozirfm.core.uistate.UiSuccess
import ru.kozirfm.network_api.utils.ResponseError
import ru.kozirfm.network_api.utils.ResponseSuccess
import ru.kozirfm.news.usecase.NewsUseCase
import ru.kozirfm.utils.extensions.withTimeout
import javax.inject.Inject

class NewsViewModel @Inject constructor(
    private val newsUseCase: NewsUseCase
) : BaseViewModel() {

    private val _viewState = MutableStateFlow<UiState>(UiLoading)

    fun getData(): Flow<UiState> {
        viewModelScope.launch(exceptionHandler) {
            when (val response = newsUseCase.getNews().withTimeout(MIN_LOADING_TIMEOUT)) {
                is ResponseSuccess<*> -> _viewState.emit(UiSuccess(response.data))
                is ResponseError -> _viewState.emit(UiError(response.message))
            }
        }
        return _viewState
    }

}