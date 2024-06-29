package com.example.naturelife.di

import com.example.naturelife.data.repository.WeatherApiRepositoryImpl
import com.example.naturelife.domain.repository.WeatherApiRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface BindModule {
    @Binds
    fun getWeatherApiRepository(repository: WeatherApiRepositoryImpl): WeatherApiRepository
}