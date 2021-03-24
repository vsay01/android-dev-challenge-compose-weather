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
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.semantics.SemanticsProperties
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.mock.getCurrentWeather
import com.example.androiddevchallenge.model.CurrentWeather
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.shapes
import com.example.androiddevchallenge.util.Constants
import com.example.androiddevchallenge.util.getWeatherLottie

@Composable
fun WeatherBottomSheetContent(selectedWeather: CurrentWeather) {
    val a11yBottomSheetCard = String.format(
        stringResource(R.string.five_day_a11y),
        Constants.DAYS_OF_WEEK[selectedWeather.day],
        selectedWeather.temp,
        selectedWeather.description
    )
    Surface(
        shape = shapes.medium,
        color = Color(selectedWeather.color),
        modifier = Modifier
            .fillMaxHeight(0.85f)
            .semantics(mergeDescendants = true) {
                this[SemanticsProperties.ContentDescription] = a11yBottomSheetCard
            }
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = Constants.DAYS_OF_WEEK[selectedWeather.day],
                style = MaterialTheme.typography.h2,
                color = MyTheme.colors.textColor.value
            )
            Spacer(modifier = Modifier.height(16.dp))
            LottieLoader(
                modifier = Modifier.size(84.dp),
                resId = getWeatherLottie(selectedWeather.weatherCode)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = selectedWeather.description,
                style = MaterialTheme.typography.subtitle1,
                color = MyTheme.colors.textColor.value
            )
            Spacer(modifier = Modifier.height(16.dp))
            Row {
                Column(
                    modifier = Modifier
                        .padding(start = 16.dp, end = 24.dp)
                        .weight(1f),
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
                            selectedWeather.minTemp
                        )
                    )
                    Text(
                        text = String.format(
                            stringResource(R.string.temp),
                            selectedWeather.minTemp
                        ),
                        style = MaterialTheme.typography.h3,
                        color = MyTheme.colors.textColor.value,
                        modifier = Modifier.paddingFromBaseline(24.dp)
                    )
                }
                Text(
                    text = String.format(stringResource(R.string.temp), selectedWeather.temp),
                    style = MaterialTheme.typography.h2,
                    color = MyTheme.colors.textColor.value,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(top = 16.dp, bottom = 8.dp)
                        .weight(1f)
                )
                Column(
                    modifier = Modifier
                        .padding(start = 24.dp, end = 16.dp)
                        .weight(1f),
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
                            selectedWeather.maxTemp
                        )
                    )
                    Text(
                        text = String.format(
                            stringResource(R.string.temp),
                            selectedWeather.maxTemp
                        ),
                        style = MaterialTheme.typography.h3,
                        color = MyTheme.colors.textColor.value,
                        modifier = Modifier.paddingFromBaseline(24.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Surface(
                shape = shapes.large,
                color = Color.White,
                modifier = Modifier.padding(16.dp)
            ) {
                LazyRow {
                    items(selectedWeather.hourlyWeather) { item ->
                        HourDayListItem(hourlyWeather = item)
                    }
                }
            }
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun PreviewWeatherBottomSheetContentLight() {
    MyTheme {
        WeatherBottomSheetContent(getCurrentWeather())
    }
}
