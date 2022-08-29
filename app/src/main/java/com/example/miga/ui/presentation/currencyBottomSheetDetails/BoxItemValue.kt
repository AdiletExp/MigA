package com.example.miga.ui.presentation.currencyBottomSheetDetails

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.miga.domain.models.CurrencyModel
import com.example.miga.ui.theme.migaColors
import kotlinx.coroutines.launch


@ExperimentalMaterialApi
@Composable
fun BoxItemValue(
    currencyModel: CurrencyModel,
    state: ModalBottomSheetState,
    textNumber: MutableState<Double>,
    textCurrency: MutableState<String>,
    porchesValue: MutableState<Number>,
    saleValue: MutableState<Number>,
    statusStartAndEnd: MutableState<Boolean>,
    newPorchesValue: MutableState<Number>,
    newSaleValue: MutableState<Number>,
) {
    val openDialog = remember { mutableStateOf(false) }
    val interactionSource = remember { MutableInteractionSource() }
    val coroutineScope = rememberCoroutineScope()

    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(start = 30.dp, top = 10.dp, end = 30.dp, bottom = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween) {
        MaterialTextView(modifier = Modifier
            .clip(RoundedCornerShape(corner = CornerSize(10.dp)))
            .border(0.dp, migaColors.onPrimary, RoundedCornerShape(corner = CornerSize(10.dp)))
            .background(migaColors.surface)
            .clickable(interactionSource = interactionSource, indication = null) {
                statusStartAndEnd.value = false
                coroutineScope.launch {

                    textNumber.value = currencyModel.sale
                    textCurrency.value = currencyModel.currency

                    if (!statusStartAndEnd.value) {
                        saleValue.value = currencyModel.sale
                        newSaleValue.value = currencyModel.sale
                        newPorchesValue.value = currencyModel.purchase
                        porchesValue.value = 1.0
                    }
                    state.show()
                }
            }, currencyModel.sale)

        TextView(modifier = Modifier
            .background(migaColors.onPrimary)
            .clickable(interactionSource = interactionSource, indication = null) {
                coroutineScope.launch { openDialog.value = true }
            }, currencyModel, openDialog)

        MaterialTextView(modifier = Modifier
            .clip(RoundedCornerShape(corner = CornerSize(10.dp)))
            .border(0.dp, migaColors.onPrimary, RoundedCornerShape(corner = CornerSize(10.dp)))
            .background(migaColors.surface)
            .clickable(interactionSource = interactionSource, indication = null) {
                statusStartAndEnd.value = true
                coroutineScope.launch {

                    textNumber.value = currencyModel.purchase
                    textCurrency.value = currencyModel.currency

                    if (statusStartAndEnd.value) {
                        porchesValue.value = currencyModel.purchase
                        newSaleValue.value = currencyModel.sale
                        newPorchesValue.value = currencyModel.purchase
                        saleValue.value = 1.0
                    }
                    state.show()
                }
            }, currencyModel.purchase)
    }
}

