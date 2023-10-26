package com.example.myweatherapp.data.repository

import androidx.compose.runtime.MutableState
import com.example.myweatherapp.data.model.HourModel
import com.example.myweatherapp.data.retrofit.WeatherApi
import com.example.myweatherapp.domain.WeatherDataRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit

class WeatherDataRepositoryImpl : WeatherDataRepository {
    override fun getWeatherData(
        city: MutableState<String>,
        retrofit: Retrofit,
        coroutineScope: CoroutineScope,
        temp: (String) -> Unit,
        condition: (String) -> Unit,
        windSpeed: (String) -> Unit,
        windDir: (String) -> Unit,
        pressure: (String) -> Unit,
        humidity: (String) -> Unit,
        cloud: (String) -> Unit,
        hoursData: (List<HourModel>) -> Unit,
        sunrise: (String) -> Unit,
        sunset: (String) -> Unit,
        moonrise: (String) -> Unit,
        moonset: (String) -> Unit,
        moon_phase: (String) -> Unit,
        onError: () -> Unit
    ) {
        val api=retrofit.create(WeatherApi::class.java)
        coroutineScope.launch{
            try{
                val weatherModel = withContext(Dispatchers.IO) {
                    api.getWeatherData(
                        "df5c5a0f512c425baf3102938231410",
                        city.value,
                        "1",
                        "no",
                        "no"
                    )
                }
                temp("${weatherModel.current.temp_c}")
                condition("${weatherModel.current.condition.text}")
                windSpeed("${weatherModel.current.wind_kph}")
                windDir("${weatherModel.current.wind_dir}")
                pressure("${weatherModel.current.pressure_mb}")
                humidity("${weatherModel.current.humidity}")
                cloud("${weatherModel.current.cloud}")

                hoursData(weatherModel.forecast.forecastday[0].hour)

                sunrise("${weatherModel.forecast.forecastday[0].astro.sunrise}")
                sunset("${weatherModel.forecast.forecastday[0].astro.sunset}")
                moonrise("${weatherModel.forecast.forecastday[0].astro.moonrise}")
                moonset("${weatherModel.forecast.forecastday[0].astro.moonset}")
                moon_phase("${weatherModel.forecast.forecastday[0].astro.moon_phase}")

            } catch(e: Exception){
                onError()
            }
        }
    }
}