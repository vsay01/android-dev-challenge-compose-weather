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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.SemanticsProperties
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.mock.getCurrentWeather
import com.example.androiddevchallenge.model.HourlyWeather
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.util.getWeatherLottie

@Composable
fun HourDayListItem(hourlyWeather: HourlyWeather) {
    val a11yLabel = String.format(
        stringResource(R.string.hourly_temp_a11y),
        hourlyWeather.hour,
        hourlyWeather.description,
        hourlyWeather.temp
    )
    Row {
        Spacer(modifier = Modifier.width(16.dp))
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(end = 16.dp)
                .semantics(mergeDescendants = true) {
                    this[SemanticsProperties.ContentDescription] = a11yLabel
                }
        ) {
            Text(
                text = hourlyWeather.hour,
                style = MaterialTheme.typography.h3,
                modifier = Modifier.padding(bottom = 8.dp, top = 8.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            LottieLoader(
                modifier = Modifier
                    .size(44.dp)
                    .padding(bottom = 8.dp, top = 8.dp),
                resId = getWeatherLottie(hourlyWeather.weatherCode)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = String.format(stringResource(R.string.temp), hourlyWeather.temp),
                style = MaterialTheme.typography.h3,
                modifier = Modifier.padding(bottom = 8.dp)
            )
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreviewHourDayListItem() {
    MyTheme {
        Surface(color = MaterialTheme.colors.secondary) {
            HourDayListItem(getCurrentWeather().hourlyWeather[0])
        }
    }
}
