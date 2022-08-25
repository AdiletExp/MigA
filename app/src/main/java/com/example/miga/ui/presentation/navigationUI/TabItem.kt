package com.example.miga.ui.presentation.navigationUI

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import com.example.miga.ui.presentation.currencyBottomSheetDetails.Tabs
import com.example.miga.ui.presentation.currencyBottomSheetDetails.TopBar
import com.example.miga.ui.presentation.screens.CurrencyScreen
import com.example.miga.ui.presentation.screens.NearestPointsScreen
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.Job

typealias ComposableFun = @Composable () -> Unit

enum class TabItem(var title: String, var screen: ComposableFun) {
    @ExperimentalComposeUiApi
    @ExperimentalFoundationApi
    @ExperimentalMaterialApi
    Currency("КУРСЫ ВАЛЮТ", { CurrencyScreen() }),

    @ExperimentalFoundationApi
    NearestPoints("БЛИЖАЙШИЕ ПУНКТЫ", { NearestPointsScreen() });
}

@ExperimentalPagerApi
@Composable
 internal fun CurrencyScreenTab(
    openDrawer: () -> Unit,
    tabs: List<TabItem>,
) {
    val pagerState = rememberPagerState()
    Column {
        TopBar(buttonIcon = Icons.Filled.Menu, onButtonClicked = { openDrawer() })
        Tabs(tabs = tabs, pagerState = pagerState)
        HorizontalPager(state = pagerState, count = tabs.size) { page ->
            tabs[page].screen()
        }
    }
}

@ExperimentalPagerApi
@Composable
internal fun NearestPointsScreenTab(openDrawer: () -> Job, tabs: List<TabItem>) {
    val pagerState = rememberPagerState()
    Column {
        TopBar(buttonIcon = Icons.Filled.Menu, onButtonClicked = { openDrawer() })
        Tabs(tabs = tabs, pagerState = pagerState)
        HorizontalPager(state = pagerState, count = tabs.size) { page ->
            tabs[page].screen()
        }
    }
}