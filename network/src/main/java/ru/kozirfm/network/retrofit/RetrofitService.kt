package ru.kozirfm.network.retrofit

import kotlinx.coroutines.Deferred
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query
import ru.kozirfm.network_api.services.LoginRemoteService
import ru.kozirfm.network_api.services.NewsDetailRemoteService
import ru.kozirfm.network_api.services.NewsRemoteService


interface RetrofitService :
    NewsRemoteService,
    LoginRemoteService,
    NewsDetailRemoteService {

    @GET(API_VERSION)
    override fun getNewsAsync(@Query("count") count: Int): Deferred<String>

    @POST("$API_VERSION/sign_in")
    override fun signInAsync(@Body body: String): Deferred<String>

    @POST("$API_VERSION/sign_up")
    override fun signUpAsync(@Body body: String): Deferred<String>

    @GET(API_VERSION)
    override fun getNewsByIdAsync(@Query("id") id: Long): Deferred<String>

    private companion object {
        const val API_VERSION = "/v2"
    }
}