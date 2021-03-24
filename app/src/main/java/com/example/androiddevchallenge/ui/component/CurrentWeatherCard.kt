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
package com.example.androiddevchallenge.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.model.CurrentWeather
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.shapes
import com.example.androiddevchallenge.util.getWeatherLottie

@Composable
fun CurrentWeatherCard(currentWeather: CurrentWeather) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = shapes.medium,
        color = Color(currentWeather.color)
    ) {
        Column(
            modifier = Modifier.padding(8.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = String.format(stringResource(R.string.temp), currentWeather.temp),
                style = MaterialTheme.typography.h1,
                color = MyTheme.colors.textColor.value
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = currentWeather.description,
                style = MaterialTheme.typography.subtitle1,
                color = MyTheme.colors.textColor.value
            )
            Spacer(modifier = Modifier.height(16.dp))
            Spacer(modifier = Modifier.height(16.dp))
            Row {
                Column(
                    Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = String.format(
                            stringResource(R.string.humidity),
                            currentWeather.humidity
                        ),
                        style = MaterialTheme.typography.subtitle1,
                        color = MyTheme.colors.textColor.value
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = String.format(
                            stringResource(R.string.wind_speed),
                            currentWeather.windSpeed
                        ),
                        style = MaterialTheme.typography.subtitle1,
                        color = MyTheme.colors.textColor.value
                    )
                }
                Spacer(modifier = Modifier.width(24.dp))
                LottieLoader(
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .size(94.dp),
                    getWeatherLottie(weatherCode = currentWeather.weatherCode)
                )
            }
        }
    }
}
