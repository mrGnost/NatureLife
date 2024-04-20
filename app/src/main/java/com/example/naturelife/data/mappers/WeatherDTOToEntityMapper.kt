package com.example.naturelife.data.mappers

import com.example.naturelife.data.model.dto.WeatherListDTO
import com.example.naturelife.domain.Mapper
import com.example.naturelife.domain.model.SingleWeather
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WeatherDTOToEntityMapper @Inject constructor() : Mapper<WeatherListDTO, SingleWeather>() {
    override fun mapFrom(from: WeatherListDTO): SingleWeather = SingleWeather(
            type = from.list.firstOrNull()?.descriptionList?.firstOrNull()?.main,
            description = from.list.firstOrNull()?.descriptionList?.firstOrNull()?.description,
            temperature = from.list.firstOrNull()?.stats?.temperature,
            feelsLike = from.list.firstOrNull()?.stats?.feelsLike,
            iconCode = from.list.firstOrNull()?.descriptionList?.firstOrNull()?.iconCode
        )
}