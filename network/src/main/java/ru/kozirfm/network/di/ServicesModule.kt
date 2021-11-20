package ru.kozirfm.network.di

import dagger.Module
import dagger.Provides
import ru.kozirfm.network.retrofit.RetrofitService
import ru.kozirfm.network_api.services.LoginRemoteService
import ru.kozirfm.network_api.services.NewsRemoteService

@Module
class ServicesModule {

    @Provides
    fun provideNewsRemoteService(retrofitService: RetrofitService): NewsRemoteService {
        return retrofitService
    }

    @Provides
    fun provideLoginRemoteService(retrofitService: RetrofitService): LoginRemoteService{
        return retrofitService
    }

}