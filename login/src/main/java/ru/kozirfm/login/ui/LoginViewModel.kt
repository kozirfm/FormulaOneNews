package ru.kozirfm.login.ui

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ru.kozirfm.core.base.BaseViewModel
import ru.kozirfm.core.presentation.uistate.UiError
import ru.kozirfm.core.presentation.uistate.UiState
import ru.kozirfm.core.presentation.uistate.UiSuccess
import ru.kozirfm.core.screens.Screen
import ru.kozirfm.login.entity.User
import ru.kozirfm.login.usecase.LoginUseCase
import ru.kozirfm.navigation_api.Navigator
import ru.kozirfm.network_api.utils.ResponseError
import ru.kozirfm.network_api.utils.ResponseSuccess
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    private val useCase: LoginUseCase,
    private val navigator: Navigator
) : BaseViewModel() {

    private val _viewState = MutableStateFlow<UiState?>(null)
    val viewState = _viewState.asStateFlow()

    fun signIn(user: User): StateFlow<UiState?> {
        viewModelScope.launch(exceptionHandler) {
            val state = when (val response = useCase.signIn(user = user)) {
                is ResponseSuccess<*> -> UiSuccess(null)
                is ResponseError -> UiError(response.message)
                else -> UiError("TimeOut Error")
            }
            _viewState.emit(state)
        }
        return _viewState
    }

    fun signUp(user: User): StateFlow<UiState?> {
        viewModelScope.launch(exceptionHandler) {
            val state = when (val response = useCase.signUp(user = user)) {
                is ResponseSuccess<*> -> UiSuccess(null)
                is ResponseError -> UiError(response.message)
                else -> UiError("TimeOut Error")
            }
            _viewState.emit(state)
        }
        return _viewState
    }

    override val screenName: String = Screen.LOGIN.name
}