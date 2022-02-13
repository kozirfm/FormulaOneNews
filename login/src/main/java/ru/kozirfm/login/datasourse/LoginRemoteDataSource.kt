package ru.kozirfm.login.datasourse

import ru.kozirfm.login.entity.User
import ru.kozirfm.network_api.utils.ResponseState

interface LoginRemoteDataSource {
    suspend fun signIn(user: User): ResponseState
    suspend fun signUp(user: User): ResponseState
}