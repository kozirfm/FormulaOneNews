package ru.kozirfm.news.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.kozirfm.core.di.ViewModelModule
import ru.kozirfm.core.di.annotation.PerFeature
import ru.kozirfm.core.viewmodel.ViewModelKey
import ru.kozirfm.news.datasourse.NewsLocalDataSource
import ru.kozirfm.news.datasourse.NewsLocalDataSourceImpl
import ru.kozirfm.news.datasourse.NewsRemoteDataSource
import ru.kozirfm.news.datasourse.NewsRemoteDataSourceImpl
import ru.kozirfm.news.repository.NewsRepository
import ru.kozirfm.news.repository.NewsRepositoryImpl
import ru.kozirfm.news.ui.NewsViewModel
import ru.kozirfm.news.usecase.NewsUseCase
import ru.kozirfm.news.usecase.NewsUseCaseImpl

@Module(includes = [ViewModelModule::class])
interface NewsModule {

    @Binds
    @PerFeature
    fun bindNewsDataSourceRemote(remoteDataSource: NewsRemoteDataSourceImpl): NewsRemoteDataSource

    @Binds
    @PerFeature
    fun bindNewsDataSourceLocal(localDataSource: NewsLocalDataSourceImpl): NewsLocalDataSource

    @Binds
    @PerFeature
    fun bindNewsRepository(repository: NewsRepositoryImpl): NewsRepository

    @Binds
    @PerFeature
    fun bindNewsUseCase(useCase: NewsUseCaseImpl): NewsUseCase

    @Binds
    @IntoMap
    @ViewModelKey(NewsViewModel::class)
    fun bindNewsViewModel(viewModel: NewsViewModel): ViewModel

}

