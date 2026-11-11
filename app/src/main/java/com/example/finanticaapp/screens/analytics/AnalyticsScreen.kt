package com.example.finanticaapp.screens.analytics

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.finanticaapp.components.AppBackground

@Composable
fun AnalyticsScreen(navController: NavHostController){
    AppBackground{
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 48.dp, start = 16.dp, end = 16.dp)
        ) {
            Text(
                text = "Analytics Overview",
                style = MaterialTheme.typography.headlineMedium,
                color = Color.White
            )
        }

    }
}