package com.example.androidbasics2.ui.navigation

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
import com.example.androidbasics2.ui.login.view.LoginView
import com.example.androidbasics2.ui.thirdpartialids2.firstApiRequest.view.FirstApiRequestView
import com.example.androidbasics2.ui.thirdpartialids2.homeThirdPartialIDS2.view.HomeThirdPartialIDS2View

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    
    // Determinar si mostrar la barra inferior (No mostrar en Login)
    val showBottomBar = currentDestination?.route != AppRoute.Login.route

    Scaffold(
        bottomBar = {
            if (showBottomBar) {
                NavigationBar {
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
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = AppRoute.Login.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(AppRoute.Login.route) {
                LoginView(onLoginSuccess = {
                    navController.navigate(AppRoute.ThirdPartialIDS2.route) {
                        popUpTo(AppRoute.Login.route) { inclusive = true }
                    }
                })
            }
            composable(AppRoute.ThirdPartialIDS2.route) {
                HomeThirdPartialIDS2View(onNavigateToApi = {
                    navController.navigate(AppRoute.FirstApiRequest.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                })
            }
            composable(AppRoute.FirstApiRequest.route) {
                FirstApiRequestView()
            }
            composable(AppRoute.PersonalInfo.route) {
                PersonalInfoView()
            }
            composable(AppRoute.Settings.route) {
                SettingsView()
            }
        }
    }
}

@Composable
fun SettingsView() {
    Text(text = "Pantalla de Ajustes")
}

@Composable
fun PersonalInfoView() {
    Text(text = "Información Personal")
}
