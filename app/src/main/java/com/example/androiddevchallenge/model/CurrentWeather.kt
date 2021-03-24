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
package com.example.androiddevchallenge.model

data class CurrentWeather(
    val id: Int,
    val day: Int,
    val description: String,
    val weatherCode: Int,
    val humidity: Int,
    val temp: Int,
    val minTemp: Int,
    val maxTemp: Int,
    val windSpeed: Int,
    val color: Int,
    val hourlyWeather: List<HourlyWeather>
)
