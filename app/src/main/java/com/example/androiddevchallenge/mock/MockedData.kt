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
package com.example.androiddevchallenge.mock

import com.example.androiddevchallenge.model.CurrentWeather
import com.example.androiddevchallenge.model.HourlyWeather
import com.example.androiddevchallenge.util.Constants.WEATHER_COLOR

fun getCurrentWeather() = CurrentWeather(
    1, 2, "clear weather", 800, 58, 12, 10, 14, 4, WEATHER_COLOR[0].toInt(),
    listOf(
        HourlyWeather("01:00", "clear weather", 800, 8),
        HourlyWeather("04:00", "clear weather", 800, 6),
        HourlyWeather("07:00", "clear weather", 800, 5),
        HourlyWeather("10:00", "cloudy weather", 802, 8),
        HourlyWeather("13:00", "clear weather", 800, 12),
        HourlyWeather("16:00", "clear weather", 800, 14),
        HourlyWeather("19:00", "cloudy weather", 802, 8),
        HourlyWeather("22:00", "cloudy weather", 802, 8)
    )
)

fun getFiveDayWeather() = listOf(
    CurrentWeather(
        2, 3, "rainy weather", 300, 40, 11, 9, 12, 6, WEATHER_COLOR[1].toInt(),
        listOf(
            HourlyWeather("01:00", "clear weather", 800, 8),
            HourlyWeather("04:00", "rainy weather", 300, 6),
            HourlyWeather("07:00", "clear weather", 800, 5),
            HourlyWeather("10:00", "cloudy weather", 802, 8),
            HourlyWeather("13:00", "clear weather", 800, 12),
            HourlyWeather("16:00", "rainy weather", 300, 14),
            HourlyWeather("19:00", "cloudy weather", 802, 8),
            HourlyWeather("22:00", "rainy weather", 300, 11)
        )
    ),
    CurrentWeather(
        3, 4, "storm weather", 200, 30, 15, 10, 15, 8, WEATHER_COLOR[2].toInt(),
        listOf(
            HourlyWeather("01:00", "storm weather", 200, 8),
            HourlyWeather("04:00", "few cloud weather", 801, 6),
            HourlyWeather("07:00", "clear weather", 800, 5),
            HourlyWeather("10:00", "cloudy weather", 802, 8),
            HourlyWeather("13:00", "storm weather", 800, 12),
            HourlyWeather("16:00", "clear weather", 800, 14),
            HourlyWeather("19:00", "storm weather", 200, 12),
            HourlyWeather("22:00", "storm weather", 200, 11)
        )
    ),
    CurrentWeather(
        4, 5, "snow weather", 600, 50, 3, 1, 10, 12, WEATHER_COLOR[3].toInt(),
        listOf(
            HourlyWeather("01:00", "clear weather", 800, 8),
            HourlyWeather("04:00", "clear weather", 800, 6),
            HourlyWeather("07:00", "snow weather", 600, 5),
            HourlyWeather("10:00", "cloudy weather", 802, 8),
            HourlyWeather("13:00", "clear weather", 800, 12),
            HourlyWeather("16:00", "snow weather", 600, 14),
            HourlyWeather("19:00", "snow weather", 600, 12),
            HourlyWeather("22:00", "snow weather", 600, 11)
        )
    ),
    CurrentWeather(
        5, 6, "clear weather", 800, 44, 20, 15, 25, 4, WEATHER_COLOR[0].toInt(),
        listOf(
            HourlyWeather("01:00", "clear weather", 800, 8),
            HourlyWeather("04:00", "clear weather", 800, 6),
            HourlyWeather("07:00", "clear weather", 800, 5),
            HourlyWeather("10:00", "cloudy weather", 802, 8),
            HourlyWeather("13:00", "clear weather", 800, 12),
            HourlyWeather("16:00", "clear weather", 800, 14),
            HourlyWeather("19:00", "cloudy weather", 802, 8),
            HourlyWeather("22:00", "cloudy weather", 802, 8)
        )
    )
)
