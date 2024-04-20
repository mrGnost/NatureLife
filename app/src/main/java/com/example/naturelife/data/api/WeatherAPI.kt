package com.example.naturelife.data.api

import com.example.naturelife.data.model.dto.WeatherListDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherAPI {
    @GET("/data/2.5/forecast/hourly?units=metric")
    fun getWeatherDataByLocation(
        @Query("lat") latitude: Double,
        @Query("lon") longitude: Double,
        @Query("lang") language: String
    ): WeatherListDTO
}