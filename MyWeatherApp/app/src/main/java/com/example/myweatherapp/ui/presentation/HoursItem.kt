package com.example.myweatherapp.ui.presentation

import android.graphics.fonts.FontStyle
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.myweatherapp.data.model.HourModel
import com.example.myweatherapp.ui.theme.Grey
import com.example.myweatherapp.ui.theme.LightBLue
import com.example.myweatherapp.ui.theme.LightGrey

@Composable
fun HoursItem(hours: HourModel){
    Card(
        elevation= CardDefaults.cardElevation(0.dp),
        shape= RoundedCornerShape(5.dp),
        colors= CardDefaults.cardColors(
            containerColor= Grey
        ),
        modifier= Modifier
            .padding(top=5.dp)
            .fillMaxWidth(),
    ){
        Row(
            modifier= Modifier
                .padding(5.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            Column(horizontalAlignment=Alignment.Start){
                Text(text=hours.time, color= Color.White, fontSize=12.sp, fontWeight= FontWeight.Bold)
                Text(text=hours.condition.text, color= Color.White, fontSize=10.sp, fontWeight=FontWeight.Light)
            }
            Text(text="${hours.temp_c}°C", color= Color.White, fontSize=25.sp, fontWeight= FontWeight.ExtraBold)
            AsyncImage(
                model = "https:${hours.condition.icon}",
                contentDescription = "weather",
                modifier=Modifier.size(35.dp))
        }
    }
}