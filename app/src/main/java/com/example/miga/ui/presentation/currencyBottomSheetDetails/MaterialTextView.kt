package com.example.miga.ui.presentation.currencyBottomSheetDetails

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.miga.ui.theme.migaColors

@Composable
fun MaterialTextView(
    modifier: Modifier,
    currencyModel: Double,
) {
    Box(modifier = modifier.size(100.dp, 50.dp), contentAlignment = Alignment.Center) {
        Text(text = currencyModel.toString(),
            color = migaColors.primary,
            fontSize = 20.sp)
    }
}