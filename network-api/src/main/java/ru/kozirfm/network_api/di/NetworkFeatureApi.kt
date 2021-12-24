package ru.kozirfm.network_api.di

import ru.kozirfm.network_api.services.LoginRemoteService
import ru.kozirfm.network_api.services.NewsRemoteService
import ru.kozirfm.network_api.utils.ResponseHandler

interface NetworkFeatureApi {
    fun getNewsRemoteService(): NewsRemoteService
    fun getLoginRemoteService(): LoginRemoteService
    fun getResponseHandler(): ResponseHandler
}