package ru.kozirfm.network.retrofit

import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import ru.kozirfm.network_api.services.NewsRemoteService
import ru.kozirfm.news_api.entities.OutNews

interface RetrofitService : NewsRemoteService {

    @GET(".")
    override fun getArticlesAsync(@Query("count") count: Int): Deferred<Response<List<OutNews>>>

}