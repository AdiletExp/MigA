package com.example.miga.ui.presentation.bottomSheetUI

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.miga.R
import com.example.miga.ui.theme.bottomSheetShape
import com.example.miga.ui.theme.migaColors
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@ExperimentalMaterialApi
@Composable
fun BottomSheetContent(
    textNumber: MutableState<String>,
    textCurrency: MutableState<String>,
    state: ModalBottomSheetState,
    scope: CoroutineScope,
) {
    val focusManager = LocalFocusManager.current
    Column(modifier = Modifier
        .fillMaxWidth()
        .background(migaColors.surface)) {
        BottomSheetHeader(modifier = Modifier
            .weight(1f)
            .offset(x = 30.dp)
            .clickable {
                scope.launch {
                    focusManager.clearFocus()
                    state.hide()
                }
            }, textCurrency)

        BottomSheetMiddle(textNumber)
        BottomSheetUnder()
    }
}

@ExperimentalMaterialApi
@Composable
private fun BottomSheetHeader(
    modifier: Modifier,
    textCurrency: MutableState<String>,
) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(start = 30.dp, top = 10.dp, end = 30.dp, bottom = 10.dp)) {
        when (textCurrency.value) {
            stringResource(R.string.usd) -> {
                textCurrency.value =
                    stringResource(R.string.american_dollar_usd) + " (${stringResource(R.string.usd)})"
            }
            stringResource(R.string.eur) -> {
                textCurrency.value =
                    stringResource(R.string.euro_eur) + " (${stringResource(R.string.eur)})"
            }
            stringResource(R.string.rub) -> {
                textCurrency.value =
                    stringResource(R.string.russian_rub) + " (${stringResource(R.string.rub)})"
            }
            stringResource(R.string.kgs) -> {
                textCurrency.value =
                    stringResource(R.string.kyrgyz_som) + " (${stringResource(R.string.kgs)})"
            }
            stringResource(R.string.gbr) -> {
                textCurrency.value =
                    stringResource(R.string.pound_sterling) + " (${stringResource(R.string.gbr)})"
            }
            stringResource(R.string.chy) -> {
                textCurrency.value =
                    stringResource(R.string.chinese_yuan) + " (${stringResource(R.string.chy)})"
            }
            stringResource(R.string.gold) -> {
                textCurrency.value =
                    stringResource(R.string.gold_bars) + " (${stringResource(R.string.gold)})"
            }
            stringResource(R.string.chf) -> {
                textCurrency.value =
                    stringResource(R.string.swiss_franc) + " (${stringResource(R.string.chf)})"
            }
            stringResource(R.string.hkd) -> {
                textCurrency.value =
                    stringResource(R.string.hong_kong_dollar) + " (${stringResource(R.string.hkd)})"
            }
            stringResource(R.string.gel) -> {
                textCurrency.value =
                    stringResource(R.string.georgian_lari) + " (${stringResource(R.string.gel)})"
            }
            stringResource(R.string.aed) -> {
                textCurrency.value =
                    stringResource(R.string.united_arab_emirates_dirhams) + " (${
                        stringResource(R.string.aed)
                    })"
            }
            stringResource(R.string.inr) -> {
                textCurrency.value =
                    stringResource(R.string.indian_rupee) + " (${stringResource(R.string.inr)})"
            }
            stringResource(R.string.cad) -> {
                textCurrency.value =
                    stringResource(R.string.canadian_dollar) + " (${stringResource(R.string.cad)})"
            }
            stringResource(R.string.myr) -> {
                textCurrency.value =
                    stringResource(R.string.malaysian_ringgit) + " (${stringResource(R.string.myr)})"
            }
            stringResource(R.string.pln) -> {
                textCurrency.value =
                    stringResource(R.string.polish_zloty) + " (${stringResource(R.string.pln)})"
            }
            stringResource(R.string.thb) -> {
                textCurrency.value =
                    stringResource(R.string.thai_baht) + " (${stringResource(R.string.thb)})"
            }
            stringResource(R.string.tryCurrencyCode) -> {
                textCurrency.value =
                    stringResource(R.string.turkish_lira) + "( ${stringResource(R.string.tryCurrencyCode)})"
            }
            stringResource(R.string.uzs) -> {
                textCurrency.value =
                    stringResource(R.string.uzbek_sum) + " (${stringResource(R.string.uzs)})"
            }
            stringResource(R.string.uah) -> {
                textCurrency.value =
                    stringResource(R.string.ukrainian_hryvnia) + " (${stringResource(R.string.uah)})"
            }
            stringResource(R.string.czk) -> {
                textCurrency.value =
                    stringResource(R.string.czech_crown) + " (${stringResource(R.string.czk)})"
            }
            stringResource(R.string.ils) -> {
                textCurrency.value =
                    stringResource(R.string.israeli_shekel) + " (${stringResource(R.string.ils)})"
            }
            stringResource(R.string.krw) -> {
                textCurrency.value =
                    stringResource(R.string.south_korean_won_100) + " (${stringResource(R.string.krw)})"
            }
            stringResource(R.string.jpy) -> {
                textCurrency.value =
                    stringResource(R.string.japanese_Yen) + " ( ${stringResource(R.string.jpy)})"
            }
        }

        Text(text = textCurrency.value, fontSize = 26.sp, modifier = Modifier
            .weight(5f)
            .offset(x = (-20).dp),
            fontWeight = FontWeight.Bold,
            color = migaColors.onBackground, maxLines = 1)
        Icon(imageVector = Icons.Default.Close,
            contentDescription = "back/cancel",
            modifier = modifier,
            tint = migaColors.onBackground)
    }
}

