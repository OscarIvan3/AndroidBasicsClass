package com.example.androidbasics2.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class AppRoute(val route: String, val label: String, val icon: ImageVector) {
    object Login : AppRoute("login", "Login", Icons.Filled.Settings) // No se usa en el bottomBar
    object ThirdPartialIDS2 : AppRoute("third_partial_ids2", "INICIO", Icons.Filled.School)
    object PersonalInfo : AppRoute("personal_info", "Perfil", Icons.Filled.Person)
    object Settings : AppRoute("settings", "Ajustes", Icons.Filled.Settings)
    
    companion object {
        // Solo estas aparecerán en las pestañas de abajo
        val routes = listOf(ThirdPartialIDS2, PersonalInfo, Settings)
    }
}
