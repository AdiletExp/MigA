package com.example.miga.ui.presentation.currencyBottomSheetDetails

import androidx.compose.foundation.layout.Box
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.example.miga.models.CurrencyModel
import com.example.miga.ui.theme.migaColors

@Composable
fun MaterialTextView(
    modifier: Modifier,
    currencyModel: CurrencyModel,
) {
    Box(modifier = modifier, contentAlignment = Alignment.Center) {
        Text(text = currencyModel.purchase.toString(),
            color = migaColors.primary,
            fontSize = 20.sp)
    }
}