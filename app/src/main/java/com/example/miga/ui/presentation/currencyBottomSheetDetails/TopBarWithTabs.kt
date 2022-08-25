package com.example.miga.ui.presentation.currencyBottomSheetDetails

import android.content.Intent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.miga.R
import com.example.miga.ui.presentation.navigationUI.TabItem
import com.example.miga.ui.theme.migaColors
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.pagerTabIndicatorOffset
import kotlinx.coroutines.launch

@Composable
internal fun TopBar(buttonIcon: ImageVector, onButtonClicked: () -> Unit) {
    val context = LocalContext.current
    TopAppBar(
        title = {
            Text(text = stringResource(R.string.network_of_exchange_offices),
                textAlign = TextAlign.Center,
                color = migaColors.primary)
            Icon(imageVector = Icons.Default.Share,
                contentDescription = stringResource(R.string.share),
                modifier = Modifier
                    .padding(start = 80.dp)
                    .clickable {
                        val sendIntent: Intent = Intent().apply {
                            action = Intent.ACTION_SEND
                            putExtra(Intent.EXTRA_TEXT, "This is my text to send.")
                            type = "text/plain"
                        }
                        val shareIntent = Intent.createChooser(sendIntent, null)
                        context.startActivity(shareIntent)
                    }, tint = migaColors.primary)
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

@ExperimentalPagerApi
@Composable
internal fun Tabs(tabs: List<TabItem>, pagerState: PagerState) {
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
