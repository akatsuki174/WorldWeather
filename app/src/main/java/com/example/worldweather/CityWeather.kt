package com.example.worldweather

import com.google.gson.annotations.SerializedName

data class CityWeather (
    @SerializedName("name")
    val name: String,
    @SerializedName("description")
    val description: String
)
