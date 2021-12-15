package ru.kozirfm.login.datasourse

import ru.kozirfm.login.entity.Login
import ru.kozirfm.network_api.utils.ResponseState

interface LoginRemoteDataSource {
    suspend fun signIn(login: Login): ResponseState
    suspend fun signUp(login: Login): ResponseState
}