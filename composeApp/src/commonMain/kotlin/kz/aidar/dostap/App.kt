package kz.aidar.dostap

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import cafe.adriel.voyager.navigator.Navigator
import dostap.composeapp.generated.resources.Nunito_Variable
import dostap.composeapp.generated.resources.Res

import kz.aidar.dostap.presentation.screens.screens.MainScreen
import org.jetbrains.compose.resources.Font


@Composable
fun App() {
    val lightColors = MaterialTheme.colors.copy(
        primary = Color(0xFF9A56FF),
        secondary = Color(0xFFF0E5FF),
        onPrimary = Color(0xFFF5F5F5),
        primaryVariant = Color(0xFFBFBFBF),
        secondaryVariant = Color(0xFF808080),
        onSecondary = Color(0xFF7F7F7F)
    )
    val font = FontFamily(Font(resource = Res.font.Nunito_Variable))
    MaterialTheme(
        colors = lightColors
    ) {
        Navigator(
            screen = MainScreen(),
            onBackPressed = {currentScreen ->  
                true
            },
        )
    }
}