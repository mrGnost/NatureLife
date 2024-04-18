package com.example.naturelife.di

import com.example.naturelife.data.api.WeatherAPI
import com.example.naturelife.BuildConfig
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class APIModule {
    @Provides
    @Singleton
    fun provideRecommendationApi(builder: Retrofit.Builder): WeatherAPI = builder
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(WeatherAPI::class.java)

    @Provides
    @Singleton
    fun provideRetrofitBuilder(client: OkHttpClient): Retrofit.Builder = Retrofit.Builder()
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())

    @Provides
    @Singleton
    fun provideOkHttp(
        httpLoggingInterceptor: HttpLoggingInterceptor,
        keyInterceptor: Interceptor
    ): OkHttpClient = OkHttpClient()
        .newBuilder()
        .addInterceptor(httpLoggingInterceptor)
        .addInterceptor(keyInterceptor)
        .build()

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().setLevel(
            if (BuildConfig.DEBUG)
                HttpLoggingInterceptor.Level.BODY
            else
                HttpLoggingInterceptor.Level.NONE
        )

    @Provides
    @Singleton
    fun provideKeyInterceptor(): Interceptor = Interceptor { chain ->
        var request = chain.request()
        val url = request.url.newBuilder()
            .addQueryParameter("appid", BuildConfig.WEATHER_KEY)
            .build()
        request = request.newBuilder().url(url).build()
        chain.proceed(request)
    }

    companion object {
        private const val BASE_URL = "https://pro.openweathermap.org/"
    }
}