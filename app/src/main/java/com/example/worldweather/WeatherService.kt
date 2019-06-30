package com.example.worldweather

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {
    @GET("data/2.5/weather")
    fun getCityWeather(@Query("q") query: String, @Query("APPID") appId: String): Call<CityWeather>
}
