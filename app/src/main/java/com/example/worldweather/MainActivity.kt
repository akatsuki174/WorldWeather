package com.example.worldweather

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val service = WeatherService.create()
        service.getCityWeather("Tokyo", "bc0bad98583f474e3ae5166d871415f0").enqueue(object :
            Callback<CityWeather> {
            override fun onResponse(call: Call<CityWeather>, response: Response<CityWeather>) {
                if (response.code() == 200) {
                    Log.d("getCityWeather", response.body()?.name + " : "
                            + (response.body()?.weathers?.first()?.description ?: ""))
                } else {
                    Log.d("getCityWeather", response.message())
                }
            }
            override fun onFailure(call: Call<CityWeather>, t: Throwable) {
                Log.d("getCityWeather", t.message)
            }
        })
    }

}
