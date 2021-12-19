package ru.kozirfm.login.datasourse

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import ru.kozirfm.login.entity.Login
import ru.kozirfm.network_api.services.LoginRemoteService
import ru.kozirfm.network_api.utils.ResponseHandler
import ru.kozirfm.network_api.utils.ResponseState
import javax.inject.Inject

class LoginRemoteDataSourceImpl
@Inject
constructor(
    private val api: LoginRemoteService,
    private val responseHandler: ResponseHandler,
) : LoginRemoteDataSource {

    override suspend fun signIn(login: Login): ResponseState {
        return responseHandler.handleResponse<String>(
            api.signInAsync(body = login.toJsonString()).await().let { json ->
                Json.decodeFromString(json)
            }
        )
    }

    override suspend fun signUp(login: Login): ResponseState {
        return responseHandler.handleResponse<String>(
            api.signUpAsync(body = login.toJsonString()).await().let { json ->
                Json.decodeFromString(json)
            }
        )
    }

}