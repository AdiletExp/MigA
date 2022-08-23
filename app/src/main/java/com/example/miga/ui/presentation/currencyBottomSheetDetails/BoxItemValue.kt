package com.example.miga.ui.presentation.currencyBottomSheetDetails

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.miga.models.CurrencyModel
import com.example.miga.ui.theme.migaColors
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@ExperimentalMaterialApi
@Composable
fun BoxItemValue(
    currencyModel: CurrencyModel,
    scope: CoroutineScope,
    state: ModalBottomSheetState,
    interactionSource: MutableInteractionSource,
    textNumber: MutableState<String>,
    textCurrency: MutableState<String>,
) {
    val openDialog = remember { mutableStateOf(false) }

    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(start = 30.dp, top = 10.dp, end = 30.dp, bottom = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically) {
        MaterialTextView(modifier = Modifier
            .size(100.dp, 50.dp)
            .clip(RoundedCornerShape(corner = CornerSize(10.dp)))
            .border(0.dp, migaColors.onPrimary, RoundedCornerShape(corner = CornerSize(10.dp)))
            .background(migaColors.surface)
            .clickable(interactionSource = interactionSource, indication = null) {
                scope.launch {
                    textNumber.value = currencyModel.purchase.toString()
                    textCurrency.value = currencyModel.currency
                    state.show()
                }
            }, currencyModel)

        TextView(modifier = Modifier
            .size(70.dp, 40.dp)
            .background(migaColors.onPrimary)
            .clickable(interactionSource = interactionSource, indication = null) {
                scope.launch { openDialog.value = true }
            }, currencyModel, openDialog)

        MaterialTextView(modifier = Modifier
            .size(100.dp, 50.dp)
            .clip(RoundedCornerShape(corner = CornerSize(10.dp)))
            .border(0.dp, migaColors.onPrimary, RoundedCornerShape(corner = CornerSize(10.dp)))
            .background(migaColors.surface)
            .clickable(interactionSource = interactionSource, indication = null) {
                scope.launch {
                    textNumber.value = currencyModel.purchase.toString()
                    textCurrency.value = currencyModel.currency
                    state.show()
                }
            }, currencyModel)
    }
}

