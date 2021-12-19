package ru.kozirfm.login.ui

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import ru.kozirfm.base.BaseViewModel
import ru.kozirfm.login.entity.Login
import ru.kozirfm.login.usecase.LoginUseCase
import ru.kozirfm.navigation_api.NavigateRootDirection
import javax.inject.Inject

class LoginViewModel
@Inject
constructor(
    private val useCase: LoginUseCase,
    private val navigateRootDirection: NavigateRootDirection
) : BaseViewModel() {

    private val _token = MutableSharedFlow<String>()

    fun signIn(login: Login) {
        viewModelScope.launch(exceptionHandler) {
            val response = useCase.signIn(login = login)
        }
    }

    fun signUp(login: Login) {
        viewModelScope.launch(exceptionHandler) {
            val response = useCase.signUp(login = login)
        }
    }
}