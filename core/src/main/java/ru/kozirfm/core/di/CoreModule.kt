package ru.kozirfm.core.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.kozirfm.core.base.SplashViewModel
import ru.kozirfm.core.viewmodel.ViewModelKey

@Module(includes = [ViewModelModule::class])
interface CoreModule {

    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel::class)
    fun bindNewsViewModel(newsViewModel: SplashViewModel): ViewModel
}