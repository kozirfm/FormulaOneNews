package ru.kozirfm.network.retrofit

import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query
import ru.kozirfm.login.entity.UserToken
import ru.kozirfm.network_api.entity.ServerResponse
import ru.kozirfm.network_api.services.LoginRemoteService
import ru.kozirfm.network_api.services.NewsRemoteService
import ru.kozirfm.news.entity.OutNews


interface RetrofitService :
    NewsRemoteService,
    LoginRemoteService {

    @GET(".")
    override fun getArticlesAsync(@Query("count") count: Int): Deferred<ServerResponse<List<OutNews>>>

    @POST("/login")
    override fun getUserTokenAsync(): Deferred<ServerResponse<String>>

    @POST("/registration")
    override fun registrationUserAsync(): Deferred<ServerResponse<UserToken>>
}