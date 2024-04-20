package com.example.naturelife.domain.model

data class SingleWeather(
    val type: String?,
    val description: String?,
    val temperature: Double?,
    val feelsLike: Double?,
    val iconCode: String?
)
