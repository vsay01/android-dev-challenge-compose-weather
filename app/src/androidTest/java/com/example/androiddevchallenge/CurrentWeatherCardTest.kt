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
package com.example.androiddevchallenge

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.androiddevchallenge.mock.getCurrentWeather
import com.example.androiddevchallenge.ui.component.CurrentWeatherCard
import com.example.androiddevchallenge.ui.theme.MyTheme
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CurrentWeatherCardTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    private val currentWeather = getCurrentWeather()

    /*@Test
    fun test_if_view_exist_correctly() {
        composeTestRule.setContent {
            MyTheme {
                CurrentWeatherCard(currentWeather = currentWeather)
            }
        }

        val currentWeatherStr = composeTestRule.activity.getString(R.string.temp, currentWeather.temp)
        composeTestRule.onNodeWithText(currentWeatherStr).assertIsDisplayed()

        composeTestRule.onNodeWithText(currentWeather.description).assertIsDisplayed()

        val humidityStr = composeTestRule.activity.getString(R.string.humidity, currentWeather.humidity)
        composeTestRule.onNodeWithText(humidityStr).assertIsDisplayed()

        val windStr = composeTestRule.activity.getString(R.string.wind_speed, currentWeather.windSpeed)
        composeTestRule.onNodeWithText(windStr).assertIsDisplayed()
    }*/
}
