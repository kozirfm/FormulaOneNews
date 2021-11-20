package ru.kozirfm.login.repository

import ru.kozirfm.login.entity.Login
import ru.kozirfm.network_api.utils.ResponseState

interface LoginRepository {

    suspend fun getUserToken(login: Login): ResponseState
}