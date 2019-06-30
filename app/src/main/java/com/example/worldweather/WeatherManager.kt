package com.example.worldweather

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WeatherManager private constructor() {

    companion object {
        private const val baseUrl = "https://api.openweathermap.org/"

        fun getInstance(): WeatherManager {
            return WeatherManager()
        }
    }

    fun create(): WeatherService {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(
                GsonConverterFactory.create()
            )
            .baseUrl(baseUrl)
            .build()
        return retrofit.create(WeatherService::class.java)
    }

}
