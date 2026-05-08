package com.example.androidbasics2.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.androidbasics2.thirdpartialids2.homethirdpartialids2.view.HomeThirdPartialIDS2View

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    
    Scaffold(
        bottomBar = {
            NavigationBar {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination
                
                AppRoute.routes.forEach { screen ->
                    NavigationBarItem(
                        icon = { Icon(screen.icon, contentDescription = null) },
                        label = { Text(screen.label) },
                        selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                        onClick = {
                            navController.navigate(screen.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = AppRoute.ThirdPartialIDS2.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(AppRoute.ThirdPartialIDS2.route) {
                HomeThirdPartialIDS2View()
            }
            composable(AppRoute.Settings.route) {
                SettingsView()
            }
            composable(AppRoute.Pantalla2.route) {
                Pantalla2View()
            }
            composable(AppRoute.pantalla3.route) {
                Pantalla3View()
            }
            composable(AppRoute.pantalla4.route) {
                Pantalla4View()
            }

        }
    }
}

@Composable
fun SettingsView() {
    Text(text = "Pantalla de Ajustes")
}

@Composable
fun Pantalla2View() {
    Text(text = "Pantalla 2")
}

@Composable
fun Pantalla3View() {
    Text(text = "Pantalla 3")
}

@Composable
fun Pantalla4View() {
    Text(text = "Pantalla 4")
}
