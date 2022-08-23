package com.example.miga.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

private val mig_transparent = Color.Transparent
private val mig_blue_200 = Color(0xFF0F64DC)
private val mig_blue_100 = Color(0xFF3882EB)
private val mig_blue_300 = Color(0xFF0862D1)
private val mig_yellow_500 = Color(0xFFD7B40F)
private val mig_gray_50 = Color(0x1C000000)

val migaColors = lightColors(
    primary = mig_blue_100,
    primaryVariant = mig_blue_200,
    secondary = mig_blue_300,
    secondaryVariant = mig_yellow_500,
    onPrimary = mig_transparent,
    onSecondary = mig_gray_50
)

val bottomSheetShape = RoundedCornerShape(
    topStart = 20.dp,
    topEnd = 20.dp,
    bottomStart = 20.dp,
    bottomEnd = 20.dp
)

@Composable
fun MigTheme(content: @Composable () -> Unit) {
    MaterialTheme(colors = migaColors) {
        content()
    }
}