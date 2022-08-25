package com.example.miga.ui.presentation.alertDialogUI

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.miga.R
import com.example.miga.ui.theme.migaColors

@Composable
fun AlertDialogForTextView(openDialog: MutableState<Boolean>, text: MutableState<String>) {
    if (openDialog.value) {
        AlertDialog(
            modifier = Modifier.padding(top = 600.dp),
            onDismissRequest = { openDialog.value = false },
            backgroundColor = migaColors.onPrimary,
            buttons = {
                Column(modifier = Modifier.background(migaColors.onPrimary),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally) {
                    Button(onClick = { openDialog.value = false },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        colors = ButtonDefaults.buttonColors(backgroundColor = migaColors.onSurface),
                        shape = RoundedCornerShape(20.dp)) {
                        when (text.value) {
                            stringResource(R.string.usd) -> {
                                text.value = stringResource(R.string.american_dollar_usd)
                            }
                            stringResource(R.string.eur) -> {
                                text.value = stringResource(R.string.euro_eur)
                            }
                            stringResource(R.string.rub) -> {
                                text.value = stringResource(R.string.russian_rub)
                            }
                            stringResource(R.string.kgs) -> {
                                text.value = stringResource(R.string.kyrgyz_som)
                            }
                            stringResource(R.string.gbr) -> {
                                text.value = stringResource(R.string.pound_sterling)
                            }
                            stringResource(R.string.chy) -> {
                                text.value = stringResource(R.string.chinese_yuan)
                            }
                            stringResource(R.string.gold) -> {
                                text.value = stringResource(R.string.gold_bars_1gr)
                            }
                            stringResource(R.string.chf) -> {
                                text.value = stringResource(R.string.swiss_franc)
                            }
                            stringResource(R.string.hkd) -> {
                                text.value = stringResource(R.string.hong_kong_dollar)
                            }
                            stringResource(R.string.gel) -> {
                                text.value = stringResource(R.string.georgian_lari)
                            }
                            stringResource(R.string.aed) -> {
                                text.value = stringResource(R.string.united_arab_emirates_dirhams)
                            }
                            stringResource(R.string.inr) -> {
                                text.value = stringResource(R.string.indian_rupee)
                            }
                            stringResource(R.string.cad) -> {
                                text.value = stringResource(R.string.canadian_dollar)
                            }
                            stringResource(R.string.myr) -> {
                                text.value = stringResource(R.string.malaysian_ringgit)
                            }
                            stringResource(R.string.pln) -> {
                                text.value = stringResource(R.string.polish_zloty)
                            }
                            stringResource(R.string.thb) -> {
                                text.value = stringResource(R.string.thai_baht)
                            }
                            stringResource(R.string.tryCurrencyCode) -> {
                                text.value = stringResource(R.string.turkish_lira)
                            }
                            stringResource(R.string.uzs) -> {
                                text.value = stringResource(R.string.uzbek_sum)
                            }
                            stringResource(R.string.uah) -> {
                                text.value = stringResource(R.string.ukrainian_hryvnia)
                            }
                            stringResource(R.string.czk) -> {
                                text.value = stringResource(R.string.czech_crown)
                            }
                            stringResource(R.string.ils) -> {
                                text.value = stringResource(R.string.israeli_shekel)
                            }
                            stringResource(R.string.krw) -> {
                                text.value = stringResource(R.string.south_korean_won_100)
                            }
                            stringResource(R.string.jpy) -> {
                                text.value = stringResource(R.string.japanese_Yen)
                            }
                        }
                        if (text.value == stringResource(R.string.gold_bars_1gr)) Text(text = text.value,
                            color = migaColors.secondaryVariant)
                        else Text(text = text.value, color = migaColors.surface)
                    }
                    Button(onClick = { openDialog.value = false },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(65.dp)
                            .padding(top = 15.dp),
                        colors = ButtonDefaults.buttonColors(backgroundColor = migaColors.background),
                        shape = RoundedCornerShape(20.dp)) {
                        Text(text = stringResource(R.string.cancel))
                    }
                }
            })
    }
}

