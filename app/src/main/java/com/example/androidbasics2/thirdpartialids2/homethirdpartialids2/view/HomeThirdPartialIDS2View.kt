package com.example.androidbasics2.thirdpartialids2.homethirdpartialids2.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androidbasics2.thirdpartialids2.homethirdpartialids2.viewmodel.HomeThirdPartialIDS2ViewModel

@Composable
fun HomeThirdPartialIDS2View(
    viewModel: HomeThirdPartialIDS2ViewModel = viewModel()
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Pantalla Principal")
    }
}
