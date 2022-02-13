package ru.kozirfm.news_detail.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.kozirfm.core.annotation.PerFeature
import ru.kozirfm.core.di.ViewModelModule
import ru.kozirfm.core.viewmodel.ViewModelKey
import ru.kozirfm.news_detail.datasource.NewsDetailRemoteDataSource
import ru.kozirfm.news_detail.datasource.NewsDetailRemoteDataSourceImpl
import ru.kozirfm.news_detail.repository.NewsDetailRepository
import ru.kozirfm.news_detail.repository.NewsDetailRepositoryImpl
import ru.kozirfm.news_detail.ui.NewsDetailViewModel
import ru.kozirfm.news_detail.usecase.NewsDetailUseCase
import ru.kozirfm.news_detail.usecase.NewsDetailUseCaseImpl

@Module(includes = [ViewModelModule::class])
interface NewsDetailModule {

    @Binds
    @PerFeature
    fun bindNewsDetailRemoteDataSource(remoteDataSource: NewsDetailRemoteDataSourceImpl): NewsDetailRemoteDataSource

    @Binds
    @PerFeature
    fun bindNewsDetailRepository(repository: NewsDetailRepositoryImpl): NewsDetailRepository

    @Binds
    @PerFeature
    fun bindNewsDetailUseCase(useCase: NewsDetailUseCaseImpl): NewsDetailUseCase

    @Binds
    @IntoMap
    @ViewModelKey(NewsDetailViewModel::class)
    fun bindNewsDetailViewModel(viewModel: NewsDetailViewModel): ViewModel
}