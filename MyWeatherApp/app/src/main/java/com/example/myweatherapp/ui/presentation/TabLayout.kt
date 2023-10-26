package com.example.myweatherapp.ui.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.myweatherapp.data.model.HourModel
import com.example.myweatherapp.ui.theme.Grey
import com.example.myweatherapp.ui.theme.LightGrey
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabLayout(
    hoursListState: MutableList<HourModel>,
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
    val tabList=listOf("Hour Data", "Other Info")
    val pagerState=rememberPagerState()
    val tabIndex = pagerState.currentPage
    val coroutineScope= rememberCoroutineScope()
    Column(modifier=Modifier.background(LightGrey)){
        TabRow(
            modifier=Modifier.padding(start=5.dp, end=5.dp, top=5.dp),
            selectedTabIndex = tabIndex,
            indicator={pos ->
                      TabRowDefaults.Indicator(
                          Modifier.pagerTabIndicatorOffset(pagerState, pos)
                      )
            },
            backgroundColor = Grey,
            contentColor= Color.White
        ) {
            tabList.forEachIndexed { index, text ->
                Tab(
                    selected = false,
                    onClick = {
                              coroutineScope.launch{
                                  pagerState.animateScrollToPage(index)
                              }
                },
                    text={
                        Text(text=text)
                    }
                )
            }
        }
        HorizontalPager(
            count = tabList.size,
            state=pagerState,
            modifier=Modifier.weight(1.0f)
        ) {
            index ->
            when(index){
                0->HourScreen(hoursListState)
                1->OtherInfoScreen(windSpeed, windDir, pressure, humidity, cloud, sunrise, sunset, moonrise, moonset, moon_phase)
            }
        }
    }
}