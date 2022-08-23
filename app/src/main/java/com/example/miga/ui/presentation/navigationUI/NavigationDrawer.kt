package com.example.miga.ui.presentation.navigationUI

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.miga.R
import com.example.miga.ui.presentation.Tabs
import com.example.miga.ui.theme.migaColors
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState

@ExperimentalPagerApi
@Composable
fun CurrencyScreenTab(
    openDrawer: () -> Unit,
    tabs: List<TabItem>,
    pagerState: PagerState,
) {
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
fun NearestPointsScreenTab(openDrawer: () -> Unit, tabs: List<TabItem>, pagerState: PagerState) {
    Column {
        TopBar(buttonIcon = Icons.Filled.Menu, onButtonClicked = { openDrawer() })
        Tabs(tabs = tabs, pagerState = pagerState)
        HorizontalPager(state = pagerState, count = tabs.size) { page ->
            tabs[page].screen()
        }
    }
}

@Composable
fun TopBar(buttonIcon: ImageVector, onButtonClicked: () -> Unit) {
    TopAppBar(
        title = {
            Text(text = stringResource(R.string.network_of_exchange_offices),
                modifier = Modifier.padding(start = 30.dp),
                textAlign = TextAlign.Center,
                color = migaColors.primary)
            Icon(imageVector = Icons.Default.Share,
                contentDescription = stringResource(R.string.share),
                modifier = Modifier.padding(start = 50.dp), tint = migaColors.primary)
        },
        navigationIcon = {
            IconButton(onClick = { onButtonClicked() }) {
                Icon(buttonIcon,
                    contentDescription = stringResource(R.string.menu),
                    tint = migaColors.primary)
            }
        },
        backgroundColor = migaColors.surface
    )
}