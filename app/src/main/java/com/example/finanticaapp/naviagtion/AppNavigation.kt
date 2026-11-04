package com.example.finanticaapp.naviagtion

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.finanticaapp.screens.add_transaction.TransactionScreen
import com.example.finanticaapp.screens.analytics.AnalyticsScreen
import com.example.finanticaapp.screens.cards_screen.CardsScreen
import com.example.finanticaapp.screens.home.HomeScreen
import com.example.finanticaapp.screens.settings.SettingsScreen

@Composable
fun AppNavigation(
    navController: NavHostController,
    paddingValues: PaddingValues
) {
    NavHost(navController = navController, startDestination = Routes.HOME) {
        composable(Routes.HOME) { HomeScreen(navController) }
        composable(Routes.CARD) { CardsScreen(navController) }
        composable(Routes.ANALYTICS) { AnalyticsScreen(navController) }
        composable(Routes.TRANSACTION) { TransactionScreen(navController) }
        composable(Routes.SETTINGS) { SettingsScreen(navController) }

    }
}
