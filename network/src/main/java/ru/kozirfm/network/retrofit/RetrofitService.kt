package ru.kozirfm.network.retrofit

import kotlinx.coroutines.Deferred
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query
import ru.kozirfm.network_api.services.CalendarRemoteService
import ru.kozirfm.network_api.services.LoginRemoteService
import ru.kozirfm.network_api.services.NewsDetailRemoteService
import ru.kozirfm.network_api.services.NewsRemoteService


interface RetrofitService :
    NewsRemoteService,
    LoginRemoteService,
    NewsDetailRemoteService,
    CalendarRemoteService {

    @GET("news")
    override fun getNewsAsync(@Query("count") count: Int): Deferred<String>

    @POST("sign_in")
    override fun signInAsync(@Body body: String): Deferred<String>

    @POST("sign_up")
    override fun signUpAsync(@Body body: String): Deferred<String>

    @GET("news")
    override fun getNewsByIdAsync(@Query("id") id: Long): Deferred<String>

    @GET("calendar")
    override fun getCalendarAsync(): Deferred<String>

}