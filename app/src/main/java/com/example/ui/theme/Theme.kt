package com.example.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme =
  darkColorScheme(
    primary = Teal400,
    onPrimary = Teal900,
    primaryContainer = Teal900,
    onPrimaryContainer = Teal400,
    secondary = Amber400,
    onSecondary = Slate900,
    secondaryContainer = Color(0xFF78350F),
    onSecondaryContainer = Amber400,
    tertiary = Green400,
    onTertiary = Slate900,
    tertiaryContainer = Color(0xFF14532D),
    onTertiaryContainer = Green400,
    error = Red400,
    onError = Slate900,
    errorContainer = Color(0xFF7F1D1D),
    onErrorContainer = Red400,
    background = Slate900,
    onBackground = Slate50,
    surface = Slate800,
    onSurface = Slate50,
    surfaceVariant = Slate700,
    onSurfaceVariant = Slate300,
    outline = Slate600,
    outlineVariant = Slate700
  )

private val LightColorScheme =
  lightColorScheme(
    primary = Teal500,
    onPrimary = Color.White,
    primaryContainer = Color(0xFFCCFBF1), // Teal 100
    onPrimaryContainer = Teal900,
    secondary = Amber500,
    onSecondary = Color.White,
    secondaryContainer = Color(0xFFFEF3C7), // Amber 100
    onSecondaryContainer = Color(0xFF92400E), // Amber 800
    tertiary = Green500,
    onTertiary = Color.White,
    tertiaryContainer = Color(0xFFDCFCE7), // Green 100
    onTertiaryContainer = Color(0xFF166534), // Green 800
    error = Red500,
    onError = Color.White,
    errorContainer = Color(0xFFFEE2E2), // Red 100
    onErrorContainer = Color(0xFF991B1B), // Red 800
    background = Slate50,
    onBackground = Slate900,
    surface = Color.White,
    onSurface = Slate900,
    surfaceVariant = Slate100,
    onSurfaceVariant = Slate600,
    outline = Slate300,
    outlineVariant = Slate200
  )

@Composable
fun MyApplicationTheme(
  darkTheme: Boolean = isSystemInDarkTheme(),
  // Dynamic color is available on Android 12+
  dynamicColor: Boolean = false,
  content: @Composable () -> Unit,
) {
  val colorScheme =
    when {
      dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
        val context = LocalContext.current
        if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
      }

      darkTheme -> DarkColorScheme
      else -> LightColorScheme
    }

  MaterialTheme(colorScheme = colorScheme, typography = Typography, content = content)
}
