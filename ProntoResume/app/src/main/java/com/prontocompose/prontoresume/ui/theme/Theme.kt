package com.prontocompose.prontoresume.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = Colors.Blue200,
    primaryVariant = Colors.Blue700,
    secondary = Colors.LightBlue200
)

private val LightColorPalette = lightColors(
    primary = Colors.Blue500,
    primaryVariant = Colors.Blue700,
    secondary = Colors.LightBlue200
)

@Composable
fun ProntoResumeTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}