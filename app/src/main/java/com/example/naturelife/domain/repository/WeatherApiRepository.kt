package com.example.naturelife.domain.repository

import com.example.naturelife.domain.model.SingleWeather

interface WeatherApiRepository {
    suspend fun getWeather(latitude: Double, longitude: Double, language: String): SingleWeather
}