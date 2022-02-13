package ru.kozirfm.news_detail.ui

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.kozirfm.core.base.BaseViewModel
import ru.kozirfm.core.presentation.uistate.UiError
import ru.kozirfm.core.presentation.uistate.UiLoading
import ru.kozirfm.core.presentation.uistate.UiState
import ru.kozirfm.core.presentation.uistate.UiSuccess
import ru.kozirfm.network_api.utils.ResponseError
import ru.kozirfm.network_api.utils.ResponseSuccess
import ru.kozirfm.news_detail.usecase.NewsDetailUseCase
import javax.inject.Inject

class NewsDetailViewModel @Inject constructor(
    private val useCase: NewsDetailUseCase
) : BaseViewModel() {

    private val _viewState = MutableStateFlow<UiState>(UiLoading)

    fun getData(id: Long?): StateFlow<UiState> {
        viewModelScope.launch(exceptionHandler) {
            id?.let {
                if (_viewState.value is UiSuccess<*>) return@launch
                val state = when (val response = useCase.getNewsById(id)) {
                    is ResponseSuccess<*> -> UiSuccess(response.data)
                    is ResponseError -> UiError(response.message)
                }
                _viewState.emit(state)
            } ?: _viewState.emit(UiError("Error"))
        }
        return _viewState
    }

}