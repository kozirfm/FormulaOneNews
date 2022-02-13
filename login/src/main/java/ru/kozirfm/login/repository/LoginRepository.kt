package ru.kozirfm.login.repository

import ru.kozirfm.login.entity.User
import ru.kozirfm.network_api.utils.ResponseState

interface LoginRepository {
    suspend fun signIn(user: User): ResponseState
    suspend fun signUp(user: User): ResponseState
}