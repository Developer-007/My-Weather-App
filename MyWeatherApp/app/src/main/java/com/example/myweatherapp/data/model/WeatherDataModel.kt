package com.example.myweatherapp.data.model

data class WeatherDataModel(
    val location: LocalModel,
    val current: CurrentModel,
    val forecast: ForecastModel
)

data class LocalModel(
    val name: String
)

data class CurrentModel(
    val temp_c: Float,
    val condition: ConditionModel,
    val wind_kph: Float,
    val wind_dir: String,
    val pressure_mb: Float,
    val humidity: Int,
    val cloud: Int,
)

data class ConditionModel(
    val text: String,
    val icon: String
)
data class ForecastModel(
    val forecastday: List<ForecastDayModel>
)
data class ForecastDayModel(
    val astro: AstroModel,
    val hour: List<HourModel>
)
data class HourModel(
    val time: String,
    val temp_c: Float,
    val condition: ConditionModel
)
data class AstroModel(
    val sunrise: String,
    val sunset: String,
    val moonrise: String,
    val moonset: String,
    val moon_phase: String
)
