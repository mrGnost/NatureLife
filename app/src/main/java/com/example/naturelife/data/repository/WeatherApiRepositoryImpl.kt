package com.example.naturelife.data.repository

import com.example.naturelife.data.api.WeatherAPI
import com.example.naturelife.data.model.dto.WeatherListDTO
import com.example.naturelife.domain.Mapper
import com.example.naturelife.domain.model.SingleWeather
import com.example.naturelife.domain.repository.WeatherApiRepository
import javax.inject.Inject

class WeatherApiRepositoryImpl @Inject constructor(
    private val api: WeatherAPI,
    private val singleWeatherMapper: Mapper<WeatherListDTO, SingleWeather>
) : WeatherApiRepository {
    override suspend fun getWeather(latitude: Double, longitude: Double, language: String): SingleWeather {
        return api.getWeatherDataByLocation(latitude, longitude, language).let {
            singleWeatherMapper.mapFrom(it)
        }
    }
}