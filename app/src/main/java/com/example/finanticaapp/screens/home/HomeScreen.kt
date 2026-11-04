package com.example.finanticaapp.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.finanticaapp.components.AppBackground

@Composable
fun HomeScreen(navController: NavHostController){
    AppBackground {
        Column(
            modifier = Modifier.fillMaxSize()
        ) { }

    }

}