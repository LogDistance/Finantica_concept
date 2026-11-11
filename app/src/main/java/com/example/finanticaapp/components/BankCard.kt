package com.example.finanticaapp.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

///// Main Card Colors
val MainMintStart = Color(0xFFB2F0D9)
val MainMiddleEnd = Color(0xFF95D7D3)
val VioletEndMain = Color(0xFF9570FC)

///// Text & Icons
val TextPrimary = Color(0xFF12202B)
val VisaColor = Color(0xFF303359)

////// Chip
val ChipBackground = Color(0xFFCBEBD2)
val ChipBorder = Color(0xFFADCFB9)

///// BackCards Color
val BackCard1 = Color(0xFF3B3F52)
val BackCard2 = Color(0xFF302E41)

///// Card Gradient
val FrontGradient = Brush.linearGradient(
    colors = listOf(MainMintStart, MainMiddleEnd, VioletEndMain),
    start = Offset(0f, 350f),
    end = Offset(850f, 0f)
)

data class CardCredentials(
    val cardHolderName: String,
    val cardNumber: String,
    val debitOrCredit: String,
    val bankingName: String
)

@Composable
fun BankCard(
    credentials: CardCredentials,
    modifier: Modifier = Modifier
) {
    val cardShape = RoundedCornerShape(24.dp)
    val cardWidth = 310.dp
    val cardHeight = 180.dp

    // Внешний модификатор `modifier` применяем ТОЛЬКО к корневому Box
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .width(cardWidth + 24.dp)
                .height(cardHeight),
            contentAlignment = Alignment.CenterStart
        ) {
            // Дальняя задняя карта (чуть ниже по высоте для 3D-эффекта стопки)
            Box(
                modifier = Modifier
                    .width(cardWidth)
                    .height(cardHeight - 28.dp)
                    .offset(x = 22.dp)
                    .clip(cardShape)
                    .background(BackCard2)
                    .border(1.dp, Color.White.copy(alpha = 0.08f), cardShape)
            )

            // Средняя задняя карта
            Box(
                modifier = Modifier
                    .width(cardWidth)
                    .height(cardHeight - 14.dp)
                    .offset(x = 11.dp)
                    .clip(cardShape)
                    .background(BackCard1)
                    .border(1.dp, Color.White.copy(alpha = 0.12f), cardShape)
            )

            ///// MainCard (Передняя главная карта)
            Box(
                modifier = Modifier
                    .size(cardWidth, cardHeight)
                    .clip(cardShape)
                    .background(FrontGradient)
                    .border(width = 1.dp, color = Color.White.copy(alpha = 0.25f), shape = cardShape)
            ) {
                // Тонкие декоративные линии-дуги на фоне карты
                CardWavePattern()

                // Внутренний контент карты (Верх / Середина / Низ)
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 22.dp, vertical = 20.dp),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    // 1. Верхний ряд: Название банка + иконка бесконтактной оплаты
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = credentials.bankingName,
                            color = TextPrimary,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Medium
                        )

                        ContactlessIcon(modifier = Modifier.size(22.dp))
                    }

                    // 2. Средний ряд: Чип + номер карты
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .width(34.dp)
                                .height(24.dp)
                                .clip(RoundedCornerShape(6.dp))
                                .background(ChipBackground)
                                .border(1.dp, ChipBorder, RoundedCornerShape(6.dp))
                        )

                        Spacer(modifier = Modifier.width(14.dp))

                        Text(
                            text = credentials.cardNumber,
                            color = TextPrimary,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Medium,
                            letterSpacing = 1.sp
                        )
                    }

                    // 3. Нижний ряд: Владелец + тип карты и логотип VISA
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.Bottom
                    ) {
                        Column {
                            Text(
                                text = credentials.cardHolderName.uppercase(),
                                color = TextPrimary,
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                letterSpacing = 0.5.sp
                            )
                            Text(
                                text = credentials.debitOrCredit,
                                color = TextPrimary.copy(alpha = 0.7f),
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Normal
                            )
                        }

                        Text(
                            text = "VISA",
                            color = VisaColor,
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Black,
                            fontStyle = FontStyle.Italic,
                            letterSpacing = (-1).sp
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun ContactlessIcon(modifier: Modifier = Modifier) {
    Canvas(modifier = modifier) {
        val stroke = Stroke(width = 1.8.dp.toPx(), cap = StrokeCap.Round)
        val waveColor = TextPrimary.copy(alpha = 0.75f)
        val originX = size.width * 0.12f
        val originY = size.height * 0.5f
        val baseSize = size.minDimension

        listOf(0.20f, 0.38f, 0.56f, 0.74f).forEach { factor ->
            val radius = baseSize * factor
            drawArc(
                color = waveColor,
                startAngle = -38f,
                sweepAngle = 76f,
                useCenter = false,
                style = stroke,
                topLeft = Offset(originX - radius, originY - radius),
                size = Size(radius * 2f, radius * 2f)
            )
        }
    }
}

@Composable
private fun CardWavePattern() {
    Canvas(modifier = Modifier.fillMaxSize()) {
        val lineColor = Color.White.copy(alpha = 0.14f)
        val stroke = Stroke(width = 1.dp.toPx())
        val center = Offset(size.width * 0.95f, -size.height * 0.35f)

        for (i in 1..6) {
            drawCircle(
                color = lineColor,
                radius = size.width * (0.28f + i * 0.08f),
                center = center,
                style = stroke
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF0F131D)
@Composable
fun BankCardPreview() {
    BankCard(
        credentials = CardCredentials(
            cardHolderName = "Max K.",
            cardNumber = "* 8842",
            debitOrCredit = "Platinum debit",
            bankingName = "aura"
        )
    )
}
