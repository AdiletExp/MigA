package com.example.miga.ui.presentation.bottomSheetUI

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import com.example.miga.ui.theme.migaColors
import kotlinx.coroutines.launch

@ExperimentalComposeUiApi
@ExperimentalMaterialApi
@Composable
fun BottomSheetContent(
    textNumber: Double,
    textCurrency: MutableState<String>,
    state: ModalBottomSheetState,
    porchesValue: MutableState<Double>,
    saleValue: MutableState<Double>,
) {
    val focusManager = LocalFocusManager.current
    val coroutineScope = rememberCoroutineScope()

    if (!state.isVisible) {
        LaunchedEffect(key1 = "closeKeyboard") {
            coroutineScope.launch { focusManager.clearFocus() }
        }
    }

    Column(modifier = Modifier
        .fillMaxWidth()
        .background(migaColors.surface)) {
        BottomSheetHeader(modifier = Modifier
            .weight(1f)
            .offset(x = 30.dp)
            .clickable {
                coroutineScope.launch {
                    focusManager.clearFocus()
                    state.hide()
                }
            }, textCurrency)

        BottomSheetMiddle(textNumber)
        BottomSheetUnder(state.isVisible, porchesValue, saleValue)
    }
}