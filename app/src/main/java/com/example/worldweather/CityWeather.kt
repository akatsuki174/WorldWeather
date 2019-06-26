package com.example.worldweather

import com.google.gson.annotations.SerializedName

data class CityWeather(
    @SerializedName("name")
    val name: String,
    @SerializedName("weather")
    val weather: List<Weather>
)

data class Weather(
    @SerializedName("description")
    val description: String
)
