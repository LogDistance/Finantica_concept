package com.example.finanticaapp.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.finanticaapp.components.AppBackground
import com.example.finanticaapp.components.UserHeader
import com.example.finanticaapp.components.UserInfo

@Composable
fun HomeScreen(navController: NavHostController) {
    AppBackground {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
        ) {
            UserHeader(
                userInfo = UserInfo(
                    userInitials = "MK",
                    fullName = "Max K."
                ),
                onProfileClick = { },
                onSearchClick = { },
                onNotificationClick = { }
            )

            Spacer(modifier = Modifier.height(22.dp))

            Row(
                modifier = Modifier.fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically

                ) {
                Text(text = "TOTAL BALANCE",
                fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.Gray)
            }
        }
    }
}