package com.example.myweatherapp.di

import com.example.myweatherapp.data.repository.WeatherDataRepositoryImpl
import com.example.myweatherapp.domain.WeatherDataRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule{

    @Provides
    @Singleton
    fun provideWeatherDataRepository():WeatherDataRepository{
        return WeatherDataRepositoryImpl()
    }
}

