package com.example.myweatherapp.domain

import androidx.compose.runtime.MutableState
import com.example.myweatherapp.data.model.HourModel
import kotlinx.coroutines.CoroutineScope
import retrofit2.Retrofit

interface WeatherDataRepository {
    fun getWeatherData(
        city: MutableState<String>,
        retrofit: Retrofit,
        coroutineScope: CoroutineScope,
        temp : (String) -> Unit,
        condition : (String) -> Unit,
        windSpeed : (String) -> Unit,
        windDir : (String) -> Unit,
        pressure : (String) -> Unit,
        humidity : (String) -> Unit,
        cloud : (String) -> Unit,
        hoursData : (List<HourModel>) -> Unit,
        sunrise : (String) -> Unit,
        sunset: (String) -> Unit,
        moonrise: (String) -> Unit,
        moonset: (String) -> Unit,
        moon_phase: (String) -> Unit,
        onError: () -> Unit
    )
}