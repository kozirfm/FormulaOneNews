package ru.kozirfm.login.repository

import ru.kozirfm.login.entity.Login
import ru.kozirfm.network_api.utils.ResponseState

interface LoginRepository {
    suspend fun signIn(login: Login): ResponseState
    suspend fun signUp(login: Login): ResponseState
}