package com.example.miga.ui.presentation.screens

import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.miga.R
import com.example.miga.ui.presentation.currencyBottomSheetDetails.TopBar
import com.example.miga.utils.DataProvider
import kotlinx.coroutines.Job

@ExperimentalFoundationApi
@Composable
internal fun GoldBars(openDrawer: () -> Job) {
    val nearestPointsListState = remember { DataProvider.nearestPointsList }
    val toast = LocalContext.current
    CompositionLocalProvider(LocalOverscrollConfiguration provides null) {
        Column {
            TopBar(buttonIcon = Icons.Filled.Menu, onButtonClicked = { openDrawer()  })
            LazyColumn {
                itemsIndexed(nearestPointsListState) { _, item ->
                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp)
                        .background(Color.Yellow)
                        .clickable {
                            Toast
                                .makeText(toast, item.name, Toast.LENGTH_SHORT)
                                .show()
                        },
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start) {
                        Image(painter = painterResource(id = item.painter),
                            contentDescription = stringResource(
                                R.string.location_country))
                        Text(text = item.name, modifier = Modifier.padding(20.dp))
                    }
                }
            }
        }
    }
}