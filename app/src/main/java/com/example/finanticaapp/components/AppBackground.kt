package com.example.finanticaapp.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun AppBackground(
    modifier: Modifier = Modifier,
    content: @Composable BoxScope.() -> Unit,

){
    val baseColor = Color(0xFF0F131D)

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = baseColor ),
        content = {
            Canvas(modifier = Modifier.fillMaxSize()) {
                val height = size.height
                val width = size.width

                drawCircle(
                    brush = Brush.radialGradient(
                        colors = listOf(
                            Color(0xFF6E40C9).copy(alpha = 0.35f),
                            Color(0xFF552AAB).copy(alpha = 0.15f),
                            Color.Transparent),
                        center = Offset(x = 0f, y = height * 0.85f)),
                    radius = width * 1f
                )

                drawCircle(
                    brush = Brush.radialGradient(
                        colors = listOf(
                            Color(0xFF3DA185).copy(alpha = 0.2f),
                            Color(0xFF0091A5).copy(alpha = 0.1f),
                            Color.Transparent),
                        center = Offset(x = width * 1f, y = height * 0.15f)),
                    radius = width * 1f
                )
            }
            content()
        }
    )
    }


@Preview(showBackground = true)
@Composable
fun BackgroundPreview(){
    AppBackground() { }
}


