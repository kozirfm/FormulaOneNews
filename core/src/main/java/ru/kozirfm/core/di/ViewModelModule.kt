package ru.kozirfm.core.di

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import ru.kozirfm.core.viewmodel.ViewModelFactory

@Module
interface ViewModelModule {

    @Binds
    fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

}