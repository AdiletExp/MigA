package com.example.miga.ui.presentation.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.LocalOverscrollConfiguration
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.miga.R
import com.example.miga.ui.presentation.currencyBottomSheetDetails.BehindCard
import com.example.miga.ui.presentation.currencyBottomSheetDetails.BottomButton
import com.example.miga.ui.presentation.currencyBottomSheetDetails.BoxItemValue
import com.example.miga.ui.presentation.currencyBottomSheetDetails.MainHeader
import com.example.miga.ui.theme.bottomSheetShape
import com.example.miga.ui.theme.migaColors
import com.example.miga.utils.DataProvider
import kotlinx.coroutines.launch

@ExperimentalFoundationApi
@ExperimentalMaterialApi
@Composable
fun CurrencyBottomSheetScreen(
    state: ModalBottomSheetState,
    textNumber: MutableState<Double>,
    textCurrency: MutableState<String>,
    porchesValue: MutableState<Number>,
    saleValue: MutableState<Number>,
    statusStartAndEnd: MutableState<Boolean>,
    newPorchesValue: MutableState<Number>,
    newSaleValue: MutableState<Number>,
) {
    val listStateDraw = remember { mutableStateOf(false) }
    val currenciesListState = remember { DataProvider.currencyList }
    val cardSizeState = remember { mutableStateOf(30.dp) }
    val buttonTextChange = remember { mutableStateOf(R.string.additional_currencies) }
    val buttonIconChange = remember { mutableStateOf(Icons.Default.ArrowDropDown) }
    val coroutineScope = rememberCoroutineScope()

    Surface(modifier = Modifier
        .padding(start = 20.dp, top = 30.dp, end = 20.dp, bottom = cardSizeState.value),
        shape = bottomSheetShape,
        color = migaColors.secondary) {
        CompositionLocalProvider(LocalOverscrollConfiguration provides null) {
            LazyColumn {
                item { MainHeader(modifier = Modifier.padding(top = 20.dp)) }
                if (listStateDraw.value) itemsIndexed(currenciesListState) { _, item ->
                    BoxItemValue(currencyModel = item,
                        state = state,
                        textNumber = textNumber,
                        textCurrency = textCurrency,
                        porchesValue = porchesValue,
                        saleValue = saleValue,
                        statusStartAndEnd = statusStartAndEnd,
                        newPorchesValue = newPorchesValue,
                        newSaleValue = newSaleValue)
                } else itemsIndexed(currenciesListState.slice(0..6)) { _, item ->
                    BoxItemValue(currencyModel = item,
                        state = state,
                        textNumber = textNumber,
                        textCurrency = textCurrency,
                        porchesValue = porchesValue,
                        saleValue = saleValue,
                        statusStartAndEnd = statusStartAndEnd,
                        newPorchesValue = newPorchesValue,
                        newSaleValue = newSaleValue)
                }
                item {
                    BottomButton(
                        modifier = Modifier.clickable {
                            coroutineScope.launch {
                                if (!listStateDraw.value) {
                                    listStateDraw.value = true
                                    cardSizeState.value = 0.dp
                                    buttonTextChange.value = R.string.collapse_currencies
                                    buttonIconChange.value = Icons.Default.KeyboardArrowUp
                                } else {
                                    listStateDraw.value = false
                                    cardSizeState.value = 30.dp
                                    buttonTextChange.value = R.string.additional_currencies
                                    buttonIconChange.value = Icons.Default.KeyboardArrowDown
                                }
                            }
                        },
                        buttonTextChange = buttonTextChange.value,
                        buttonIconChange = buttonIconChange.value,
                    )
                }
                item { BehindCard(modifier = Modifier.background(migaColors.surface)) }
            }
        }
    }
}
