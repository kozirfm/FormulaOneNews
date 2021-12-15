package ru.kozirfm.login.datasourse

import android.util.Log
import ru.kozirfm.login.entity.Login
import ru.kozirfm.login.entity.UserToken
import ru.kozirfm.network_api.services.LoginRemoteService
import ru.kozirfm.network_api.utils.ResponseHandler
import ru.kozirfm.network_api.utils.ResponseState
import javax.inject.Inject

class LoginRemoteDataSourceImpl
@Inject
constructor(
    private val api: LoginRemoteService,
    private val responseHandler: ResponseHandler
) : LoginRemoteDataSource {

    override suspend fun signIn(login: Login): ResponseState {
        Log.d("SIGN_IN", login.toString())
        return responseHandler.handleResponse<UserToken>(api.signInAsync())
    }

    override suspend fun signUp(login: Login): ResponseState {
        Log.d("SIGN_UP", login.toString())
        return responseHandler.handleResponse<UserToken>(api.signUpAsync())
    }

}