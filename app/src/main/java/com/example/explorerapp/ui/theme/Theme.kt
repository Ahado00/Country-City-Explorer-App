package com.example.explorerapp.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp


val GreenPrimary = Color(0xFF33573B) // Dark Green (Used in Country List)
val LightBackground = Color(0xFFFFFFFF) // White
val DarkBackground = Color(0xFF121212) // Dark Theme Background
val LightSurface = Color(0xFFE6E6E6) // Light Gray (for cards)
val DarkSurface = Color(0xFF1E1E1E) // Dark mode card background
val TextPrimary = Color(0xFFF1F1F1) // Light Text

// Define custom colors for dark and dark themes
private val DarkColorScheme = darkColorScheme(
    primary = GreenPrimary,
    onPrimary = Color.White,
    background = DarkBackground,
    surface = DarkSurface,
    onSurface = TextPrimary
)


// Define custom colors for light and dark themes
private val LightColorScheme = lightColorScheme(
    primary = GreenPrimary,
    onPrimary = Color.White,
    background = LightBackground,
    surface = LightSurface,
    onSurface = Color.Black

)

private val AppTypography = Typography(
    bodyLarge = TextStyle(
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold
    ),
    bodyMedium = TextStyle(
        fontSize = 16.sp,
        fontWeight = FontWeight.Medium
    ),
    bodySmall = TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.Light
    ),
    titleLarge = TextStyle(
        fontSize = 28.sp,
        fontWeight = FontWeight.Bold
    )
)


@Composable
fun ExplorerAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        content = content
    )
}
