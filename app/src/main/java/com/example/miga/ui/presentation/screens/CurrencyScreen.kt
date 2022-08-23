package com.example.miga.ui.presentation.screens

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
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.miga.ui.presentation.bottomSheetUI.BottomSheetContent
import com.example.miga.ui.theme.migaColors

@ExperimentalMaterialApi
@Composable
fun CurrencyScreen() {
    val modalBottomSheetState =
        rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)
    val scope = rememberCoroutineScope()
    val textNumber = remember { mutableStateOf("") }
    val textCurrency = remember { mutableStateOf("") }

    ModalBottomSheetLayout(
        sheetContent = {
            BottomSheetContent(textNumber,
                textCurrency,
                modalBottomSheetState,
                scope)
        },
        sheetState = modalBottomSheetState,
        sheetShape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
        sheetBackgroundColor = migaColors.surface,
    ) {
        Box(modifier = Modifier
            .padding()
            .background(migaColors.surface)) {
            CurrencyBottomSheetScreen(scope = scope,
                state = modalBottomSheetState,
                textNumber = textNumber,
                textCurrency = textCurrency
            )
        }
    }
}
