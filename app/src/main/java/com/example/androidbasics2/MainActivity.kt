package com.example.androidbasics2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.androidbasics2.ui.navigation.AppNavigation
import com.example.androidbasics2.ui.theme.AndroidBasics2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidBasics2Theme {
                AppNavigation()

            }
        }
    }
}
