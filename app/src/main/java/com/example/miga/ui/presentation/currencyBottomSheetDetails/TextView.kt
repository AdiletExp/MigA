package com.example.miga.ui.presentation.currencyBottomSheetDetails

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.miga.R
import com.example.miga.models.CurrencyModel
import com.example.miga.ui.presentation.alertDialogUI.AlertDialogForTextView
import com.example.miga.ui.theme.migaColors

@Composable
fun TextView(
    modifier: Modifier,
    currencyModel: CurrencyModel,
    openDialog: MutableState<Boolean>,
) {
    val openDialogText = remember { mutableStateOf(currencyModel.currency) }
    AlertDialogForTextView(openDialog = openDialog, text = openDialogText)

    Box(modifier = modifier, contentAlignment = Alignment.Center) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            if (currencyModel.currency == stringResource(R.string.gold)) {
                Text(text = currencyModel.currency,
                    textAlign = TextAlign.Center,
                    color = migaColors.secondaryVariant,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp)
            } else {
                Text(text = currencyModel.currency,
                    textAlign = TextAlign.Center,
                    color = migaColors.surface,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp)
            }
            if (currencyModel.currencyExtension != null) {
                Text(text = currencyModel.currencyExtension, textAlign = TextAlign.Center,
                    color = migaColors.secondaryVariant,
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp)
            }
        }
    }
}