package ru.kozirfm.network.di

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.create
import ru.kozirfm.core_api.di.annotation.AppScope
import ru.kozirfm.network.retrofit.RetrofitService
import ru.kozirfm.network.utils.ResponseHandlerImpl
import ru.kozirfm.network_api.utils.ResponseHandler
import java.util.concurrent.TimeUnit

@Module(includes = [ServicesModule::class])
class NetworkModule {

    @AppScope
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): RetrofitService {
        return Retrofit.Builder()
            .baseUrl(PROD_URL)
            .client(okHttpClient)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build().create()
    }

    @AppScope
    @Provides
    fun provideOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .addNetworkInterceptor(httpLoggingInterceptor)
            .build()
    }

    @AppScope
    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @AppScope
    @Provides
    fun provideResponseHandler(): ResponseHandler {
        return ResponseHandlerImpl()
    }

    private companion object {
        const val PROD_URL = "http://95.52.246.252"
        const val STAGE_URL = "http://192.168.31.235:5555"
    }
}