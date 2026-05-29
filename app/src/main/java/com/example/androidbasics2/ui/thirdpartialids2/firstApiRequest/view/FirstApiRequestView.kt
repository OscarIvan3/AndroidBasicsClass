package com.example.androidbasics2.ui.thirdpartialids2.firstApiRequest.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.androidbasics2.ui.thirdpartialids2.firstApiRequest.viewmodel.FirstApiRequestViewModel

@Composable
fun FirstApiRequestView(
    viewModel: FirstApiRequestViewModel = viewModel()
) {
    val students by viewModel.students.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    val error by viewModel.error.collectAsState()

    Box(modifier = Modifier.fillMaxSize()) {
        if (isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        } else if (error != null) {
            Text(
                text = "Error: $error", 
                modifier = Modifier.align(Alignment.Center), 
                color = MaterialTheme.colorScheme.error
            )
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                items(students) { student ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .padding(16.dp)
                                .fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            AsyncImage(
                                model = student.photoUrl,
                                contentDescription = "Foto de ${student.name}",
                                modifier = Modifier
                                    .size(64.dp)
                                    .clip(CircleShape),
                                contentScale = ContentScale.Crop
                            )
                            
                            Spacer(modifier = Modifier.width(16.dp))
                            
                            Column {
                                Text(text = student.name, style = MaterialTheme.typography.titleMedium)
                                Text(text = "ID: ${student.studentId}", style = MaterialTheme.typography.bodyMedium)
                                Text(text = "Hobby: ${student.hobby}", style = MaterialTheme.typography.bodySmall)
                            }
                        }
                    }
                }
            }
        }
    }
}
