package com.example.androidbasics2.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class AppRoute(val route: String, val label: String, val icon: ImageVector) {
    object ThirdPartialIDS2 : AppRoute("third_partial_ids2", "INCIO", Icons.Filled.School)
    object Settings : AppRoute("settings", "Ajustes", Icons.Filled.Settings)

    companion object {
        val routes = listOf(ThirdPartialIDS2, Settings)
    }
}
