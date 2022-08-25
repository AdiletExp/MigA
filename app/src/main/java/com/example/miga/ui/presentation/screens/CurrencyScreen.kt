package com.example.miga.ui.presentation.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.miga.ui.presentation.bottomSheetUI.BottomSheetContent
import com.example.miga.ui.theme.migaColors

@ExperimentalComposeUiApi
@ExperimentalFoundationApi
@ExperimentalMaterialApi
@Composable
internal fun CurrencyScreen() {
    val modalBottomSheetState =
        rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)
    val textNumber = remember { mutableStateOf(0.0) }
    val textCurrency = remember { mutableStateOf("") }

    val porchesValue = rememberSaveable { mutableStateOf(0.0) }
    val saleValue = rememberSaveable { mutableStateOf(0.0) }

    ModalBottomSheetLayout(
        sheetContent = {
            BottomSheetContent(textNumber = textNumber.value,
                textCurrency = textCurrency,
                state = modalBottomSheetState,
                porchesValue = porchesValue,
                saleValue = saleValue)
        },
        sheetState = modalBottomSheetState,
        sheetShape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
        sheetBackgroundColor = migaColors.surface
    ) {
        Box(modifier = Modifier
            .padding()
            .background(migaColors.surface)) {
            CurrencyBottomSheetScreen(
                state = modalBottomSheetState,
                textNumber = textNumber,
                textCurrency = textCurrency,
                porchesValue = porchesValue,
                saleValue = saleValue
            )
        }
    }
}
