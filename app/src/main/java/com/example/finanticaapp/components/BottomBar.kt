package com.example.finanticaapp.components

import androidx.compose.foundation.Image
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.example.finanticaapp.R
import com.example.finanticaapp.naviagtion.Routes

data class BottomBarItem(
    val title: String,
    val iconRes: Int,
    val route: String
)

@Composable
fun BottomBar(navController: NavController) {

    val items = listOf(
        BottomBarItem("Home", R.drawable.house, Routes.HOME),
        BottomBarItem("Analytics", R.drawable.chart, Routes.ANALYTICS),
        BottomBarItem("Cards", R.drawable.credit_card, Routes.CARD)
    )


    ///// Colors
    val barColor = Color(0xFF11121C)
    val barBorderColor = Color(0xFF1E2030)
    val selectedIconColor = Color(0xFF03D68C)
    val unselectedIconColor = Color(0xFF52526A)
}
