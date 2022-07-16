package com.example.githubrepos.di

import com.example.githubrepos.BuildConfig
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

internal fun getNetworkModule() = module {
    single { provideGson() }
    single { provideHttpLoggingInterceptor() }
    single { provideOkHttpClient(get()) }
    single { provideRetrofit(get(), get()) }
}

private const val BASE_URL = "https://api.github.com/"
private const val DEFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss"

private fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
    val level = if (BuildConfig.DEBUG) {
        HttpLoggingInterceptor.Level.BODY
    } else {
        HttpLoggingInterceptor.Level.NONE
    }

    return HttpLoggingInterceptor().apply { setLevel(level) }
}

private fun provideGson() =
    GsonBuilder()
        .setDateFormat(DEFAULT_DATE_FORMAT)
        .serializeNulls()
        .create()

private fun provideOkHttpClient(
    loggingInterceptor: HttpLoggingInterceptor
) =
    OkHttpClient.Builder()
        .connectTimeout(60, TimeUnit.SECONDS)
        .readTimeout(60, TimeUnit.SECONDS)
        .writeTimeout(60, TimeUnit.SECONDS)
        .addInterceptor(loggingInterceptor)
        .followRedirects(true)
        .build()

private fun provideRetrofit(
    okHttpClient: OkHttpClient,
    gson: Gson,
) = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create(gson))
    .client(okHttpClient)
    .build()

