package com.example.androidbasics2.ui.login.loginview.model
data class UserCredentials(
    val username: String,
    val token: String
)

data class LoginUiState(
    val isLoading: Boolean = false,
    val usernameError: String? = null,
    val passwordError: String? = null,
    val loginError: String? = null,
    val isLoginSuccess: Boolean = false
)
