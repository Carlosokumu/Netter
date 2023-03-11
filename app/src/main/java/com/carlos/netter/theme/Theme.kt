package com.carlos.netter.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColorScheme(
    primary = Purple200, secondary = Teal200,
    onSurface = Blue200,
    primaryContainer = Black,
    onPrimaryContainer = Blue200,
    surface = Color.Black,
    background = Color.Black,
    onBackground = Color.LightGray
)

private val LightColorPalette = lightColorScheme(
    primary = Color.Green,
    secondary = Teal200,
    onSurface = Blue200,
    primaryContainer = Blue200,
    onPrimaryContainer = Color.White,
    background = Color.White,


)

@Composable
fun NetterTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colorScheme = colors, typography = Typography, content = content
    )
}