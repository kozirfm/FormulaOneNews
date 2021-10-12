package ru.kozirfm.news.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.kozirfm.core.viewmodel.ViewModelFactory
import ru.kozirfm.core.di.annotation.PerFeature
import ru.kozirfm.core.viewmodel.ViewModelKey
import ru.kozirfm.news.datasourse.NewsDataSourceLocal
import ru.kozirfm.news.datasourse.NewsDataSourceLocalImpl
import ru.kozirfm.news.datasourse.NewsDataSourceRemote
import ru.kozirfm.news.datasourse.NewsDataSourceRemoteImpl
import ru.kozirfm.news.repository.NewsRepository
import ru.kozirfm.news.repository.NewsRepositoryImpl
import ru.kozirfm.news.ui.NewsViewModel
import ru.kozirfm.news.usecase.NewsUseCase
import ru.kozirfm.news.usecase.NewsUseCaseImpl

@Module
interface NewsModule {

    @Binds
    @PerFeature
    fun bindNewsDataSourceRemote(newsDataSourceRemoteImpl: NewsDataSourceRemoteImpl): NewsDataSourceRemote

    @Binds
    @PerFeature
    fun bindNewsDataSourceLocal(newsDataSourceLocalImpl: NewsDataSourceLocalImpl): NewsDataSourceLocal

    @Binds
    @PerFeature
    fun bindNewsRepository(newsRepositoryImpl: NewsRepositoryImpl): NewsRepository

    @Binds
    @PerFeature
    fun bindNewsUseCase(newsUseCaseImpl: NewsUseCaseImpl): NewsUseCase

    @Binds
    @PerFeature
    fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(NewsViewModel::class)
    fun bindNewsViewModel(newsViewModel: NewsViewModel): ViewModel

}

