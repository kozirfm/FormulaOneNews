package ru.kozirfm.network_api.di

import ru.kozirfm.network_api.services.LoginRemoteService
import ru.kozirfm.network_api.utils.ResponseHandler
import ru.kozirfm.network_api.services.NewsRemoteService

interface NetworkDependencies {
    fun getNewsRemoteService(): NewsRemoteService
    fun getLoginRemoteService(): LoginRemoteService
    fun getResponseHandler(): ResponseHandler
}