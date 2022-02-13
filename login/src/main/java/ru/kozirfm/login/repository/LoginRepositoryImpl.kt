package ru.kozirfm.login.repository

import ru.kozirfm.login.datasourse.LoginRemoteDataSource
import ru.kozirfm.login.entity.User
import ru.kozirfm.network_api.utils.ResponseState
import javax.inject.Inject

class LoginRepositoryImpl
@Inject
constructor(
    private val remoteDataSource: LoginRemoteDataSource
) : LoginRepository {

    override suspend fun signIn(user: User): ResponseState {
        return remoteDataSource.signIn(user = user)
    }

    override suspend fun signUp(user: User): ResponseState {
        return remoteDataSource.signUp(user = user)
    }
}