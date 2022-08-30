package com.example.miga.ui.presentation.screens

import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.activity.OnBackPressedDispatcher
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.miga.R
import com.example.miga.ui.presentation.common.searchUI.*
import com.example.miga.ui.presentation.currencyBottomSheetDetails.TopBar
import com.example.miga.utils.DataProvider
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.Job

@FlowPreview
@ExperimentalCoroutinesApi
@ExperimentalAnimationApi
@ExperimentalComposeUiApi
@ExperimentalFoundationApi
@Composable
internal fun GoldBars(
    openDrawer: () -> Job,
    modifier: Modifier = Modifier) {

    //todo searchView
    val nearestPointsListState = remember { DataProvider.nearestPointsList }
    val mainViewModel: HomeViewModel = viewModel()
    val toast = LocalContext.current


    Column(
        modifier = modifier.fillMaxSize()
    ) {

        val context = LocalContext.current

        val state = rememberSearchState(
            initialResults = mainViewModel.tutorialList,
            suggestions = suggestionList,
            timeoutMillis = 600,
        ) { query: TextFieldValue ->
            mainViewModel.getTutorials(query.text)
        }

        val focusManager = LocalFocusManager.current
        val keyboardController = LocalSoftwareKeyboardController.current

        val dispatcher: OnBackPressedDispatcher =
            LocalOnBackPressedDispatcherOwner.current!!.onBackPressedDispatcher

        val backCallback = remember {
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    if (!state.focused) {
                        isEnabled = false
                        Toast.makeText(context, "Back", Toast.LENGTH_SHORT).show()
                        dispatcher.onBackPressed()
                    } else {
                        state.query = TextFieldValue("")
                        state.focused = false
                        focusManager.clearFocus()
                        keyboardController?.hide()
                    }
                }
            }
        }

        DisposableEffect(dispatcher) { // dispose/relaunch if dispatcher changes
            dispatcher.addCallback(backCallback)
            onDispose {
                backCallback.remove() // avoid leaks!
            }
        }

        SearchBar(
            query = state.query,
            onQueryChange = { state.query = it },
            onSearchFocusChange = { state.focused = it },
            onClearQuery = { state.query = TextFieldValue("") },
            onBack = { state.query = TextFieldValue("") },
            searching = state.searching,
            focused = state.focused,
            modifier = modifier
        )

        //todo this
        when (state.searchDisplay) {
            // This is initial state, first time screen is opened or no query is done
            SearchDisplay.InitialResults -> {
            }
            SearchDisplay.NoResults -> {
                Box(
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Text("❌ No Results!", fontSize = 24.sp, color = Color(0xffDD2C00))
                }
            }

            SearchDisplay.Suggestions -> {
                /* SuggestionGridLayout(suggestions = state.suggestions) {
                     var text = state.query.text
                     if (text.isEmpty()) text = it else text += " $it"
                     text.trim()
                     // Set text and cursor position to end of text
                     state.query = TextFieldValue(text, TextRange(text.length))
                 }*/
            }

            SearchDisplay.Results -> {
                /* TutorialListContent(modifier, state.searchResults, navigateToTutorial)*/
            }

            SearchDisplay.SearchInProgress -> {
                Box(
                    modifier = Modifier
                        .background(Color.White)
                        .fillMaxSize()
                )
            }
        }
    }

    CompositionLocalProvider(LocalOverscrollConfiguration provides null) {
        Column {
            TopBar(buttonIcon = Icons.Filled.Menu, onButtonClicked = { openDrawer() })
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
                            contentDescription = stringResource(R.string.location_country))
                        Text(text = item.name, modifier = Modifier.padding(20.dp))
                    }
                }
            }
        }
    }
}