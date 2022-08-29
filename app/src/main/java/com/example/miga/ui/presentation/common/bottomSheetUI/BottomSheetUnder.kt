package com.example.miga.ui.presentation.common.bottomSheetUI

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@ExperimentalComposeUiApi
@Composable
internal fun BottomSheetUnder(
    visible: Boolean,
    porchesValue: MutableState<Number>,
    saleValue: MutableState<Number>,
    statusStartAndEnd: MutableState<Boolean>,
    newSaleValue: MutableState<Number>,
    newPorchesValue: MutableState<Number>,
) {
    val coroutineScope = rememberCoroutineScope()

    val porchesValueLogic: MutableState<Number> = remember { mutableStateOf(0) }
    val salesValueLogic: MutableState<Number> = remember { mutableStateOf(0) }

  /*  val new = saleValue.value.toInt()
    Log.d("Se11", "BottomSheetUnder: $new")
    val new1 = porchesValue.value.toInt()
    Log.d("Se11", "BottomSheetUnder: $new1")*/

    if (statusStartAndEnd.value) {
        LaunchedEffect(key1 = porchesValueLogic.value) {
            coroutineScope.launch {
                if (porchesValueLogic.value != 0) {
                    saleValue.value = porchesValue.value.toDouble() * newSaleValue.value.toDouble()
                }
            }
        }
        LaunchedEffect(key1 = salesValueLogic.value) {
            coroutineScope.launch {
                if (porchesValueLogic.value != 0) {
                    porchesValue.value =
                        saleValue.value.toDouble() / newPorchesValue.value.toDouble()
                }
            }
        }
    } else {
        LaunchedEffect(key1 = porchesValueLogic.value) {
            coroutineScope.launch {
                if (porchesValueLogic.value != 0) {
                    saleValue.value = porchesValue.value.toDouble() * newSaleValue.value.toDouble()
                }
            }
        }
        LaunchedEffect(key1 = salesValueLogic.value) {
            coroutineScope.launch {
                if (porchesValueLogic.value != 0) {
                    porchesValue.value =
                        saleValue.value.toDouble() / newPorchesValue.value.toDouble()
                }
            }
        }
    }

    Row(horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically) {
        EditTextComposable(modifier = Modifier
            .weight(1f)
            .padding(15.dp), porchesValueLogic, Icons.Default.DateRange, visible, porchesValue)
        EditTextComposable(modifier = Modifier
            .weight(1f)
            .padding(15.dp), salesValueLogic, Icons.Default.Create, visible, saleValue)
    }
}