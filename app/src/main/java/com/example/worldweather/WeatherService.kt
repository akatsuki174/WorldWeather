package com.example.worldweather

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.concurrent.TimeUnit

interface WeatherService {
    @GET("data/2.5/weather")
    fun getCityWeather(@Query("q") query: String, @Query("APPID") appId: String): Call<CityWeather>

    companion object {
        fun create(): WeatherService {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(
                    GsonConverterFactory.create())
                .baseUrl("https://api.openweathermap.org/")
                .build()
            return retrofit.create(WeatherService::class.java)
        }
    }
}

