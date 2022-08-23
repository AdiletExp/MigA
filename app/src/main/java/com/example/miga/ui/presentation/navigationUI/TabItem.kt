package com.example.miga.ui.presentation.navigationUI

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import com.example.miga.ui.presentation.screens.CurrencyScreen
import com.example.miga.ui.presentation.screens.NearestPointsScreen

typealias ComposableFun = @Composable () -> Unit

sealed class TabItem(var title: String, var screen: ComposableFun) {
    @ExperimentalMaterialApi
    object Currency : TabItem("КУРСЫ ВАЛЮТ", { CurrencyScreen() })
    object NearestPoints : TabItem("БЛИЖАЙШИЕ ПУНКТЫ", { NearestPointsScreen() })
}