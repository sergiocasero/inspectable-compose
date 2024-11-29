package com.sergiocasero.inspectable

import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.rememberTextMeasurer
import kotlin.random.Random

@Composable
fun Modifier.inspectable(): Modifier = this.then(
    if (LocalInspectConfig.current) {
        Modifier.flashOnRecompose()
    } else {
        Modifier
    }
)

@Composable
private fun Modifier.flashOnRecompose(): Modifier = composed {
    var recomposeCount by remember { mutableIntStateOf(0) }
    val color by remember { mutableStateOf(getRandomColor()) }
    val textMeasurer = rememberTextMeasurer()

    SideEffect {
        recomposeCount++
    }

    this.then(
        Modifier.drawWithContent {
            // First, draw the original content
            drawContent()

            // Draw a stroke around the composable
            drawRect(
                color = color,
                size = size,
            )

            drawRect(
                color = Color.White,
                size = Size(30f, 50f)
            )

            val textLayoutResult = textMeasurer.measure(
                text = recomposeCount.toString()
            )
            drawText(textLayoutResult)
        }
    )
}

fun getRandomColor(): Color {
    return Color(
        red = Random.nextFloat(),
        green = Random.nextFloat(),
        blue = Random.nextFloat(),
        alpha = 0.5f
    )
}