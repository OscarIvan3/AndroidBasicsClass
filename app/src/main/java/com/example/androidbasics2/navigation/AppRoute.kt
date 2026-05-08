package com.example.androidbasics2.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Accessibility
import androidx.compose.material.icons.filled.Adjust
import androidx.compose.material.icons.filled.Savings
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class AppRoute(val route: String, val label: String, val icon: ImageVector) {
    object ThirdPartialIDS2 : AppRoute("third_partial_ids2", "INCIO", Icons.Filled.School)
    object Settings : AppRoute("settings", "Ajustes", Icons.Filled.Settings)
    object Pantalla2 : AppRoute("pantalla2", "Pantalla 2", Icons.Filled.Savings)
    object pantalla3 : AppRoute("Pantalla3", "pantalla 3 ", Icons.Filled.Accessibility)
    object pantalla4 : AppRoute( "Pantalla4", "pantalla 4", Icons.Filled.Adjust)

    companion object {
        val routes = listOf(ThirdPartialIDS2, Settings, Pantalla2, pantalla3, pantalla4)
    }
}
