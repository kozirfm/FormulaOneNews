package ru.kozirfm.login.datasourse

import android.util.Log
import ru.kozirfm.login.entity.User
import ru.kozirfm.network_api.services.LoginRemoteService
import ru.kozirfm.network_api.utils.ResponseHandler
import ru.kozirfm.network_api.utils.ResponseState
import ru.kozirfm.utils.json.encodeToString
import javax.inject.Inject

class LoginRemoteDataSourceImpl
@Inject
constructor(
    private val api: LoginRemoteService,
    private val responseHandler: ResponseHandler,
) : LoginRemoteDataSource {

    override suspend fun signIn(user: User): ResponseState {
        return responseHandler.handleResponse(
            api.signInAsync(body = user.encodeToString())
        ) { response -> Log.d("SIGN_IN", response) }
    }

    override suspend fun signUp(user: User): ResponseState {
        return responseHandler.handleResponse(
            api.signUpAsync(body = user.encodeToString())
        ) { response -> Log.d("SIGN_UP", response) }
    }

}