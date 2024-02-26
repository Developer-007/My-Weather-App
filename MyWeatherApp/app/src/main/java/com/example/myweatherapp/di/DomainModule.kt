package com.example.myweatherapp.di

import com.example.myweatherapp.domain.GetWeatherDataUseCase
import com.example.myweatherapp.domain.WeatherDataRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
class DomainModule {

    @Provides
    @ActivityScoped
    fun provideGetWeatherDataUseCase(weatherDataRepository: WeatherDataRepository): GetWeatherDataUseCase{
        return GetWeatherDataUseCase(weatherDataRepository)
    }
}

