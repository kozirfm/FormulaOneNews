package ru.kozirfm.calendar.ui

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.kozirfm.calendar.usecase.CalendarUseCase
import ru.kozirfm.core.base.BaseViewModel
import ru.kozirfm.core.presentation.uistate.UiError
import ru.kozirfm.core.presentation.uistate.UiLoading
import ru.kozirfm.core.presentation.uistate.UiState
import ru.kozirfm.core.presentation.uistate.UiSuccess
import ru.kozirfm.core.screens.Screen
import ru.kozirfm.network_api.utils.ResponseError
import ru.kozirfm.network_api.utils.ResponseSuccess
import ru.kozirfm.utils.extensions.withTimeout
import javax.inject.Inject

class CalendarViewModel @Inject constructor(
    private val calendarUseCase: CalendarUseCase
) : BaseViewModel() {

    private val _viewState = MutableStateFlow<UiState>(UiLoading)

    fun getData(): StateFlow<UiState> {
        viewModelScope.launch(exceptionHandler) {
            val state = when (val response = calendarUseCase.getCalendar()) {
                is ResponseSuccess<*> -> UiSuccess(response.data)
                is ResponseError -> UiError(response.message)
                else -> UiError("TimeOut Error")
            }
            _viewState.withTimeout(MIN_LOADING_TIMEOUT)
                .tryEmit(state)
        }
        return _viewState
    }

    override val screenName: String = Screen.CALENDAR.name
}