package com.example.myweatherapp.data.retrofit

import com.example.myweatherapp.data.model.WeatherDataModel
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("forecast.json")
    suspend fun getWeatherData(
        @Query("key") key: String,
        @Query("q") q: String,
        @Query("days") days: String,
        @Query("aqi") aqi: String,
        @Query("alerts") alerts: String,
    ) : WeatherDataModel
}