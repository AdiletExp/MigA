package com.example.miga.ui.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.miga.utils.DataProvider
import com.example.miga.ui.presentation.currencyBottomSheetDetails.BehindCard
import com.example.miga.ui.presentation.currencyBottomSheetDetails.BottomButton
import com.example.miga.ui.presentation.currencyBottomSheetDetails.BoxItemValue
import com.example.miga.ui.presentation.currencyBottomSheetDetails.MainHeader
import com.example.miga.ui.theme.bottomSheetShape
import com.example.miga.ui.theme.migaColors
import kotlinx.coroutines.CoroutineScope

@ExperimentalMaterialApi
@Composable
fun CurrencyBottomSheetScreen(
    scope: CoroutineScope,
    state: ModalBottomSheetState,
    textNumber: MutableState<String>,
    textCurrency: MutableState<String>,
) {
    val scrollState = remember { mutableStateOf(true) }
    val listStateDraw = remember { mutableStateOf(false) }
    val currenciesListState = remember { DataProvider.currencyList }
    val interactionSource = remember { MutableInteractionSource() }
    val cardSizeState = remember { mutableStateOf(30.dp) }

    Surface(modifier = Modifier
        .padding(start = 20.dp, top = 30.dp, end = 20.dp, bottom = cardSizeState.value),
        shape = bottomSheetShape,
        color = migaColors.secondary) {
        LazyColumn(userScrollEnabled = scrollState.value) {
            item {
                MainHeader(modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp))
            }
            if (listStateDraw.value) itemsIndexed(currenciesListState) { _, item ->
                BoxItemValue(currencyModel = item,
                    scope, state, interactionSource,
                    textNumber, textCurrency)
            } else itemsIndexed(currenciesListState.slice(0..6)) { _, item ->
                BoxItemValue(currencyModel = item,
                    scope, state, interactionSource,
                    textNumber, textCurrency)
            }
            item {
                BottomButton(modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        if (!listStateDraw.value) {
                            listStateDraw.value = true
                            cardSizeState.value = 0.dp
                        } else {
                            listStateDraw.value = false
                            cardSizeState.value = 30.dp
                        }
                    })
            }

            item {
                BehindCard(modifier = Modifier
                    .fillMaxWidth()
                    .background(migaColors.surface))
            }
        }
    }
}
