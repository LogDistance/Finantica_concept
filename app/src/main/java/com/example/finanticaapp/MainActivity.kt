package com.example.finanticaapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.finanticaapp.components.BottomBar
import com.example.finanticaapp.naviagtion.AppNavigation
import com.example.finanticaapp.screens.home.HomeScreen
import com.example.finanticaapp.ui.theme.FinanticaAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()

            Scaffold(
                containerColor = Color.Transparent,
                bottomBar = { BottomBar(
                    navController = navController
                ) }
            ) { innerPadding ->
                AppNavigation(navController = navController,innerPadding)
            }

        }
    }
}


