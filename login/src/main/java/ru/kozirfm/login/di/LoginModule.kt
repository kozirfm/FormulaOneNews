package ru.kozirfm.login.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.kozirfm.core.annotation.PerFeature
import ru.kozirfm.core.di.ViewModelModule
import ru.kozirfm.core.viewmodel.ViewModelKey
import ru.kozirfm.login.datasourse.LoginRemoteDataSource
import ru.kozirfm.login.datasourse.LoginRemoteDataSourceImpl
import ru.kozirfm.login.repository.LoginRepository
import ru.kozirfm.login.repository.LoginRepositoryImpl
import ru.kozirfm.login.ui.LoginViewModel
import ru.kozirfm.login.usecase.LoginUseCase
import ru.kozirfm.login.usecase.LoginUseCaseImpl

@Module(includes = [ViewModelModule::class])
interface LoginModule {

    @Binds
    @PerFeature
    fun bindLoginRemoteDataSource(remoteDataSource: LoginRemoteDataSourceImpl): LoginRemoteDataSource

    @Binds
    @PerFeature
    fun bindLoginRepository(repository: LoginRepositoryImpl): LoginRepository

    @Binds
    @PerFeature
    fun bindLoginUseCase(useCase: LoginUseCaseImpl): LoginUseCase

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    fun bindLoginViewModel(viewModel: LoginViewModel): ViewModel

}