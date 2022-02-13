package ru.kozirfm.network.di

import dagger.Binds
import dagger.Module
import ru.kozirfm.network.retrofit.RetrofitService
import ru.kozirfm.network_api.services.LoginRemoteService
import ru.kozirfm.network_api.services.NewsDetailRemoteService
import ru.kozirfm.network_api.services.NewsRemoteService

@Module
interface ServicesModule {

    @Binds
    fun provideNewsRemoteService(retrofitService: RetrofitService): NewsRemoteService

    @Binds
    fun provideLoginRemoteService(retrofitService: RetrofitService): LoginRemoteService

    @Binds
    fun provideNewsDetailRemoteService(retrofitService: RetrofitService): NewsDetailRemoteService

}