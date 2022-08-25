package com.example.miga.ui.presentation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.miga.ui.presentation.navigationUI.*
import com.example.miga.ui.presentation.screens.GoldBars
import com.example.miga.ui.theme.migaColors
import com.google.accompanist.pager.ExperimentalPagerApi
import kotlinx.coroutines.launch

@ExperimentalComposeUiApi
@ExperimentalFoundationApi
@ExperimentalMaterialApi
@ExperimentalPagerApi
@Composable
fun MainScreen() {
    Surface(modifier = Modifier.fillMaxHeight()) {
        DrawerContent()
    }
}

@ExperimentalMaterialApi
@ExperimentalFoundationApi
@ExperimentalComposeUiApi
@ExperimentalPagerApi
@Composable
private fun DrawerContent() {
    val tabs = listOf(TabItem.Currency, TabItem.NearestPoints)
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val openDrawer = { scope.launch { drawerState.open() } }
    val navController = rememberNavController()
    ModalDrawer(
        drawerState = drawerState,
        gesturesEnabled = drawerState.isOpen,
        drawerBackgroundColor = migaColors.surface,
        drawerContent = {
            Drawer(
                onDestinationClicked = { route ->
                    scope.launch { drawerState.close() }
                    navController.navigate(route) {
                        navController.graph.startDestinationId
                        launchSingleTop = true
                    }
                }
            )
        }
    )
    {
        NavHost(
            navController = navController,
            startDestination = DrawerScreens.GoldBars.route,
            builder = {
                composable(DrawerScreens.Currency.route) {
                    CurrencyScreenTab(openDrawer = { openDrawer() }, tabs)
                }
                composable(DrawerScreens.Account.route) {
                    NearestPointsScreenTab(openDrawer = { openDrawer() }, tabs)
                }
                composable(DrawerScreens.GoldBars.route) {
                    GoldBars { openDrawer() }
                }
            }
        )
    }
}
