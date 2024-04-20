package com.example.naturelife.data.model.dto

import com.google.gson.annotations.SerializedName

data class WeatherStatsDTO(
    @SerializedName("temp") var temperature: Double,
    @SerializedName("humidity") var humidity: Int,
    @SerializedName("pressure") val pressure: Int,
    @SerializedName("feels_like") val feelsLike: Double
)
