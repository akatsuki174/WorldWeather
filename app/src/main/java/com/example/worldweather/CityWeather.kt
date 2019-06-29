package com.example.worldweather

import com.google.gson.annotations.SerializedName

data class CityWeather(
    val coord: Coord? = null,
    @SerializedName("weather")
    val weathers: List<Weather>? = null,
    val base: String = "",
    val main: Main? = null,
    val visibility: Int = 0,
    val wind: Wind? = null,
    @SerializedName("clouds")
    val cloud: Cloud? = null,
    val dt: Int = 0,
    val sys: Sys? = null,
    val timezone: Int = 0,
    val id: Int = 0,
    val name: String = "",
    val cod: Int = 0
)

data class Coord(
    val lon: Double = 0.toDouble(),
    val lat: Double = 0.toDouble()
)

data class Main(
    val temp: Double = 0.toDouble(),
    val pressure: Int = 0,
    val humidity: Int = 0,
    val temp_min: Double = 0.toDouble(),
    val temp_max: Double = 0.toDouble()
)

data class Wind(
    val speed: Double = 0.toDouble(),
    val deg: Int = 0
)

data class Cloud(
    val all: Int = 0
)

data class Sys(
    val type: Int = 0,
    val id: Int = 0,
    val message: Double = 0.toDouble(),
    val country: String = "",
    val sunrise: Int = 0,
    val sunset: Int = 0
)

data class Weather(
    val description: String = ""
)
