package com.example.myweatherapp.domain

import androidx.compose.runtime.MutableState
import com.example.myweatherapp.data.model.HourModel
import com.example.myweatherapp.data.retrofit.WeatherApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GetWeatherDataUseCase(private val weatherDataRepository: WeatherDataRepository) {
    fun execute(
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
    ){
        weatherDataRepository.getWeatherData(
            city, retrofit, coroutineScope,
            temp={
                temp(it)
            },
            condition={
                condition(it)
            },
            windSpeed={windSpeed(it)},
            windDir={windDir(it)},
            pressure={
                pressure(it)
            },
            humidity={
                humidity(it)
            },
            cloud={
                cloud(it)
            },
            hoursData={
                hoursData(it)
            },
            sunrise={
                sunrise(it)
            },
            sunset={
                sunset(it)
            },
            moonrise={
                moonrise(it)
            },
            moonset={
                moonset(it)
            },
            moon_phase={
                moon_phase(it)
            },
            onError={
                onError()
            }
        )
    }
}