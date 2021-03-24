/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.BottomSheetState
import androidx.compose.material.BottomSheetValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.mock.getCurrentWeather
import com.example.androiddevchallenge.mock.getFiveDayWeather
import com.example.androiddevchallenge.ui.component.CurrentWeatherCard
import com.example.androiddevchallenge.ui.component.FiveDayListItem
import com.example.androiddevchallenge.ui.component.WeatherBottomSheetContent
import com.example.androiddevchallenge.ui.theme.MyTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun WeatherScreen() {
    val currentWeather = getCurrentWeather()
    val selectedWeather = mutableStateOf(currentWeather)
    Surface(color = MaterialTheme.colors.background) {
        Box {
            val bottomSheetScaffoldState = rememberBottomSheetScaffoldState(
                bottomSheetState = BottomSheetState(BottomSheetValue.Collapsed)
            )
            val coroutineScope = rememberCoroutineScope()
            BottomSheetScaffold(
                scaffoldState = bottomSheetScaffoldState,
                sheetContent = {
                    WeatherBottomSheetContent(selectedWeather = selectedWeather.value)
                },
                sheetPeekHeight = 0.dp
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = stringResource(R.string.current_weather_label),
                        style = MaterialTheme.typography.subtitle1,
                        modifier = Modifier.padding(top = 16.dp)
                    )
                    Box(
                        Modifier
                            .padding(start = 8.dp)
                            .clickable(
                                onClick = {
                                    coroutineScope.launch {
                                        selectedWeather.value = currentWeather
                                        if (bottomSheetScaffoldState.bottomSheetState.isCollapsed) {
                                            bottomSheetScaffoldState.bottomSheetState.expand()
                                        } else {
                                            bottomSheetScaffoldState.bottomSheetState.collapse()
                                        }
                                    }
                                }
                            )
                    ) {
                        CurrentWeatherCard(currentWeather)
                    }

                    Text(
                        text = stringResource(R.string.next_4_days_label),
                        style = MaterialTheme.typography.subtitle1,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )

                    LazyRow {
                        items(getFiveDayWeather()) { item ->
                            Box(
                                Modifier
                                    .padding(start = 8.dp)
                                    .clickable(
                                        onClick = {
                                            coroutineScope.launch {
                                                selectedWeather.value = item
                                                if (bottomSheetScaffoldState.bottomSheetState.isCollapsed) {
                                                    bottomSheetScaffoldState.bottomSheetState.expand()
                                                } else {
                                                    bottomSheetScaffoldState.bottomSheetState.collapse()
                                                }
                                            }
                                        }
                                    )
                            ) {
                                FiveDayListItem(weather = item)
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun PreviewWeatherScreenLight() {
    MyTheme {
        WeatherScreen()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun PreviewWeatherScreenDark() {
    MyTheme(darkTheme = true) {
        WeatherScreen()
    }
}
