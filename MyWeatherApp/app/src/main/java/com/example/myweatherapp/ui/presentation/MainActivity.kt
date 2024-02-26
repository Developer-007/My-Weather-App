package com.example.myweatherapp.ui.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myweatherapp.R
import com.example.myweatherapp.data.model.CurrentModel
import com.example.myweatherapp.data.model.HourModel
import com.example.myweatherapp.data.model.WeatherDataModel
import com.example.myweatherapp.data.repository.WeatherDataRepositoryImpl
import com.example.myweatherapp.data.retrofit.WeatherApi
import com.example.myweatherapp.domain.GetWeatherDataUseCase
import com.example.myweatherapp.domain.WeatherDataRepository
import com.example.myweatherapp.ui.theme.Grey
import com.example.myweatherapp.ui.theme.MyWeatherAppTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("CoroutineCreationDuringComposition")

    @Inject
    lateinit var getWeatherDataUseCase: GetWeatherDataUseCase

    @SuppressLint("UnrememberedMutableState")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val hoursListState = mutableStateListOf<HourModel>()
            val temp = remember{
                mutableStateOf("")
            }
            val city = remember{
                mutableStateOf("Moscow")
            }
            val condition = remember{
                mutableStateOf("")
            }
            val retrofit = Retrofit.Builder()
                .baseUrl("https://api.weatherapi.com/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            val coroutineScope = rememberCoroutineScope()
            val windSpeed = remember{
                mutableStateOf("")
            }
            val windDir = remember{
                mutableStateOf("")
            }
            val pressure = remember{
                mutableStateOf("")
            }
            val humidity = remember{
                mutableStateOf("")
            }
            val cloud = remember{
                mutableStateOf("")
            }
            val sunrise = remember{
                mutableStateOf("")
            }
            val sunset = remember{
                mutableStateOf("")
            }
            val moonrise = remember{
                mutableStateOf("")
            }
            val moonset = remember{
                mutableStateOf("")
            }
            val moon_phase = remember{
                mutableStateOf("")
            }
            val DialogState=remember{
                mutableStateOf(false)
            }
            hoursListState.clear()
            getWeatherDataUseCase.execute(city, retrofit, coroutineScope,
                temp={temp.value=it},
                condition={condition.value=it},
                windSpeed={windSpeed.value=it},
                windDir={windDir.value=it},
                pressure={
                    pressure.value=it
                },
                humidity={
                    humidity.value=it
                },
                cloud={
                    cloud.value=it
                },
                hoursData={
                    hoursListState.addAll(it)
                },
                sunrise={
                    sunrise.value=it
                },
                sunset={
                    sunset.value=it
                },
                moonrise={
                    moonrise.value=it
                },
                moonset={
                    moonset.value=it
                },
                moon_phase={
                    moon_phase.value=it
                },
                onError={
                    Toast.makeText(this@MainActivity, "Error! Check the Internet Connection", Toast.LENGTH_LONG)
                }
            )
            Scaffold(
                topBar={
                    TopAppBar(
                        colors=TopAppBarDefaults.topAppBarColors(
                            containerColor= Grey
                        ),
                        title={
                            Text(text="My Weather App", color= Color.White)
                        }
                    )
                }
            ){
                Column(modifier= Modifier
                    .padding(it)
                    .fillMaxSize()){
                    MainScreen(city, temp, condition, onClickSearch = {
                        DialogState.value=true
                    },
                        onClickSync={
                            hoursListState.clear()
                            getWeatherDataUseCase.execute(city, retrofit, coroutineScope,
                                temp={temp.value=it},
                                condition={condition.value=it},
                                windSpeed={windSpeed.value=it},
                                windDir={windDir.value=it},
                                pressure={
                                    pressure.value=it
                                },
                                humidity={
                                    humidity.value=it
                                },
                                cloud={
                                    cloud.value=it
                                },
                                hoursData={
                                    hoursListState.addAll(it)
                                },
                                sunrise={
                                    sunrise.value=it
                                },
                                sunset={
                                    sunset.value=it
                                },
                                moonrise={
                                    moonrise.value=it
                                },
                                moonset={
                                    moonset.value=it
                                },
                                moon_phase={
                                    moon_phase.value=it
                                },
                                onError={
                                    Toast.makeText(this@MainActivity, "Error! Check the Internet Connection", Toast.LENGTH_LONG)
                                }
                            )
                        })
                    TabLayout(hoursListState, windSpeed, windDir, pressure, humidity, cloud, sunrise, sunset, moonrise, moonset, moon_phase)
                    if(DialogState.value){
                        CityAlertDialog(DialogState, onSubmit={
                            city.value=it
                            hoursListState.clear()
                            getWeatherDataUseCase.execute(city, retrofit, coroutineScope,
                                temp={temp.value=it},
                                condition={condition.value=it},
                                windSpeed={windSpeed.value=it},
                                windDir={windDir.value=it},
                                pressure={
                                    pressure.value=it
                                },
                                humidity={
                                    humidity.value=it
                                },
                                cloud={
                                    cloud.value=it
                                },
                                hoursData={
                                    hoursListState.addAll(it)
                                },
                                sunrise={
                                    sunrise.value=it
                                },
                                sunset={
                                    sunset.value=it
                                },
                                moonrise={
                                    moonrise.value=it
                                },
                                moonset={
                                    moonset.value=it
                                },
                                moon_phase={
                                    moon_phase.value=it
                                },
                                onError={
                                    Toast.makeText(this@MainActivity, "Error! Check the Internet Connection", Toast.LENGTH_LONG)
                                }
                            )
                        })
                    }
                }
            }
        }
    }
}
