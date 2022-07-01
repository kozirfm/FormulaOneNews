package ru.kozirfm.network.di

import dagger.Binds
import dagger.Module
import ru.kozirfm.network.retrofit.RetrofitService
import ru.kozirfm.network_api.services.CalendarRemoteService
import ru.kozirfm.network_api.services.LoginRemoteService
import ru.kozirfm.network_api.services.NewsDetailRemoteService
import ru.kozirfm.network_api.services.NewsRemoteService

@Module
interface ServicesModule {

    @Binds
    fun bindNewsRemoteService(retrofitService: RetrofitService): NewsRemoteService

    @Binds
    fun bindLoginRemoteService(retrofitService: RetrofitService): LoginRemoteService

    @Binds
    fun bindNewsDetailRemoteService(retrofitService: RetrofitService): NewsDetailRemoteService

    @Binds
    fun bindCalendarRemoteService(retrofitService: RetrofitService): CalendarRemoteService

}