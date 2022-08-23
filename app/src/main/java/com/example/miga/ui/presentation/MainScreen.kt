package com.example.miga.ui.presentation

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.miga.ui.presentation.navigationUI.*
import com.example.miga.ui.theme.migaColors
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

@ExperimentalMaterialApi
@ExperimentalPagerApi
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val tabs = listOf(TabItem.Currency, TabItem.NearestPoints)
    val pagerState = rememberPagerState()

    Surface(modifier = Modifier
        .fillMaxHeight()) {
        val drawerState = rememberDrawerState(DrawerValue.Closed)
        val scope = rememberCoroutineScope()
        val openDrawer = { scope.launch { drawerState.open() } }
        DrawerContent(
            navController = navController,
            drawerState = drawerState,
            scope = scope,
            openDrawer = openDrawer,
            tabs,
            pagerState)
    }
}

@ExperimentalPagerApi
@Composable
fun DrawerContent(
    navController: NavHostController,
    drawerState: DrawerState,
    scope: CoroutineScope,
    openDrawer: () -> Job,
    tabs: List<TabItem>,
    pagerState: PagerState,
) {
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
            startDestination = DrawerScreens.Currency.route,
            builder = {
                composable(DrawerScreens.Currency.route) {
                    CurrencyScreenTab(openDrawer = { openDrawer() }, tabs, pagerState)
                }
                composable(DrawerScreens.Account.route) {
                    NearestPointsScreenTab(openDrawer = { openDrawer() }, tabs, pagerState)
                }
            }
        )
    }
}


@ExperimentalPagerApi
@Composable
fun Tabs(tabs: List<TabItem>, pagerState: PagerState) {
    val scope = rememberCoroutineScope()
    TabRow(
        selectedTabIndex = pagerState.currentPage,
        backgroundColor = migaColors.surface,
        contentColor = migaColors.primary,
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(Modifier.pagerTabIndicatorOffset(pagerState, tabPositions))
        }) {
        tabs.forEachIndexed { index, tab ->
            Tab(
                text = { Text(tab.title) },
                selected = pagerState.currentPage == index,
                onClick = { scope.launch { pagerState.animateScrollToPage(index) } }
            )
        }
    }
}