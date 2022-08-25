package com.example.miga.ui.presentation.bottomSheetUI

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@ExperimentalComposeUiApi
@Composable
internal fun BottomSheetUnder(
    visible: Boolean,
    porchesValue: MutableState<Double>,
    saleValue: MutableState<Double>,
) {

    Row(horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically) {
        EditTextComposable(modifier = Modifier
            .weight(1f)
            .padding(15.dp), porchesValue.value, Icons.Default.DateRange, visible)
        EditTextComposable(modifier = Modifier
            .weight(1f)
            .padding(15.dp), saleValue.value, Icons.Default.Create, visible)
    }
}