package ru.kozirfm.login.repository

import ru.kozirfm.login.datasourse.LoginRemoteDataSource
import ru.kozirfm.login.entity.Login
import ru.kozirfm.network_api.utils.ResponseState
import javax.inject.Inject

class LoginRepositoryImpl
@Inject
constructor(
    private val remoteDataSource: LoginRemoteDataSource
) : LoginRepository {

    override suspend fun signIn(login: Login): ResponseState {
        return remoteDataSource.signIn(login = login)
    }

    override suspend fun signUp(login: Login): ResponseState {
        return remoteDataSource.signUp(login = login)
    }
}