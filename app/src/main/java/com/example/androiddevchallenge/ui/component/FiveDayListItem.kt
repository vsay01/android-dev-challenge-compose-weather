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

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.mock.getFiveDayWeather
import com.example.androiddevchallenge.model.CurrentWeather
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.shapes
import com.example.androiddevchallenge.util.Constants.DAYS_OF_WEEK
import com.example.androiddevchallenge.util.getWeatherLottie

@Composable
fun FiveDayListItem(weather: CurrentWeather) {
    Surface(
        shape = shapes.medium,
        color = Color(weather.color),
        modifier = Modifier
            .height(200.dp)
            .width(140.dp)
            .padding(10.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = DAYS_OF_WEEK[weather.day],
                style = MaterialTheme.typography.subtitle1,
                color = MyTheme.colors.textColor.value,
                modifier = Modifier.padding(bottom = 8.dp, top = 8.dp)
            )
            LottieLoader(
                modifier = Modifier
                    .size(44.dp)
                    .padding(bottom = 8.dp, top = 8.dp),
                resId = getWeatherLottie(weather.weatherCode)
            )
            Text(
                text = String.format(stringResource(R.string.temp), weather.temp),
                style = MaterialTheme.typography.subtitle1,
                color = MyTheme.colors.textColor.value,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Row {
                Column(
                    modifier = Modifier.padding(8.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        modifier = Modifier
                            .clip(MaterialTheme.shapes.small)
                            .size(34.dp)
                            .padding(bottom = 8.dp),
                        painter = painterResource(id = R.drawable.ic_keyboard_arrow_down_24),
                        contentDescription = String.format(
                            stringResource(R.string.min_temp_a11y),
                            weather.minTemp
                        )
                    )
                    Text(
                        text = String.format(stringResource(R.string.temp), weather.minTemp),
                        style = MaterialTheme.typography.subtitle1,
                        color = MyTheme.colors.textColor.value,
                        modifier = Modifier.paddingFromBaseline(24.dp)
                    )
                }
                Column(
                    modifier = Modifier.padding(8.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        modifier = Modifier
                            .clip(MaterialTheme.shapes.small)
                            .size(34.dp)
                            .padding(bottom = 8.dp),
                        painter = painterResource(id = R.drawable.ic_keyboard_arrow_up_24),
                        contentDescription = String.format(
                            stringResource(R.string.max_temp_a11y),
                            weather.maxTemp
                        )
                    )
                    Text(
                        text = String.format(stringResource(R.string.temp), weather.maxTemp),
                        style = MaterialTheme.typography.subtitle1,
                        color = MyTheme.colors.textColor.value,
                        modifier = Modifier.paddingFromBaseline(24.dp)
                    )
                }
            }
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreviewFiveDayListItem() {
    MyTheme {
        Surface(color = MaterialTheme.colors.secondary) {
            FiveDayListItem(getFiveDayWeather()[1])
        }
    }
}
