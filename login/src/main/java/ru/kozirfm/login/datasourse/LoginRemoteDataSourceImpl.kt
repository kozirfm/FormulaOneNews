package ru.kozirfm.login.datasourse

import ru.kozirfm.login.entity.Login
import ru.kozirfm.login.entity.UserToken
import ru.kozirfm.network_api.services.LoginRemoteService
import ru.kozirfm.network_api.utils.ResponseHandler
import ru.kozirfm.network_api.utils.ResponseState
import javax.inject.Inject

class LoginRemoteDataSourceImpl @Inject constructor(
    private val api: LoginRemoteService,
    private val responseHandler: ResponseHandler
) : LoginRemoteDataSource {

    override suspend fun getUserToken(login: Login): ResponseState {
        return responseHandler.handleResponse<UserToken>(api.getUserTokenAsync())
    }

}