package com.example.androidbasics2.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddTask
import androidx.compose.material.icons.filled.GraphicEq
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Savings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class AppRoute(val route: String, val label: String, val icon: ImageVector) {
    object Login : AppRoute("login", "Login", Icons.Filled.Settings) // No se usa en el bottomBar
    object ThirdPartialIDS2 : AppRoute("third_partial_ids2", "Inicio", Icons.Filled.GraphicEq)
    object FirstApiRequest : AppRoute("api_request", "Ahorros", Icons.Filled.Savings)
    object PersonalInfo : AppRoute("personal_info", "Perfil", Icons.Filled.Person)
    object Settings : AppRoute("settings", "Ajustes", Icons.Filled.Settings)

    object Page3 : AppRoute("page_3", "Ayuda", Icons.Filled.AddTask)
    
    companion object {
        // Solo estas aparecerán en las pestañas de abajo
        val routes = listOf(ThirdPartialIDS2, FirstApiRequest, PersonalInfo, Settings, Page3)
    }
}
