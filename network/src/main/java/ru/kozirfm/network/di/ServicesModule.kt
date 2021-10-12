package ru.kozirfm.network.di

import dagger.Module
import dagger.Provides
import ru.kozirfm.core.di.annotation.AppScope
import ru.kozirfm.network.retrofit.RetrofitService
import ru.kozirfm.network_api.services.NewsRemoteService

@Module
class ServicesModule {

    @AppScope
    @Provides
    fun provideNewsRemoteService(retrofitService: RetrofitService): NewsRemoteService {
        return retrofitService
    }

}