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
package com.example.androiddevchallenge.util

import com.example.androiddevchallenge.R

fun getWeatherIcon(weatherCode: Int) = when {
    weatherCode / 100 == 2 -> {
        R.drawable.ic_storm_weather
    }
    weatherCode / 100 == 3 -> {
        R.drawable.ic_rainy_weather
    }
    weatherCode / 100 == 6 -> {
        R.drawable.ic_snow_weather
    }
    weatherCode / 100 == 7 -> {
        R.drawable.ic_unknown
    }
    weatherCode == 800 -> {
        R.drawable.ic_clear_day
    }
    weatherCode == 801 -> {
        R.drawable.ic_few_clouds
    }
    weatherCode == 803 -> {
        R.drawable.ic_broken_clouds
    }
    weatherCode == 802 -> {
        R.drawable.ic_cloudy_weather
    }
    else -> R.drawable.ic_unknown
}

fun getWeatherLottie(weatherCode: Int) = when {
    weatherCode / 100 == 2 -> {
        R.raw.storm_weather
    }
    weatherCode / 100 == 3 -> {
        R.raw.rainy_weather
    }
    weatherCode / 100 == 6 -> {
        R.raw.snow_weather
    }
    weatherCode / 100 == 7 -> {
        R.drawable.ic_unknown
    }
    weatherCode == 800 -> {
        R.raw.clear_day
    }
    weatherCode == 801 -> {
        R.raw.few_clouds
    }
    weatherCode == 803 -> {
        R.raw.broken_clouds
    }
    weatherCode == 802 -> {
        R.raw.cloudy_weather
    }
    else -> R.drawable.ic_unknown
}
