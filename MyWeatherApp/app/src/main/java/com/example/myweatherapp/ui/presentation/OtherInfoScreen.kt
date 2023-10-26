package com.example.myweatherapp.ui.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myweatherapp.R
import com.example.myweatherapp.ui.theme.Grey
import com.example.myweatherapp.ui.theme.LightGrey

@Composable
fun OtherInfoScreen(
    windSpeed: MutableState<String>,
    windDir: MutableState<String>,
    pressure: MutableState<String>,
    humidity: MutableState<String>,
    cloud: MutableState<String>,
    sunrise: MutableState<String>,
    sunset: MutableState<String>,
    moonrise: MutableState<String>,
    moonset: MutableState<String>,
    moon_phase: MutableState<String>,
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = LightGrey),
        verticalArrangement = Arrangement.Top
    ){
        Text(text="Weather:", fontSize=23.sp, color=Color.White, modifier=Modifier.padding(start=5.dp))
        Card(
            elevation= CardDefaults.cardElevation(0.dp),
            shape= RoundedCornerShape(5.dp),
            colors= CardDefaults.cardColors(
                containerColor= Grey
            ),
            modifier= Modifier
                .padding(top=5.dp, start=5.dp, end=5.dp)
                .fillMaxWidth()
        ) {
            Row(
                modifier= Modifier
                    .padding(start = 5.dp, end = 5.dp)
                    .fillMaxWidth(),
                horizontalArrangement= Arrangement.SpaceBetween
            ){
                Row(verticalAlignment=Alignment.CenterVertically){
                    Image(painter = painterResource(
                        id= R.drawable.wind),
                        contentDescription = "Image wind",
                        modifier=Modifier.size(18.dp)
                    )
                    Spacer(Modifier.width(2.dp))
                    Text(text="Wind speed, kmh: ", color= Color.White, fontSize=18.sp, fontWeight=FontWeight.Light)
                }
                Text(text=windSpeed.value, color= Color.White, fontSize=18.sp)
            }
            Row(
                modifier= Modifier
                    .padding(start = 5.dp, end = 5.dp)
                    .fillMaxWidth(),
                horizontalArrangement= Arrangement.SpaceBetween
            ){
                Row(verticalAlignment=Alignment.CenterVertically){
                    Image(painter = painterResource(
                        id= R.drawable.wind_dir),
                        contentDescription = "Image wind_dir",
                        modifier=Modifier.size(18.dp)
                    )
                    Spacer(Modifier.width(2.dp))
                    Text(text="Wind direction: ", color= Color.White, fontSize=18.sp, fontWeight= FontWeight.Light)
                }
                Text(text=windDir.value, color= Color.White, fontSize=18.sp)
            }
            Row(
                modifier= Modifier
                    .padding(start = 5.dp, end = 5.dp)
                    .fillMaxWidth(),
                horizontalArrangement= Arrangement.SpaceBetween
            ){
                Row(verticalAlignment=Alignment.CenterVertically){
                    Image(painter = painterResource(
                        id= R.drawable.pressure),
                        contentDescription = "Image pressure",
                        modifier=Modifier.size(18.dp)
                    )
                    Spacer(Modifier.width(2.dp))
                    Text(text="Pressure, mb: ", color= Color.White, fontSize=18.sp, fontWeight=FontWeight.Light)
                }
                Text(text=pressure.value, color= Color.White, fontSize=18.sp)
            }
            Row(
                modifier= Modifier
                    .padding(start = 5.dp, end = 5.dp)
                    .fillMaxWidth(),
                horizontalArrangement= Arrangement.SpaceBetween
            ){
                Row(verticalAlignment=Alignment.CenterVertically){
                    Image(painter = painterResource(
                        id= R.drawable.humidity),
                        contentDescription = "Image humidity",
                        modifier=Modifier.size(18.dp)
                    )
                    Spacer(Modifier.width(2.dp))
                    Text(text="Humidity, %: ", color= Color.White, fontSize=18.sp, fontWeight=FontWeight.Light)
                }
                Text(text=humidity.value, color= Color.White, fontSize=18.sp)
            }
            Row(
                modifier= Modifier
                    .padding(start = 5.dp, end = 5.dp)
                    .fillMaxWidth(),
                horizontalArrangement= Arrangement.SpaceBetween
            ){
                Row(verticalAlignment=Alignment.CenterVertically){
                    Image(painter = painterResource(
                        id= R.drawable.clouds),
                        contentDescription = "Image clouds",
                        modifier=Modifier.size(18.dp)
                    )
                    Spacer(Modifier.width(2.dp))
                    Text(text="Cloud cover, %: ", color= Color.White, fontSize=18.sp, fontWeight=FontWeight.Light)
                }
                Text(text=cloud.value, color= Color.White, fontSize=16.sp)
            }
        }
        Text(text="Astro:", fontSize=23.sp, color=Color.White, modifier=Modifier.padding(start=5.dp))
        Card(
            elevation= CardDefaults.cardElevation(0.dp),
            shape= RoundedCornerShape(5.dp),
            colors= CardDefaults.cardColors(
                containerColor= Grey
            ),
            modifier= Modifier
                .padding(5.dp)
                .fillMaxWidth()
        ) {
            Row(
                modifier= Modifier
                    .padding(start = 5.dp, end = 5.dp)
                    .fillMaxWidth(),
                horizontalArrangement= Arrangement.SpaceBetween
            ){
                Row(verticalAlignment=Alignment.CenterVertically){
                    Image(painter = painterResource(
                        id= R.drawable.sunrise),
                        contentDescription = "Image sunrise",
                        modifier=Modifier.size(18.dp)
                    )
                    Spacer(Modifier.width(2.dp))
                    Text(text="Sunrise: ", color= Color.White, fontSize=18.sp, fontWeight=FontWeight.Light)
                }
                Text(text=sunrise.value, color= Color.White, fontSize=18.sp)
            }
            Row(
                modifier= Modifier
                    .padding(start = 5.dp, end = 5.dp)
                    .fillMaxWidth(),
                horizontalArrangement= Arrangement.SpaceBetween
            ){
                Row(verticalAlignment=Alignment.CenterVertically){
                    Image(painter = painterResource(
                        id= R.drawable.sunset),
                        contentDescription = "Image sunset",
                        modifier=Modifier.size(18.dp)
                    )
                    Spacer(Modifier.width(2.dp))
                    Text(text="Sunset: ", color= Color.White, fontSize=18.sp, fontWeight=FontWeight.Light)
                }
                Text(text=sunset.value, color= Color.White, fontSize=18.sp)
            }
            Row(
                modifier= Modifier
                    .padding(start = 5.dp, end = 5.dp)
                    .fillMaxWidth(),
                horizontalArrangement= Arrangement.SpaceBetween
            ){
                Row(verticalAlignment=Alignment.CenterVertically){
                    Image(painter = painterResource(
                        id= R.drawable.moonrise),
                        contentDescription = "Image moonrise",
                        modifier=Modifier.size(18.dp)
                    )
                    Spacer(Modifier.width(2.dp))
                    Text(text="Moonrise: ", color= Color.White, fontSize=18.sp, fontWeight=FontWeight.Light)
                }
                Text(text=moonrise.value, color= Color.White, fontSize=18.sp)
            }
            Row(
                modifier= Modifier
                    .padding(start = 5.dp, end = 5.dp)
                    .fillMaxWidth(),
                horizontalArrangement= Arrangement.SpaceBetween
            ){
                Row(verticalAlignment=Alignment.CenterVertically){
                    Image(painter = painterResource(
                        id= R.drawable.moonset),
                        contentDescription = "Image moonset",
                        modifier=Modifier.size(18.dp)
                    )
                    Spacer(Modifier.width(2.dp))
                    Text(text="Moonset: ", color= Color.White, fontSize=18.sp, fontWeight=FontWeight.Light)
                }
                Text(text=moonset.value, color= Color.White, fontSize=18.sp)
            }
            Row(
                modifier= Modifier
                    .padding(start = 5.dp, end = 5.dp)
                    .fillMaxWidth(),
                horizontalArrangement= Arrangement.SpaceBetween
            ){
                Row(verticalAlignment=Alignment.CenterVertically){
                    Image(painter = painterResource(
                        id= R.drawable.moonphase),
                        contentDescription = "Image moonphase",
                        modifier=Modifier.size(18.dp)
                    )
                    Spacer(Modifier.width(2.dp))
                    Text(text="Moonphase: ", color= Color.White, fontSize=18.sp, fontWeight=FontWeight.Light)
                }
                Text(text=moon_phase.value, color= Color.White, fontSize=18.sp)
            }
        }
    }
}