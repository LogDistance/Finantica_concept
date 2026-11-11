package com.example.finanticaapp.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
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
        BottomBarItem("Cards", R.drawable.credit_card, Routes.CARD),
        BottomBarItem("Analytics", R.drawable.chart, Routes.ANALYTICS)
    )

    ///// Colors из макета дизайна
    val barColor = Color(0xFF11121C)
    val barBorderColor = Color(0xFF1E2030)
    val selectedIconColor = Color(0xFF03D68C)       // Неоново-мятный акцент
    val selectedPillColor = Color(0xFF0F282A)       // Тёмно-бирюзовый фон активной плашки
    val unselectedColor = Color(0xFF52526A)         // Серо-сизый неактивный цвет

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .navigationBarsPadding()
            .padding(horizontal = 14.dp, vertical = 12.dp),
        color = barColor,
        border = BorderStroke(1.dp, barBorderColor),
        tonalElevation = 0.dp,
        shape = RoundedCornerShape(32.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 6.dp, vertical = 6.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            items.forEach { item ->
                val isSelected = currentRoute == item.route || (currentRoute == null && item.route == Routes.HOME)
                val interactionSource = remember { MutableInteractionSource() }

                // Плавная анимация цвета иконки и фона плашки
                val contentColor by animateColorAsState(
                    targetValue = if (isSelected) selectedIconColor else unselectedColor,
                    label = "contentColor"
                )
                val pillBackground by animateColorAsState(
                    targetValue = if (isSelected) selectedPillColor else Color.Transparent,
                    label = "pillBackground"
                )

                Box(
                    modifier = Modifier
                        .weight(1f)
                        .clip(RoundedCornerShape(32.dp))
                        .background(pillBackground)
                        .clickable(
                            interactionSource = interactionSource,
                            indication = null // Без стандартного серого блика
                        ) {
                            if (currentRoute != item.route) {
                                navController.navigate(item.route) {
                                    popUpTo(Routes.HOME) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            }
                        }
                        .padding(vertical = 8.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Icon(
                            painter = painterResource(item.iconRes),
                            contentDescription = item.title,
                            tint = contentColor,
                            modifier = Modifier.size(24.dp)
                        )
                        Text(
                            text = item.title,
                            color = contentColor,
                            fontSize = 14.sp,
                            fontWeight = if (isSelected) FontWeight.SemiBold else FontWeight.Normal,
                            modifier = Modifier.padding(top = 2.dp)
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF0F131D)
@Composable
fun BottomBarPreview() {
    val navController = rememberNavController()
    BottomBar(navController = navController)
}
