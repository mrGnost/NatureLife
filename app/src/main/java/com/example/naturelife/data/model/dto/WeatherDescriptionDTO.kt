package com.example.naturelife.data.model.dto

import com.google.gson.annotations.SerializedName

data class WeatherDescriptionDTO(
    @SerializedName("main") var main: String,
    @SerializedName("description") var description: String,
    @SerializedName("icon") var iconCode: String
)
