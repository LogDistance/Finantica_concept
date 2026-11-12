package com.example.finanticaapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.finanticaapp.R

data class UserInfo(
    val userInitials: String,
    val fullName: String
)

private val avatarGradient = Brush.linearGradient(
    colors = listOf(
        Color(0xFFC4B4FB),
        Color(0xFF7CECC5)
    ),
    start = Offset.Zero,
    end = Offset.Infinite
)

@Composable
fun UserHeader(
    userInfo: UserInfo,
    modifier: Modifier = Modifier,
    onProfileClick: () -> Unit = {},
    onSearchClick: () -> Unit = {},
    onNotificationClick: () -> Unit = {}
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Левая часть: Аватарка + Имя
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .clip(CircleShape)
                .clickable { onProfileClick() }
                .padding(end = 8.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(avatarGradient),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = userInfo.userInitials,
                    color = Color(0xFF12202B),
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.width(12.dp))

            Text(
                text = userInfo.fullName,
                color = Color(0xFFF2F3F7),
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )
        }

        // Правая часть: Поиск и Уведомления
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = onSearchClick) {
                Icon(
                    painter = painterResource(R.drawable.search),
                    contentDescription = "Search",
                    tint = Color(0xFFB4B6BC),
                    modifier = Modifier.size(22.dp)
                )
            }

            IconButton(onClick = onNotificationClick) {
                Icon(
                    painter = painterResource(R.drawable.notification_bell),
                    contentDescription = "Notifications",
                    tint = Color(0xFFB4B6BC),
                    modifier = Modifier.size(22.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF0F131D)
@Composable
fun UserHeaderPreview() {
    UserHeader(
        userInfo = UserInfo(
            userInitials = "MK",
            fullName = "Max K."
        )
    )
}
