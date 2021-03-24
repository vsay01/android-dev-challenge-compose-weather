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
package com.example.androiddevchallenge.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Stable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = blackLight,
    primaryVariant = blackLight,
    secondary = teal200,
    background = backgroundDark,
    surface = Color.Black,
    onPrimary = Color.White,
    onSecondary = Color.White,
    onBackground = Color.White,
    onSurface = Color.White
)

private val LightColorPalette = lightColors(
    primary = Color.White,
    primaryVariant = Color.White,
    secondary = teal200,
    background = backgroundLight,
    surface = Color.White,
    onPrimary = Color.Black,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black
)

private val MyLightColorPalette = MyColors(
    transparentBackground = transparentGray,
    textColor = Color.White,
    textPrimaryColor = Color.Black,
    textSecondaryColor = textSecondaryLight,
    searchBoxColor = graySearchBoxLight,
    isDark = false
)

private val MyDarkColorPalette = MyColors(
    transparentBackground = transparentWhite,
    textColor = Color.White,
    textPrimaryColor = Color.White,
    textSecondaryColor = textSecondaryDark,
    searchBoxColor = graySearchBoxDark,
    isDark = true
)

@Composable
fun MyTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {
    val (colors, customColors) = if (darkTheme) DarkColorPalette to MyDarkColorPalette else LightColorPalette to MyLightColorPalette
    ProvideMyColors(customColors) {
        MaterialTheme(
            colors = colors,
            typography = typography,
            content = content
        )
    }
}

object MyTheme {
    val colors: MyColors
        @Composable
        get() = LocalMyColors.current
}

@Composable
fun ProvideMyColors(
    colors: MyColors,
    content: @Composable () -> Unit
) {
    val colorPalette = remember { colors }
    colorPalette.update(colors)
    CompositionLocalProvider(LocalMyColors provides colorPalette, content = content)
}

private val LocalMyColors = staticCompositionLocalOf<MyColors> {
    error("No LocalMyColorsPalette provided")
}

@Stable
class MyColors(
    transparentBackground: Color,
    textColor: Color,
    textPrimaryColor: Color,
    textSecondaryColor: Color,
    searchBoxColor: Color,
    isDark: Boolean
) {
    var transparentBackground = mutableStateOf(transparentBackground)
        private set
    var textColor = mutableStateOf(textColor)
        private set
    var textPrimaryColor = mutableStateOf(textPrimaryColor)
        private set
    var textSecondaryColor = mutableStateOf(textSecondaryColor)
        private set
    var searchBoxColor = mutableStateOf(searchBoxColor)
        private set
    var isDark = mutableStateOf(isDark)
        private set

    fun update(other: MyColors) {
        transparentBackground = other.transparentBackground
        textColor = other.textColor
        textPrimaryColor = other.textPrimaryColor
        textSecondaryColor = other.textSecondaryColor
        searchBoxColor = other.searchBoxColor
        isDark = other.isDark
    }
}
