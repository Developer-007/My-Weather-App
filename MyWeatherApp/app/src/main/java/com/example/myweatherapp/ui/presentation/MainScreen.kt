package com.example.myweatherapp.ui.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myweatherapp.R
import com.example.myweatherapp.ui.theme.GreyTransparent

@Composable
fun MainScreen(
    city: MutableState<String>,
    temp: MutableState<String>,
    condition: MutableState<String>,
    onClickSearch: () -> Unit,
    onClickSync: () -> Unit){
    Card(
        modifier= Modifier
            .fillMaxWidth()
            .height(150.dp)
            .paint(
                painter = painterResource(id = R.drawable.clouds_paper),
                contentScale = ContentScale.FillBounds
            ),
        shape= RectangleShape,
        elevation=CardDefaults.cardElevation(0.dp),
        colors=CardDefaults.cardColors(
            containerColor= GreyTransparent
        )
    ){
        Column(
            modifier= Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Row(
                modifier=Modifier.padding(top=18.dp).fillMaxWidth().height(18.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                IconButton(onClick = {
                    onClickSearch.invoke()
                }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_search),
                        contentDescription = "search",
                        tint=Color.White,
                        modifier=Modifier.size(18.dp)
                    )
                }
                IconButton(onClick = {
                    onClickSync.invoke()
                }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_sync),
                        contentDescription = "sync",
                        tint=Color.White,
                        modifier=Modifier.size(18.dp)
                    )
                }
            }
            Text(text=city.value, fontSize=16.sp, color= Color.White, fontWeight= FontWeight.Normal)
            Text(text=temp.value + "°C", fontSize=25.sp, color= Color.White, fontWeight= FontWeight.ExtraBold)
            Text(text=condition.value, fontSize=12.sp, color= Color.White, fontWeight= FontWeight.Light)
        }
    }
}