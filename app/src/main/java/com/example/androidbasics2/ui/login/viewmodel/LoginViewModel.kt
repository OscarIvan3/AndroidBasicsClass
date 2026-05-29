package com.example.androidbasics2.ui.login.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    var username by mutableStateOf("")
    var password by mutableStateOf("")

    fun onUsernameChange(newUsername: String) {
        username = newUsername
    }

    fun onPasswordChange(newPassword: String) {
        password = newPassword
    }

    fun login() {
        // Aquí iría la lógica de autenticación
        println("Intentando login con: $username")
    }
}
