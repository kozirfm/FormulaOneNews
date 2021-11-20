package ru.kozirfm.login.ui

import android.util.Log
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import ru.kozirfm.core.base.BaseViewModel
import ru.kozirfm.login.entity.Login
import ru.kozirfm.login.entity.UserToken
import ru.kozirfm.login.usecase.LoginUseCase
import ru.kozirfm.navigation_api.NavigateRootDirection
import ru.kozirfm.network_api.utils.ResponseError
import ru.kozirfm.network_api.utils.ResponseSuccess
import javax.inject.Inject

class LoginViewModel
@Inject
constructor(
    private val useCase: LoginUseCase,
    private val navigateRootDirection: NavigateRootDirection
) : BaseViewModel() {

    private val _token = MutableSharedFlow<UserToken>()

    fun getData(login: Login): Flow<UserToken> {
        viewModelScope.launch(exceptionHandler) {
            when (val response = useCase.getUserToken(login)) {
                is ResponseSuccess<*> -> {
                    navigateTo(navigateRootDirection.toMainFragment(), rootGraph = true)
//                    _token.emit(response.data as UserToken)
                }
                is ResponseError -> Log.w("", response.message)
            }
        }
        return _token
    }
}