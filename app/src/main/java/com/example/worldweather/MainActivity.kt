package com.example.worldweather

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private var weatherApi: WeatherApi? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        weatherApi = WeatherManager.getInstance().createWeatherApi()

        val cities = listOf("Tokyo", "London", "Beijing", "Jerusalem")
        cities.map { printCityWeather(it) }
    }

    private fun printCityWeather(cityName: String) {
        weatherApi?.getCityWeather(cityName, WeatherManager.appId)?.enqueue(object :
            Callback<CityWeather> {
            override fun onResponse(call: Call<CityWeather>, response: Response<CityWeather>) {
                if (response.code() == 200) {
                    Log.d(
                        "getCityWeather", response.body()?.name + " : "
                                + (response.body()?.weathers?.first()?.description ?: "")
                    )
                } else {
                    Log.d("getCityWeather", response.message())
                }
            }

            override fun onFailure(call: Call<CityWeather>, t: Throwable) {
                Log.d("getCityWeather", t.stackTrace.toString())
            }
        })
    }
}
