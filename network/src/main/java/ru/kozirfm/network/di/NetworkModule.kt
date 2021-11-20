package ru.kozirfm.network.di


import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.create
import ru.kozirfm.core.di.annotation.AppScope
import ru.kozirfm.network.retrofit.RetrofitService
import ru.kozirfm.network.utils.ResponseHandlerImpl
import ru.kozirfm.network_api.utils.ResponseHandler
import java.util.concurrent.TimeUnit

@Module(includes = [ServicesModule::class])
class NetworkModule {

    @ExperimentalSerializationApi
    @AppScope
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): RetrofitService {

        val mediaType = "application/json".toMediaType()
        val json = Json { ignoreUnknownKeys = true }

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(json.asConverterFactory(mediaType))
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
        const val BASE_URL = "http://95.52.246.252"
        const val TEST_URL = "http://127.0.0.1:5050"
    }
}