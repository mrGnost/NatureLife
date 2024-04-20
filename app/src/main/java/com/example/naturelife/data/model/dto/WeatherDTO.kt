package com.example.naturelife.data.model.dto

import com.google.gson.annotations.SerializedName

data class WeatherDTO(
    @SerializedName("main") var stats: WeatherStatsDTO,
    @SerializedName("weather") var descriptionList: List<WeatherDescriptionDTO>
)
