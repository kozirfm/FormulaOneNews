package ru.kozirfm.network_api.di

import ru.kozirfm.network_api.services.CalendarRemoteService
import ru.kozirfm.network_api.services.LoginRemoteService
import ru.kozirfm.network_api.services.NewsDetailRemoteService
import ru.kozirfm.network_api.services.NewsRemoteService
import ru.kozirfm.network_api.utils.ResponseHandler

interface NetworkFeatureApi {
    fun getNewsRemoteService(): NewsRemoteService
    fun getLoginRemoteService(): LoginRemoteService
    fun getNewsDetailRemoteService(): NewsDetailRemoteService
    fun getCalendarRemoteService(): CalendarRemoteService
    fun getResponseHandler(): ResponseHandler
}