package com.example.naturelife.data.model.dto

import com.google.gson.annotations.SerializedName

data class WeatherListDTO(
    @SerializedName("list") var list: List<WeatherDTO>
)
