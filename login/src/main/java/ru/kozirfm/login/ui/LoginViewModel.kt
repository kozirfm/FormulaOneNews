package ru.kozirfm.login.ui

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import ru.kozirfm.core.base.BaseViewModel
import ru.kozirfm.login.entity.User
import ru.kozirfm.login.usecase.LoginUseCase
import ru.kozirfm.navigation_api.Navigator
import javax.inject.Inject

class LoginViewModel
@Inject
constructor(
    private val useCase: LoginUseCase,
    private val navigator: Navigator
) : BaseViewModel() {

    private val _token = MutableSharedFlow<String>()

    fun signIn(user: User) {
        viewModelScope.launch(exceptionHandler) {
            val response = useCase.signIn(user = user)
        }
    }

    fun signUp(user: User) {
        viewModelScope.launch(exceptionHandler) {
            val response = useCase.signUp(user = user)
        }
    }
}