@Composable
private fun BottomSheetMiddle(textNumber: MutableState<String>) {
    Text(text = stringResource(R.string.according_to_the_course),
        modifier = Modifier.padding(start = 10.dp),
        color = migaColors.onBackground)
    Text(text = textNumber.value,
        fontSize = 26.sp,
        fontWeight = FontWeight.Bold,
        color = migaColors.primary, modifier = Modifier.padding(start = 10.dp))
    Row(modifier = Modifier.padding(start = 30.dp,
        top = 10.dp,
        end = 30.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically) {
        Text(text = stringResource(R.string.buy),
            modifier = Modifier
                .weight(1f)
                .padding(end = 15.dp),
            textAlign = TextAlign.Center,
            color = migaColors.onBackground)
        Text(text = stringResource(R.string.is_required),
            modifier = Modifier
                .weight(1f)
                .padding(start = 15.dp),
            textAlign = TextAlign.Center,
            color = migaColors.onBackground)
    }
}


@Composable
private fun BottomSheetUnder() {
    val porchesValue = rememberSaveable { mutableStateOf("") }
    val saleValue = rememberSaveable { mutableStateOf("") }
    Row(horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically) {
        TextField(value = porchesValue.value,
            onValueChange = { porchesValue.value = it },
            colors = TextFieldDefaults.textFieldColors(backgroundColor = migaColors.onSecondary,
                focusedIndicatorColor = migaColors.onPrimary,
                unfocusedIndicatorColor = migaColors.onPrimary,
                disabledIndicatorColor = migaColors.onPrimary,
                cursorColor = migaColors.primary),
            singleLine = true, leadingIcon = {
                Icon(imageVector = Icons.Default.ThumbUp,
                    contentDescription = "", tint = migaColors.onBackground)
            }, keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            ), modifier = Modifier
                .weight(1f)
                .padding(15.dp),
            shape = bottomSheetShape,
            textStyle = TextStyle(color = migaColors.primary, fontSize = 20.sp))
        TextField(value = saleValue.value,
            onValueChange = { saleValue.value = it },
            singleLine = true,
            colors = TextFieldDefaults.textFieldColors(backgroundColor = migaColors.onSecondary,
                focusedIndicatorColor = migaColors.onPrimary,
                unfocusedIndicatorColor = migaColors.onPrimary,
                disabledIndicatorColor = migaColors.onPrimary,
                cursorColor = migaColors.primary),
            leadingIcon = {
                Icon(imageVector = Icons.Default.Done,
                    contentDescription = "",
                    tint = migaColors.onBackground)
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number),
            modifier = Modifier
                .weight(1f)
                .padding(15.dp),
            shape = bottomSheetShape,
            textStyle = TextStyle(color = migaColors.primary, fontSize = 20.sp))
    }
}

