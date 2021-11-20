package ru.kozirfm.login.datasourse

import ru.kozirfm.login.entity.Login
import ru.kozirfm.network_api.utils.ResponseState

interface LoginRemoteDataSource {

    suspend fun getUserToken(login: Login): ResponseState

}