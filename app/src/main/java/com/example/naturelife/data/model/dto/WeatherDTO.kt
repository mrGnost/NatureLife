package com.example.naturelife.data.model.dto

import com.google.gson.annotations.SerializedName

data class WeatherListDTO(
    @SerializedName("list") var list: List<WeatherDTO>
){
    data class WeatherDTO(
        @SerializedName("main") var stats: WeatherStatsDTO,
        @SerializedName("weather") var descriptionList: List<WeatherDescriptionDTO>
    )

    data class WeatherDescriptionDTO(
        @SerializedName("main") var main: String,
        @SerializedName("description") var description: String,
        @SerializedName("icon") var iconCode: String
    )

    data class WeatherStatsDTO(
        @SerializedName("temp") var temperature: Double,
        @SerializedName("humidity") var humidity: Int,
        @SerializedName("pressure") val pressure: Int,
        @SerializedName("feels_like") val feelsLike: Double
    )
}
