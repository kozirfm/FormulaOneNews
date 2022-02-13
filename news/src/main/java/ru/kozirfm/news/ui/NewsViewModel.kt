package ru.kozirfm.news.ui

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.kozirfm.core.base.BaseViewModel
import ru.kozirfm.core.presentation.uistate.UiError
import ru.kozirfm.core.presentation.uistate.UiLoading
import ru.kozirfm.core.presentation.uistate.UiState
import ru.kozirfm.core.presentation.uistate.UiSuccess
import ru.kozirfm.core.screens.Screen
import ru.kozirfm.network_api.utils.ResponseError
import ru.kozirfm.network_api.utils.ResponseSuccess
import ru.kozirfm.news.usecase.NewsUseCase
import ru.kozirfm.utils.extensions.withTimeout
import javax.inject.Inject

class NewsViewModel @Inject constructor(
    private val newsUseCase: NewsUseCase,
) : BaseViewModel() {

    private val _viewState = MutableStateFlow<UiState>(UiLoading)

    fun getData(): StateFlow<UiState> {
        viewModelScope.launch(exceptionHandler) {
            if (_viewState.value is UiSuccess<*>) return@launch
            val state =
                when (val response = newsUseCase.getNews()) {
                    is ResponseSuccess<*> -> UiSuccess(response.data)
                    is ResponseError -> UiError(response.message)
                }
            _viewState
                .withTimeout(MIN_LOADING_TIMEOUT)
                .emit(state)
        }
        return _viewState
    }

    fun onItemClick(id: Long) {
        navigateTo(screen = Screen.NEWS_DETAIL_SCREEN.name, arguments = listOf(id.toString()))
    }

}